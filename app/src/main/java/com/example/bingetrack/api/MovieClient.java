package com.example.bingetrack.api;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieClient {

    private static final String BASE_URL = "https://api.themoviedb.org/";
    private static final String API_KEY= "f588cc300173db43ba966002ee96f41d";
    private static final String IMAGE_BASE_URL= "https://image.tmdb.org/t/p/w500/";


    public static Retrofit retrofit = null;

    public static Retrofit getMovieClient() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static String getApiKey() {
        return API_KEY;
    }

}
