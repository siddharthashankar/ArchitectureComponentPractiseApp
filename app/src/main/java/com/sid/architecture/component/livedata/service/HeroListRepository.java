package com.sid.architecture.component.livedata.service;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.sid.architecture.component.livedata.model.Hero;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroListRepository {
    private ArrayList<Hero> movies = new ArrayList<>();
    private MutableLiveData<List<Hero>> mutableLiveData = new MutableLiveData<>();
    private Application application;
    public HeroListRepository(Application application) {
        this.application = application;
    }
    public MutableLiveData<List<Hero>> getMutableLiveData() {
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<List<Hero>> call = apiService.getHeroes();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
