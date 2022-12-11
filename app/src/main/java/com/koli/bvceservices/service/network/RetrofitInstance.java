package com.koli.bvceservices.service.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit = null;
    //private static final String BASE_URL = "https://www.omdbapi.com/?apikey=b9bd48a6&s=Marvel&type=movie";
    private static final String BASE_URL = "https://www.omdbapi.com/";

    public static MovieApiService getApiService(){
        if (retrofit == null){

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit.create(MovieApiService.class);
    }
}
