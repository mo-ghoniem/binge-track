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

public class UpcomingRecyclerAdapter extends RecyclerView.Adapter<UpcomingRecyclerAdapter.LatestAdapterViewHolder> {
    private Context mContext;
    private List<Movies.Result> moviesList = new ArrayList<>();
    private OnItemClickListener mOnItemClickListener;

    public UpcomingRecyclerAdapter(Context mContext, OnItemClickListener onItemClickListener) {
        this.mContext = mContext;
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @NonNull
    @Override
    public LatestAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LatestAdapterViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false), mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingRecyclerAdapter.LatestAdapterViewHolder holder, int position) {

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

    public void setMoviesList(List<Movies.Result> moviesList) {
        this.moviesList = moviesList;
        notifyDataSetChanged();
    }

    public class LatestAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView moviePoster;
        TextView movieName;
        OnItemClickListener onItemClickListener;

        public LatestAdapterViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);

            moviePoster = itemView.findViewById(R.id.moviePoster);
            movieName = itemView.findViewById(R.id.movieName);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getAdapterPosition(), moviesList, moviesList.get(getAdapterPosition()).getTitle());
        }
    }

}
