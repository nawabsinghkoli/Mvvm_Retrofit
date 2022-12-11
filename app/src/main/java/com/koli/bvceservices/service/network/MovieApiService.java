package com.koli.bvceservices.service.network;

import com.koli.bvceservices.service.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApiService {

    @GET("https://www.omdbapi.com/")
    public Call<MovieModel> getMoviesByTitle(@Query("apikey") String apikey, @Query("s") String title, @Query("type") String type);
}
