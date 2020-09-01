package com.example.filmrate_v1.data;

import com.example.filmrate_v1.pojo.YTSModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Clint {
    private static final String BASE_URL
            = "https://yts.mx/api/v2/";

    private RetrofitInterface Interface;
    private static Clint INSTANCE;

    private Clint() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Interface = retrofit.create(RetrofitInterface.class);
    }

    public static Clint getINSTANCE() {
        if(null == INSTANCE){
            INSTANCE = new Clint();
        }
        return INSTANCE;
    }

    public Call<YTSModel> getMovies(){
        return Interface.getmovies();
    }
}
