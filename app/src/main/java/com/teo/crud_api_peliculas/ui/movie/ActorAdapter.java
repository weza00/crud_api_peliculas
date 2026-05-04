package com.teo.crud_api_peliculas.ui.movie;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.teo.crud_api_peliculas.databinding.ItemActorBinding;
import com.teo.crud_api_peliculas.model.Actor;
import java.util.ArrayList;
import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {

    private List<Actor> actors = new ArrayList<>();
    private final OnActorActionListener listener;

    public interface OnActorActionListener {
        void onEditActor(Actor actor);
        void onDeleteActor(Actor actor);
    }

    public ActorAdapter(OnActorActionListener listener) {
        this.listener = listener;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors != null ? actors : new ArrayList<>();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemActorBinding binding = ItemActorBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ActorViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorViewHolder holder, int position) {
        holder.bind(actors.get(position));
    }

    @Override
    public int getItemCount() {
        return actors.size();
    }

    class ActorViewHolder extends RecyclerView.ViewHolder {
        private final ItemActorBinding binding;

        public ActorViewHolder(ItemActorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Actor actor) {
            binding.tvActorName.setText(actor.getNombreActor());
            binding.tvActorRole.setText(actor.getRol());
            binding.btnEditActor.setOnClickListener(v -> listener.onEditActor(actor));
            binding.btnDeleteActor.setOnClickListener(v -> listener.onDeleteActor(actor));
        }
    }
}
