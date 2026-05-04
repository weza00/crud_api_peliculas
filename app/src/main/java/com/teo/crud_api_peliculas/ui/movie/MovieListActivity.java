package com.teo.crud_api_peliculas.ui.movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.teo.crud_api_peliculas.databinding.ActivityMovieListBinding;
import com.teo.crud_api_peliculas.repository.Resource;
import com.teo.crud_api_peliculas.viewmodel.MovieViewModel;

public class MovieListActivity extends AppCompatActivity {

    private ActivityMovieListBinding binding;
    private MovieViewModel viewModel;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovieListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        setupRecyclerView();
        setupFab();
        observeMovies();
    }

    private void setupRecyclerView() {
        adapter = new MovieAdapter(movie -> {
            Intent intent = new Intent(this, MovieDetailActivity.class);
            intent.putExtra("MOVIE_ID", movie.getId());
            startActivity(intent);
        });
        binding.rvMovies.setAdapter(adapter);
    }

    private void setupFab() {
        binding.fabAddMovie.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddEditMovieActivity.class);
            startActivity(intent);
        });
    }

    private void observeMovies() {
        viewModel.getMovies().observe(this, resource -> {
            if (resource != null) {
                switch (resource.status) {
                    case LOADING:
                        binding.progressBar.setVisibility(View.VISIBLE);
                        break;
                    case SUCCESS:
                        binding.progressBar.setVisibility(View.GONE);
                        adapter.setMovies(resource.data);
                        break;
                    case ERROR:
                        binding.progressBar.setVisibility(View.GONE);
                        Toast.makeText(this, resource.message, Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        observeMovies();
    }
}
