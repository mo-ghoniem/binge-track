package com.example.bingetrack.ui.detail;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bingetrack.Utils;
import com.example.bingetrack.api.MovieClient;
import com.example.bingetrack.model.Cast;
import com.example.bingetrack.model.Movies;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MovieDetailViewModel extends ViewModel {

    private static final String TAG = "MovieDetailViewModel";

    MutableLiveData<Movies> similarMutableLiveData = new MutableLiveData<Movies>();
    MutableLiveData<Cast> movieCastMutableLiveData = new MutableLiveData<>();

    public void getSimilarMovies(int movieID){
        Observable observable = Utils.getApi().getSimilarMovies(movieID, MovieClient.getApiKey())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<Movies> observer = new Observer<Movies>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Movies movies) {
                similarMutableLiveData.setValue(movies);
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

    public void getMovieCast(int movieID) {
        Observable observable = Utils.getApi().getMovieCast(movieID, MovieClient.getApiKey())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<Cast> observer = new Observer<Cast>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Cast cast) {
                movieCastMutableLiveData.setValue(cast);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onCastError: " + e);
            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);

    }

}
