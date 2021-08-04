package com.example.bingetrack.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bingetrack.R;
import com.example.bingetrack.model.Genres;
import com.google.gson.internal.$Gson$Preconditions;

import java.util.ArrayList;
import java.util.List;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryAdapterViewHolder> {
    private Context mContext;
    private List<Genres.Genre> genreList = new ArrayList<>();
    private OnItemClickListener mOnItemClickListener;


    public CategoryRecyclerAdapter(Context mContext, OnItemClickListener onItemClickListener) {
        this.mContext = mContext;
        this.mOnItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public CategoryAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryAdapterViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.genre_item, parent, false), mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRecyclerAdapter.CategoryAdapterViewHolder holder, int position) {
        holder.genreTitle.setText(genreList.get(position).getName());
    }



    @Override
    public int getItemCount() {
        return genreList.size();
    }

    public void setGenreList(List<Genres.Genre> genreList) {
        this.genreList = genreList;
        notifyDataSetChanged();
    }

    public class CategoryAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView genreTitle;
        OnItemClickListener onItemClickListener;
        public CategoryAdapterViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            genreTitle = itemView.findViewById(R.id.genreTitle);

            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onGenreClick(v, getAdapterPosition());
        }
    }

}
