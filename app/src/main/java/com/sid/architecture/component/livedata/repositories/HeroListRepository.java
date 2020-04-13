package com.sid.architecture.component.livedata.repositories;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.sid.architecture.component.livedata.model.Hero;
import com.sid.architecture.component.livedata.request.RestApiService;
import com.sid.architecture.component.livedata.request.RetrofitInstance;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroListRepository {
    private MutableLiveData<List<Hero>> mutableLiveData = new MutableLiveData<>();

    private Context mContext;

    public HeroListRepository(Context context) {
        mContext = context;

    }
    public MutableLiveData<List<Hero>> getMutableLiveData() {
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<List<Hero>> call = apiService.getHeroes();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                if(response.isSuccessful()){
                    mutableLiveData.setValue(response.body());
                }else{
                    if(response.code() != 200){
                        Toast.makeText(mContext,"Server Error...",Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
            }
        });
        return mutableLiveData;
    }
}
