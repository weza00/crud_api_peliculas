package com.teo.crud_api_peliculas.ui.movie;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.teo.crud_api_peliculas.databinding.ActivityAddEditMovieBinding;
import com.teo.crud_api_peliculas.model.Movie;
import com.teo.crud_api_peliculas.repository.Resource;
import com.teo.crud_api_peliculas.viewmodel.MovieViewModel;

public class AddEditMovieActivity extends AppCompatActivity {

    private ActivityAddEditMovieBinding binding;
    private MovieViewModel viewModel;
    private Movie movieToEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddEditMovieBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        movieToEdit = (Movie) getIntent().getSerializableExtra("MOVIE");

        setupToolbar();
        if (movieToEdit != null) {
            fillFields();
            binding.toolbar.setTitle("Editar Película");
        }

        binding.btnSaveMovie.setOnClickListener(v -> saveMovie());
    }

    private void setupToolbar() {
        setSupportActionBar(binding.toolbar);
        binding.toolbar.setNavigationOnClickListener(v -> finish());
    }

    private void fillFields() {
        binding.etTitle.setText(movieToEdit.getTitulo());
        binding.etDirector.setText(movieToEdit.getDirector());
        binding.etYear.setText(String.valueOf(movieToEdit.getAnio()));
        binding.etDuration.setText(String.valueOf(movieToEdit.getDuracionMinutos()));
        binding.etGenre.setText(movieToEdit.getGenero());
        binding.etRating.setText(String.valueOf(movieToEdit.getCalificacion()));
    }

    private void saveMovie() {
        String title = binding.etTitle.getText().toString().trim();
        String director = binding.etDirector.getText().toString().trim();
        String yearStr = binding.etYear.getText().toString().trim();
        String durationStr = binding.etDuration.getText().toString().trim();
        String genre = binding.etGenre.getText().toString().trim();
        String ratingStr = binding.etRating.getText().toString().trim();

        if (title.isEmpty() || director.isEmpty() || yearStr.isEmpty() || durationStr.isEmpty() || genre.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }

        Movie movie = movieToEdit != null ? movieToEdit : new Movie();
        movie.setTitulo(title);
        movie.setDirector(director);
        movie.setAnio(Integer.parseInt(yearStr));
        movie.setDuracionMinutos(Integer.parseInt(durationStr));
        movie.setGenero(genre);
        movie.setCalificacion(ratingStr.isEmpty() ? 0.0 : Double.parseDouble(ratingStr));

        if (movieToEdit == null) {
            viewModel.createMovie(movie).observe(this, this::handleResponse);
        } else {
            viewModel.updateMovie(movieToEdit.getId(), movie).observe(this, this::handleResponse);
        }
    }

    private void handleResponse(Resource<Movie> resource) {
        if (resource != null) {
            switch (resource.status) {
                case SUCCESS:
                    Toast.makeText(this, "Película guardada", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                case ERROR:
                    Toast.makeText(this, resource.message, Toast.LENGTH_LONG).show();
                    break;
                case LOADING:
                    break;
            }
        }
    }
}
