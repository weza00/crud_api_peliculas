package com.teo.crud_api_peliculas.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.teo.crud_api_peliculas.model.Actor;
import com.teo.crud_api_peliculas.model.Movie;
import com.teo.crud_api_peliculas.network.ApiService;
import com.teo.crud_api_peliculas.network.RetrofitClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private final ApiService apiService;

    public MovieRepository() {
        this.apiService = RetrofitClient.getApiService();
    }

    public LiveData<Resource<List<Movie>>> getMovies() {
        MutableLiveData<Resource<List<Movie>>> data = new MutableLiveData<>();
        data.setValue(Resource.loading());
        apiService.getMovies().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(@NonNull Call<List<Movie>> call, @NonNull Response<List<Movie>> response) {
                if (response.isSuccessful()) {
                    data.setValue(Resource.success(response.body()));
                } else {
                    data.setValue(Resource.error("Error: " + response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Movie>> call, @NonNull Throwable t) {
                data.setValue(Resource.error(t.getMessage()));
            }
        });
        return data;
    }

    public LiveData<Resource<Movie>> getMovieWithActors(int id) {
        MutableLiveData<Resource<Movie>> data = new MutableLiveData<>();
        data.setValue(Resource.loading());
        apiService.getMovieWithActors(id).enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(@NonNull Call<Movie> call, @NonNull Response<Movie> response) {
                if (response.isSuccessful()) {
                    data.setValue(Resource.success(response.body()));
                } else {
                    data.setValue(Resource.error("Error: " + response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Movie> call, @NonNull Throwable t) {
                data.setValue(Resource.error(t.getMessage()));
            }
        });
        return data;
    }

    public LiveData<Resource<Movie>> createMovie(Movie movie) {
        MutableLiveData<Resource<Movie>> data = new MutableLiveData<>();
        data.setValue(Resource.loading());
        apiService.createMovie(movie).enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(@NonNull Call<Movie> call, @NonNull Response<Movie> response) {
                if (response.isSuccessful()) {
                    data.setValue(Resource.success(response.body()));
                } else {
                    data.setValue(Resource.error("Error: " + response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Movie> call, @NonNull Throwable t) {
                data.setValue(Resource.error(t.getMessage()));
            }
        });
        return data;
    }

    public LiveData<Resource<Movie>> updateMovie(int id, Movie movie) {
        MutableLiveData<Resource<Movie>> data = new MutableLiveData<>();
        data.setValue(Resource.loading());
        apiService.updateMovie(id, movie).enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(@NonNull Call<Movie> call, @NonNull Response<Movie> response) {
                if (response.isSuccessful()) {
                    data.setValue(Resource.success(response.body()));
                } else {
                    data.setValue(Resource.error("Error: " + response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Movie> call, @NonNull Throwable t) {
                data.setValue(Resource.error(t.getMessage()));
            }
        });
        return data;
    }

    public LiveData<Resource<Void>> deleteMovie(int id) {
        MutableLiveData<Resource<Void>> data = new MutableLiveData<>();
        data.setValue(Resource.loading());
        apiService.deleteMovie(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                if (response.isSuccessful()) {
                    data.setValue(Resource.success(null));
                } else {
                    data.setValue(Resource.error("Error: " + response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                data.setValue(Resource.error(t.getMessage()));
            }
        });
        return data;
    }

    // --- Actor methods ---

    public LiveData<Resource<Actor>> addActor(int movieId, Actor actor) {
        MutableLiveData<Resource<Actor>> data = new MutableLiveData<>();
        data.setValue(Resource.loading());
        apiService.addActorToMovie(movieId, actor).enqueue(new Callback<Actor>() {
            @Override
            public void onResponse(@NonNull Call<Actor> call, @NonNull Response<Actor> response) {
                if (response.isSuccessful()) {
                    data.setValue(Resource.success(response.body()));
                } else {
                    data.setValue(Resource.error("Error: " + response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Actor> call, @NonNull Throwable t) {
                data.setValue(Resource.error(t.getMessage()));
            }
        });
        return data;
    }

    public LiveData<Resource<Actor>> updateActor(int movieId, int actorId, Actor actor) {
        MutableLiveData<Resource<Actor>> data = new MutableLiveData<>();
        data.setValue(Resource.loading());
        apiService.updateMovieActor(movieId, actorId, actor).enqueue(new Callback<Actor>() {
            @Override
            public void onResponse(@NonNull Call<Actor> call, @NonNull Response<Actor> response) {
                if (response.isSuccessful()) {
                    data.setValue(Resource.success(response.body()));
                } else {
                    data.setValue(Resource.error("Error: " + response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Actor> call, @NonNull Throwable t) {
                data.setValue(Resource.error(t.getMessage()));
            }
        });
        return data;
    }

    public LiveData<Resource<Void>> deleteActor(int movieId, int actorId) {
        MutableLiveData<Resource<Void>> data = new MutableLiveData<>();
        data.setValue(Resource.loading());
        apiService.deleteMovieActor(movieId, actorId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                if (response.isSuccessful()) {
                    data.setValue(Resource.success(null));
                } else {
                    data.setValue(Resource.error("Error: " + response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                data.setValue(Resource.error(t.getMessage()));
            }
        });
        return data;
    }
}
