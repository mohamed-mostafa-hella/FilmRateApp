package com.example.filmrate_v1.data;

import com.example.filmrate_v1.pojo.YTSModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("list_movies.json")
    public Call<YTSModel> getmovies();

}
