package com.example.bingetrack;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bingetrack.model.Movies;

public class SearchViewModel extends ViewModel {

    MutableLiveData<Movies> moviesMutableLiveData = new MutableLiveData<>();

    public void searchMovies(String query) {

    }
}
