package com.example.bingetrack.api;

import com.example.bingetrack.model.Cast;
import com.example.bingetrack.model.Genres;
import com.example.bingetrack.model.Movies;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {

    @GET("/3/movie/popular")
    Observable<Movies> getPopularMovies(@Query("api_key") String apiKey);

    @GET("/3/genre/movie/list")
    Observable<Genres> getPopularGenres(@Query("api_key") String apiKey);

    @GET("/3/discover/movie")
    Observable<List<Genres>> getMoviesByGenres(@Query("api_key") String apiKey, @Query("with_genres") String genreID);

    @GET("/3/movie/now_playing")
    Observable<Movies> getNowPlayingMovies(@Query("api_key") String apiKey);

    @GET("/3/movie/upcoming")
    Observable<Movies> getUpcomingMovies(@Query("api_key") String apiKey);

    @GET("/3/movie/{movie_id}/similar")
    Observable<Movies> getSimilarMovies(@Path("movie_id") int movieID, @Query("api_key") String apiKey);

    @GET("/3/movie/{movie_id}/credits")
    Observable<Cast> getMovieCast(@Path("movie_id") int movieID, @Query("api_key") String apiKey);

    @GET("/3/search/movie")
    Observable<Cast> searchMovie(@Query("api_key") String apiKey, @Query("query") String query);
}
