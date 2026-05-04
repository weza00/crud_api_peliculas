package com.teo.crud_api_peliculas.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.teo.crud_api_peliculas.model.Actor;
import com.teo.crud_api_peliculas.repository.MovieRepository;
import com.teo.crud_api_peliculas.repository.Resource;

public class ActorViewModel extends ViewModel {
    private final MovieRepository repository;

    public ActorViewModel() {
        this.repository = new MovieRepository();
    }

    public LiveData<Resource<Actor>> addActor(int movieId, Actor actor) {
        return repository.addActor(movieId, actor);
    }

    public LiveData<Resource<Actor>> updateActor(int movieId, int actorId, Actor actor) {
        return repository.updateActor(movieId, actorId, actor);
    }

    public LiveData<Resource<Void>> deleteActor(int movieId, int actorId) {
        return repository.deleteActor(movieId, actorId);
    }
}
