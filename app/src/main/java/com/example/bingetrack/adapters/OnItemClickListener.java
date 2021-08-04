package com.example.bingetrack.adapters;

import android.view.View;
import android.widget.ImageView;

import com.example.bingetrack.model.Movies;

import java.util.List;

public interface OnItemClickListener {
    void onItemClick(int position, List<Movies.Result> movie, String name);
    void onGenreClick(View view, int position);
}
