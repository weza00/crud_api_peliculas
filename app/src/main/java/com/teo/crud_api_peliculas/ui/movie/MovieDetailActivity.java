package com.teo.crud_api_peliculas.ui.movie;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.teo.crud_api_peliculas.databinding.ActivityMovieDetailBinding;
import com.teo.crud_api_peliculas.model.Actor;
import com.teo.crud_api_peliculas.model.Movie;
import com.teo.crud_api_peliculas.ui.actor.AddEditActorActivity;
import com.teo.crud_api_peliculas.viewmodel.ActorViewModel;
import com.teo.crud_api_peliculas.viewmodel.MovieViewModel;

public class MovieDetailActivity extends AppCompatActivity {

    private ActivityMovieDetailBinding binding;
    private MovieViewModel movieViewModel;
    private ActorViewModel actorViewModel;
    private ActorAdapter adapter;
    private int movieId;
    private Movie currentMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovieDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        movieId = getIntent().getIntExtra("MOVIE_ID", -1);
        if (movieId == -1) {
            finish();
            return;
        }

        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        actorViewModel = new ViewModelProvider(this).get(ActorViewModel.class);

        setupToolbar();
        setupRecyclerView();
        setupButtons();
        observeMovie();
    }

    private void setupToolbar() {
        setSupportActionBar(binding.toolbar);
        binding.toolbar.setNavigationOnClickListener(v -> finish());
    }

    private void setupRecyclerView() {
        adapter = new ActorAdapter(new ActorAdapter.OnActorActionListener() {
            @Override
            public void onEditActor(Actor actor) {
                Intent intent = new Intent(MovieDetailActivity.this, AddEditActorActivity.class);
                intent.putExtra("MOVIE_ID", movieId);
                intent.putExtra("ACTOR", actor);
                startActivity(intent);
            }

            @Override
            public void onDeleteActor(Actor actor) {
                new AlertDialog.Builder(MovieDetailActivity.this)
                        .setTitle("Eliminar Actor")
                        .setMessage("¿Estás seguro de que quieres eliminar este actor?")
                        .setPositiveButton("Eliminar", (dialog, which) -> {
                            actorViewModel.deleteActor(movieId, actor.getId()).observe(MovieDetailActivity.this, resource -> {
                                if (resource != null && resource.status == com.teo.crud_api_peliculas.repository.Resource.Status.SUCCESS) {
                                    Toast.makeText(MovieDetailActivity.this, "Actor eliminado", Toast.LENGTH_SHORT).show();
                                    observeMovie(); // Refresh
                                }
                            });
                        })
                        .setNegativeButton("Cancelar", null)
                        .show();
            }
        });
        binding.rvActors.setAdapter(adapter);
    }

    private void setupButtons() {
        binding.btnEditMovie.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddEditMovieActivity.class);
            intent.putExtra("MOVIE", currentMovie);
            startActivity(intent);
        });

        binding.btnDeleteMovie.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Eliminar Película")
                    .setMessage("¿Estás seguro de que quieres eliminar esta película?")
                    .setPositiveButton("Eliminar", (dialog, which) -> {
                        movieViewModel.deleteMovie(movieId).observe(this, resource -> {
                            if (resource != null && resource.status == com.teo.crud_api_peliculas.repository.Resource.Status.SUCCESS) {
                                Toast.makeText(this, "Película eliminada", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
        });

        binding.btnAddActor.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddEditActorActivity.class);
            intent.putExtra("MOVIE_ID", movieId);
            startActivity(intent);
        });
    }

    private void observeMovie() {
        movieViewModel.getMovieWithActors(movieId).observe(this, resource -> {
            if (resource != null) {
                switch (resource.status) {
                    case SUCCESS:
                        currentMovie = resource.data;
                        displayMovieDetails(currentMovie);
                        break;
                    case ERROR:
                        Toast.makeText(this, resource.message, Toast.LENGTH_LONG).show();
                        break;
                    case LOADING:
                        break;
                }
            }
        });
    }

    private void displayMovieDetails(Movie movie) {
        binding.tvDetailTitle.setText(movie.getTitulo());
        binding.tvDetailDirector.setText(String.format("Director: %s", movie.getDirector()));
        binding.tvDetailInfo.setText(String.format("%d | %s | %d min", movie.getAnio(), movie.getGenero(), movie.getDuracionMinutos()));
        binding.tvDetailRating.setText(String.format("Calificación: %.1f/10", movie.getCalificacion()));
        adapter.setActors(movie.getActores());
    }

    @Override
    protected void onResume() {
        super.onResume();
        observeMovie();
    }
}
