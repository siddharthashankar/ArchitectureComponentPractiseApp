package com.sid.architecture.component.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

import com.sid.architecture.component.R;
import com.sid.architecture.component.retrofit.model.MovieDetails;
import com.sid.architecture.component.retrofit.model.MultipleResource;
import com.sid.architecture.component.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitActivityDemo extends AppCompatActivity {

    private APIInterface apiInterface,heroInterface = null;
    private TextView tvResult;
    RecyclerView recyclerView,rvMovie;
    private MultipleResourceAdapter mAdapter;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_retrofit_demo);
        tvResult = (TextView)findViewById(R.id.tvResult);
        recyclerView = (RecyclerView)findViewById(R.id.rv1);
        rvMovie = (RecyclerView)findViewById(R.id.rvMovie);
        //call retrofit and webservice
        apiInterface = RetrofitClientAPI.getRetrofitInstance(Constants.url).create(APIInterface.class);
        heroInterface = RetrofitClientAPI.getMovieDetails().create(APIInterface.class);

        firstRetrofitWebserviceCall();
        getMovieDetails();
    }
    void firstRetrofitWebserviceCall(){
        Call<MultipleResource> apiCall = apiInterface.getMultipleResourse();
        apiCall.enqueue(new Callback<MultipleResource>() {
            @Override
            public void onResponse(Call<MultipleResource> call, Response<MultipleResource> response) {
                Log.i("Response---",response.code()+"");
                Log.i("Response body---",response.body()+"");
                MultipleResource result = response.body();
                Integer page = result.page;
                Integer perPage = result.per_page;
                Integer total = result.total;
                Integer total_pages = result.total_pages;
                tvResult.setText("Page:"+page+","
                +" Per Page:"+perPage+"\n"
                +"Total:"+total+","
                +" Total Pages:"+total_pages);

                List<MultipleResource.DataRecords> dataList = result.data;
                mAdapter = new MultipleResourceAdapter(dataList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.addItemDecoration(new DividerItemDecoration(RetrofitActivityDemo.this, LinearLayoutManager.VERTICAL));
                recyclerView.setAdapter(mAdapter);
            }
            @Override
            public void onFailure(Call<MultipleResource> call, Throwable t) {

            }
        });
    }

    void getMovieDetails(){
        Call<List<MovieDetails>> movieApiCall = heroInterface.getMovieDetails();
        movieApiCall.enqueue(new Callback<List<MovieDetails>>() {
            @Override
            public void onResponse(Call<List<MovieDetails>> call, Response<List<MovieDetails>> response) {
                Log.i("Response Hero---",response.code()+"");
                List<MovieDetails> movieData = response.body();
                movieAdapter = new MovieAdapter(movieData);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                rvMovie.setLayoutManager(mLayoutManager);
                rvMovie.setItemAnimator(new DefaultItemAnimator());
                rvMovie.addItemDecoration(new DividerItemDecoration(RetrofitActivityDemo.this, LinearLayoutManager.VERTICAL));
                rvMovie.setAdapter(movieAdapter);
            }

            @Override
            public void onFailure(Call<List<MovieDetails>> call, Throwable t) {

            }
        });


    }
}
