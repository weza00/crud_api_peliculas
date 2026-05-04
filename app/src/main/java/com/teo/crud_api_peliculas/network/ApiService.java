package com.teo.crud_api_peliculas.network;

import com.teo.crud_api_peliculas.model.Actor;
import com.teo.crud_api_peliculas.model.Movie;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {

    // --- Peliculas ---

    @GET("api/peliculas")
    Call<List<Movie>> getMovies();

    @GET("api/peliculas/con-actores/listado")
    Call<List<Movie>> getMoviesWithActorsList();

    @GET("api/peliculas/{id}")
    Call<Movie> getMovie(@Path("id") int id);

    @GET("api/peliculas/{id}/con-actores")
    Call<Movie> getMovieWithActors(@Path("id") int id);

    @POST("api/peliculas")
    Call<Movie> createMovie(@Body Movie movie);

    @PUT("api/peliculas/{id}")
    Call<Movie> updateMovie(@Path("id") int id, @Body Movie movie);

    @PATCH("api/peliculas/{id}")
    Call<Movie> patchMovie(@Path("id") int id, @Body Movie movie);

    @DELETE("api/peliculas/{id}")
    Call<Void> deleteMovie(@Path("id") int id);

    // --- Actores ---

    @GET("api/peliculas/{id}/actores")
    Call<List<Actor>> getMovieActors(@Path("id") int id);

    @POST("api/peliculas/{id}/actores")
    Call<Actor> addActorToMovie(@Path("id") int id, @Body Actor actor);

    @PUT("api/peliculas/{id}/actores/{actor_id}")
    Call<Actor> updateMovieActor(@Path("id") int id, @Path("actor_id") int actorId, @Body Actor actor);

    @DELETE("api/peliculas/{id}/actores/{actor_id}")
    Call<Void> deleteMovieActor(@Path("id") int id, @Path("actor_id") int actorId);
}
