package com.example.bingetrack;

import com.example.bingetrack.api.MovieApi;
import com.example.bingetrack.api.MovieClient;

public class Utils {

    public static MovieApi getApi() {
        return  MovieClient.getMovieClient().create(MovieApi.class);
    }
}
