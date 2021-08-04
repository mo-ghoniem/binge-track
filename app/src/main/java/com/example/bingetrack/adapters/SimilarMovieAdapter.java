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

import java.util.ArrayList;
import java.util.List;

public class SimilarMovieAdapter extends RecyclerView.Adapter<SimilarMovieAdapter.SimilarMoviesViewHolder> {

    private Context mContext;
    private List<Movies.Result> moviesList = new ArrayList<>();

    public SimilarMovieAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SimilarMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SimilarMoviesViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SimilarMovieAdapter.SimilarMoviesViewHolder holder, int position) {

        String imageUrl = "https://image.tmdb.org/t/p/w500/" + moviesList.get(position).getPosterPath();
        Glide
                .with(mContext)
                .load(imageUrl)
                .into(holder.moviePoster);

        holder.movieName.setText(moviesList.get(position).getTitle());
    }

    public void setMoviesList(List<Movies.Result> moviesList) {
        this.moviesList = moviesList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class SimilarMoviesViewHolder extends RecyclerView.ViewHolder {

        ImageView moviePoster;
        TextView movieName;
        public SimilarMoviesViewHolder(@NonNull View itemView) {
            super(itemView);

            moviePoster = itemView.findViewById(R.id.moviePoster);
            movieName = itemView.findViewById(R.id.movieName);
        }
    }
}
