package com.sid.architecture.component.livedata;

import com.sid.architecture.component.livedata.model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://simplifiedcoding.net/demos/";
    String BASE_URL2 = "https://task.free.beeceptor.com/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();

}
