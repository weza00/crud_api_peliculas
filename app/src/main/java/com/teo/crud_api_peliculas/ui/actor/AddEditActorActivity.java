package com.teo.crud_api_peliculas.ui.actor;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.teo.crud_api_peliculas.databinding.ActivityAddEditActorBinding;
import com.teo.crud_api_peliculas.model.Actor;
import com.teo.crud_api_peliculas.repository.Resource;
import com.teo.crud_api_peliculas.viewmodel.ActorViewModel;

public class AddEditActorActivity extends AppCompatActivity {

    private ActivityAddEditActorBinding binding;
    private ActorViewModel viewModel;
    private Actor actorToEdit;
    private int movieId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddEditActorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(ActorViewModel.class);
        movieId = getIntent().getIntExtra("MOVIE_ID", -1);
        actorToEdit = (Actor) getIntent().getSerializableExtra("ACTOR");

        if (movieId == -1) {
            finish();
            return;
        }

        setupToolbar();
        if (actorToEdit != null) {
            fillFields();
            binding.toolbar.setTitle("Editar Actor");
        }

        binding.btnSaveActor.setOnClickListener(v -> saveActor());
    }

    private void setupToolbar() {
        setSupportActionBar(binding.toolbar);
        binding.toolbar.setNavigationOnClickListener(v -> finish());
    }

    private void fillFields() {
        binding.etActorName.setText(actorToEdit.getNombreActor());
        binding.etActorRole.setText(actorToEdit.getRol());
    }

    private void saveActor() {
        String name = binding.etActorName.getText().toString().trim();
        String role = binding.etActorRole.getText().toString().trim();

        if (name.isEmpty() || role.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Actor actor = actorToEdit != null ? actorToEdit : new Actor();
        actor.setNombreActor(name);
        actor.setRol(role);
        actor.setPeliculaId(movieId);

        if (actorToEdit == null) {
            viewModel.addActor(movieId, actor).observe(this, this::handleResponse);
        } else {
            viewModel.updateActor(movieId, actorToEdit.getId(), actor).observe(this, this::handleResponse);
        }
    }

    private void handleResponse(Resource<Actor> resource) {
        if (resource != null) {
            switch (resource.status) {
                case SUCCESS:
                    Toast.makeText(this, "Actor guardado", Toast.LENGTH_SHORT).show();
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
