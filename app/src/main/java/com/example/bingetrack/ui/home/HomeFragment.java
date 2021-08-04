package com.example.bingetrack.ui.home;

import android.app.ActivityOptions;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.bingetrack.R;
import com.example.bingetrack.adapters.CategoryRecyclerAdapter;
import com.example.bingetrack.adapters.OnItemClickListener;
import com.example.bingetrack.adapters.SliderAdapter;
import com.example.bingetrack.adapters.UpcomingRecyclerAdapter;
import com.example.bingetrack.model.Genres;
import com.example.bingetrack.model.Movies;

import java.io.Serializable;
import java.util.List;


public class HomeFragment extends Fragment implements OnItemClickListener {
    private static final String TAG = "HomeFragment";

    MoviesViewModel moviesViewModel;

    ViewPager2 sliderPager;

    RecyclerView genreRv;
    RecyclerView upcomingRv;
    RecyclerView popularRv;
    Button button;


    NavController navController = new NavController(getActivity());


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)  {
        super.onViewCreated(view, savedInstanceState);

        moviesViewModel = new ViewModelProvider(this).get(MoviesViewModel.class);
        sliderPager = getView().findViewById(R.id.sliderPager);
        genreRv = getView().findViewById(R.id.categoryRv);
        upcomingRv = getView().findViewById(R.id.upcomingRv);
        popularRv = getView().findViewById(R.id.popularRv);




        navController = Navigation.findNavController(view);


        moviesViewModel.getNowPlayingMovies();
        initSliderAdapter();


        moviesViewModel.getGenres();
        initGenreRecycler();

        moviesViewModel.getUpcoming();
        initUpcomingAdapter();

        moviesViewModel.getPopularMovies();
        initPopularAdapter();

    }


    private void initGenreRecycler(){
        CategoryRecyclerAdapter adapter = new CategoryRecyclerAdapter(getActivity(), this);
        genreRv.setAdapter(adapter);
        genreRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        moviesViewModel.genresMutableLiveData.observe(getViewLifecycleOwner(), new Observer<Genres>() {
            @Override
            public void onChanged(Genres genres) {
                adapter.setGenreList(genres.getGenres());
            }
        });
    }

    private void initSliderAdapter() {
        moviesViewModel.nowPlayingMutableLiveData.observe(getViewLifecycleOwner(), movies -> {
            SliderAdapter adapter = new SliderAdapter(getActivity(), movies.getResults());
            sliderPager.setAdapter(adapter);
        });
    }

    private void initPopularAdapter() {
        UpcomingRecyclerAdapter adapter = new UpcomingRecyclerAdapter(getActivity(), this);
        popularRv.setAdapter(adapter);
        popularRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        moviesViewModel.popularMutableLiveData.observe(getViewLifecycleOwner(), new Observer<Movies>() {
            @Override
            public void onChanged(Movies movies) {
                adapter.setMoviesList(movies.getResults());

            }
        });
    }

    private void initUpcomingAdapter() {
        UpcomingRecyclerAdapter adapter = new UpcomingRecyclerAdapter(getActivity(),this );
        upcomingRv.setAdapter(adapter);
        upcomingRv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        moviesViewModel.upcomingMutableLiveData.observe(getViewLifecycleOwner(), new Observer<Movies>() {
            @Override
            public void onChanged(Movies movies) {
                adapter.setMoviesList(movies.getResults());
            }
        });
    }


    @Override
    public void onItemClick(int position, List<Movies.Result> movie, String name) {
        Bundle bundle = new Bundle();
        bundle.putInt("EXTRA_POSITION", position);
        bundle.putSerializable("EXTRA_MOVIE", (Serializable) movie);
        bundle.putString("EXTRA_NAME", name);
        navController.navigate(R.id.action_homeFragment2_to_movieDetailFragment, bundle);
    }

    @Override
    public void onGenreClick(View view, int position) {
    }
}