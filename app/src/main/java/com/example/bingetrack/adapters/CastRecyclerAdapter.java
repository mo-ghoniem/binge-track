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
import com.example.bingetrack.model.Cast;

import java.util.ArrayList;
import java.util.List;

public class CastRecyclerAdapter extends RecyclerView.Adapter<CastRecyclerAdapter.CastAdapterViewHolder> {
    private Context mContext;
    private List<Cast.CastBean> castList = new ArrayList<>();

    public CastRecyclerAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public CastAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CastAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cast_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CastRecyclerAdapter.CastAdapterViewHolder holder, int position) {
        String imageUrl = "https://image.tmdb.org/t/p/w500/" + castList.get(position).getProfilePath();
        Glide
                .with(mContext)
                .load(imageUrl)
                .into(holder.castImage);

        holder.castName.setText(castList.get(position).getName());
    }

    public void setCastList(List<Cast.CastBean> castList) {
        this.castList = castList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return castList.size();
    }

    public class CastAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView castImage;
        TextView castName;
        public CastAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            castImage = itemView.findViewById(R.id.castImage);
            castName = itemView.findViewById(R.id.castNameTv);
        }
    }
}
