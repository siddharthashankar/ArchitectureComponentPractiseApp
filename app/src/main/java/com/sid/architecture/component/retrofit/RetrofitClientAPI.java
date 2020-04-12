package com.sid.architecture.component.retrofit;

import com.sid.architecture.component.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientAPI {
    private static Retrofit retrofit = null;

    static Retrofit getRetrofitInstance(String url){
        if(retrofit == null){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }
        return retrofit;
    }

    static Retrofit getMovieDetails(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://simplifiedcoding.net/demos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
