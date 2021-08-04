package com.example.bingetrack.ui.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bingetrack.R;
import com.example.bingetrack.adapters.CastRecyclerAdapter;
import com.example.bingetrack.adapters.SimilarMovieAdapter;
import com.example.bingetrack.model.Cast;
import com.example.bingetrack.model.Movies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MovieDetailFragment extends Fragment {

    private static final String TAG = "MovieDetailFragment";


    TextView movieTitle;
    TextView movieDesc;
    ImageView movieCover;
    ImageView movieImage;
    RecyclerView similarRv;
    RecyclerView castRv;
    MovieDetailViewModel movieDetailViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        movieTitle = getView().findViewById(R.id.detail_movie_title);
        movieCover = getView().findViewById(R.id.detail_movie_cover);
        movieImage = getView().findViewById(R.id.detail_movie_img);
        movieDesc = getView().findViewById(R.id.detail_movie_desc);
        similarRv = getView().findViewById(R.id.similarRv);
        castRv = getView().findViewById(R.id.castRv);

        movieDetailViewModel = new ViewModelProvider(this).get(MovieDetailViewModel.class);

        initFragment();



    }

    private void initSimilarMovieAdapter(int movieID) {
        SimilarMovieAdapter adapter = new SimilarMovieAdapter(getActivity());
        similarRv.setAdapter(adapter);
        similarRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        movieDetailViewModel.getSimilarMovies(movieID);
        movieDetailViewModel.similarMutableLiveData.observe(getViewLifecycleOwner(), new Observer<Movies>() {
            @Override
            public void onChanged(Movies movies) {
                adapter.setMoviesList(movies.getResults());
            }
        });
    }

    private void initCastAdapter(int movieID) {
        CastRecyclerAdapter adapter = new CastRecyclerAdapter(getActivity());
        castRv.setAdapter(adapter);
        castRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        movieDetailViewModel.getMovieCast(movieID);
        movieDetailViewModel.movieCastMutableLiveData.observe(getViewLifecycleOwner(), new Observer<Cast>() {
            @Override
            public void onChanged(Cast cast) {
                adapter.setCastList(cast.getCast());
            }
        });
    }

    private void initFragment() {
        if (getArguments() != null) {

            String name = getArguments().getString("EXTRA_NAME");
            int position = getArguments().getInt("EXTRA_POSITION");

            List<Movies.Result> movieList = (List<Movies.Result>) getArguments().getSerializable("EXTRA_MOVIE");

            String imageUrl = "https://image.tmdb.org/t/p/w500/" + movieList.get(position).getPosterPath();
            Glide
                    .with(this)
                    .load(imageUrl)
                    .into(movieImage);

            String coverImageUrl = "https://image.tmdb.org/t/p/w1280/" + movieList.get(position).getBackdropPath();
            Glide
                    .with(this)
                    .load(coverImageUrl)
                    .into(movieCover);

            movieTitle.setText(name);
            movieDesc.setText(movieList.get(position).getOverview());

            int id = movieList.get(position).getId();
            Log.d(TAG, "initFragment: id is " + id);
            initSimilarMovieAdapter(id);
            initCastAdapter(id);
        }
    }


}