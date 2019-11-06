package com.example.listofmovies;

import com.example.listofmovies.Model.MovieResponse;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {



    @GET("day")
    Call<MovieResponse> getlist(@Query("api_key") String Api_key);
}
