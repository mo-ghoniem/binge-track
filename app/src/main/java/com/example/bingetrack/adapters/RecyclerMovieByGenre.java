package com.example.bingetrack.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bingetrack.R;
import com.example.bingetrack.model.Movies;

import java.util.List;

public class RecyclerMovieByGenre extends RecyclerView.Adapter<RecyclerMovieByGenre.RecyclerMovieByGenreViewHolder> {

    private Context mContext;
    private List<Movies.Result> moviesList;

    public RecyclerMovieByGenre(Context context, List<Movies.Result> moviesList) {
        this.mContext = context;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public RecyclerMovieByGenreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerMovieByGenreViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerMovieByGenre.RecyclerMovieByGenreViewHolder holder, int position) {
        String imageUrl = "https://image.tmdb.org/t/p/w500/" + moviesList.get(position).getPosterPath();
        Glide
                .with(mContext)
                .load(imageUrl)
                .into(holder.moviePoster);

        holder.movieName.setText(moviesList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class RecyclerMovieByGenreViewHolder extends RecyclerView.ViewHolder {

        ImageView moviePoster;
        TextView movieName;
        public RecyclerMovieByGenreViewHolder(@NonNull View itemView) {
            super(itemView);

            moviePoster = itemView.findViewById(R.id.moviePoster);
            movieName = itemView.findViewById(R.id.movieName);
        }
    }
}
