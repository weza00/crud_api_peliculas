package com.teo.crud_api_peliculas.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.teo.crud_api_peliculas.model.Movie;
import com.teo.crud_api_peliculas.repository.MovieRepository;
import com.teo.crud_api_peliculas.repository.Resource;
import java.util.List;

public class MovieViewModel extends ViewModel {
    private final MovieRepository repository;

    public MovieViewModel() {
        this.repository = new MovieRepository();
    }

    public LiveData<Resource<List<Movie>>> getMovies() {
        return repository.getMovies();
    }

    public LiveData<Resource<Movie>> getMovieWithActors(int id) {
        return repository.getMovieWithActors(id);
    }

    public LiveData<Resource<Movie>> createMovie(Movie movie) {
        return repository.createMovie(movie);
    }

    public LiveData<Resource<Movie>> updateMovie(int id, Movie movie) {
        return repository.updateMovie(id, movie);
    }

    public LiveData<Resource<Void>> deleteMovie(int id) {
        return repository.deleteMovie(id);
    }
}
