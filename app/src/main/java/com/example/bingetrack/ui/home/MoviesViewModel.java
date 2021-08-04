package com.example.bingetrack.ui.home;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bingetrack.Utils;
import com.example.bingetrack.api.MovieClient;
import com.example.bingetrack.model.Genres;
import com.example.bingetrack.model.Movies;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MoviesViewModel extends ViewModel {
    private static final String TAG = "MoviesViewModel";


    MutableLiveData<Movies> popularMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Genres> genresMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Movies> moviesByGenreMutable = new MutableLiveData<>();
    MutableLiveData<Movies> nowPlayingMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Movies> upcomingMutableLiveData = new MutableLiveData<>();


    public void getPopularMovies() {

        Observable observable = Utils.getApi().getPopularMovies(MovieClient.getApiKey())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<Movies> observer = new Observer<Movies>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Movies movies) {
                popularMutableLiveData.setValue(movies);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);
    }

    public void getGenres() {
        Observable observable = Utils.getApi().getPopularGenres(MovieClient.getApiKey())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<Genres> observer = new Observer<Genres>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Genres genres) {
                genresMutableLiveData.setValue(genres);
            }


            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);
    }

    public void getMovieByGenre(String genreName) {
        Observable observable = Utils.getApi().getMoviesByGenres(MovieClient.getApiKey(), genreName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observer<Movies> observer = new Observer<Movies>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Movies movies) {
                moviesByGenreMutable.setValue(movies);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);

    }

    public void getNowPlayingMovies(){
        Observable observable = Utils.getApi().getNowPlayingMovies(MovieClient.getApiKey())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observer<Movies> observer = new Observer<Movies>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Movies movies) {
                nowPlayingMutableLiveData.setValue(movies);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);
    }

    public void getUpcoming(){
        Observable observable = Utils.getApi().getUpcomingMovies(MovieClient.getApiKey())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observer<Movies> observer = new Observer<Movies>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Movies movies) {
                upcomingMutableLiveData.setValue(movies);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);
    }

}
