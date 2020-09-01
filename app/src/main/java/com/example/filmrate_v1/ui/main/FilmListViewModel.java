package com.example.filmrate_v1.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.filmrate_v1.data.Clint;
import com.example.filmrate_v1.pojo.Film;
import com.example.filmrate_v1.pojo.YTSModel;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmListViewModel extends ViewModel {
    private MutableLiveData<YTSModel> YTSMutableLiveData = null;

    private MutableLiveData<List<Film>> MoviesMutableLiveData = null;


    private static final String TAG = "FilmListViewModel";

    public FilmListViewModel() {
        if( YTSMutableLiveData == null ){
            YTSMutableLiveData = new MutableLiveData<>();
            MoviesMutableLiveData  = new MutableLiveData<>();
        }
    }

    public void lood()
    {
        getMovies();
    }

    private void getMovies(){
        Clint.getINSTANCE().getMovies().enqueue(new Callback<YTSModel>() {
            @Override
            public void onResponse(Call<YTSModel> call, Response<YTSModel> response) {
                if(response.body() != null) {
                    Log.d(TAG, "onResponse: " + response.body().getData().getMovies().get(3).getTitle());
                    YTSMutableLiveData.setValue(response.body());
                    MoviesMutableLiveData.setValue(response.body().getData().getMovies());
                }
            }

            @Override
            public void onFailure(Call<YTSModel> call, Throwable t) {
                Log.d(TAG, "onResponse: "+t.getMessage());

            }
        });
    }

    public void refresh(){
        getMovies();
    }

    public MutableLiveData<List<Film>> getFilms(){
        return MoviesMutableLiveData;
    }

    public MutableLiveData<YTSModel> getYTS(){
        return YTSMutableLiveData;
    }
}
