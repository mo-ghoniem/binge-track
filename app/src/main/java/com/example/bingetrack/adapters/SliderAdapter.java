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

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderAdapterViewHolder> {
    private Context mContext;
    private List<Movies.Result> moviesList;

    public SliderAdapter(Context mContext, List<Movies.Result> moviesList) {
        this.mContext = mContext;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public SliderAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderAdapterViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.slider_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderAdapter.SliderAdapterViewHolder holder, int position) {
        String imageUrl = "https://image.tmdb.org/t/p/w500/" + moviesList.get(position).getPosterPath();
        Glide
                .with(mContext)
                .load(imageUrl)
                .into(holder.sliderImage);

        holder.sliderTitle.setText(moviesList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class SliderAdapterViewHolder extends RecyclerView.ViewHolder {

        ImageView sliderImage;
        TextView sliderTitle;

        public SliderAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            sliderImage = itemView.findViewById(R.id.slide_img);
            sliderTitle = itemView.findViewById(R.id.sliderTitleTv);
        }
    }
}
