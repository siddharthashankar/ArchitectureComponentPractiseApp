package com.sid.architecture.component.retrofit;

import com.sid.architecture.component.retrofit.model.MovieDetails;
import com.sid.architecture.component.retrofit.model.MultipleResource;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("/api/unknown")
    Call<MultipleResource> getMultipleResourse();

    @GET("marvel")
    Call<List<MovieDetails>> getMovieDetails();
}

