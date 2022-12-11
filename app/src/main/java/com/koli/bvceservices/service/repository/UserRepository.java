package com.koli.bvceservices.service.repository;

import android.app.Application;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.MutableLiveData;

import com.koli.bvceservices.R;
import com.koli.bvceservices.service.model.MovieModel;
import com.koli.bvceservices.service.network.MovieApiService;
import com.koli.bvceservices.service.network.RetrofitInstance;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private ArrayList<MovieModel.Search> searchList = new ArrayList<>();
    private MutableLiveData<List<MovieModel.Search>> mutableLiveDataSearch = new MutableLiveData<>();
    private Application application;

    public UserRepository(Application application){
        this.application = application;
    }

    public MutableLiveData<List<MovieModel.Search>> getMutableLiveData(String apikey, String title, String type){

        MovieApiService movieApiService = RetrofitInstance.getApiService();
        Call<MovieModel> call = movieApiService.getMoviesByTitle(apikey, title, type);
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {

                String url = call.request().url().toString();
                Request request = call.request();
                System.out.println("url: " + url);
                System.out.println("request.toString(): " + request.toString());

                MovieModel movieModel = response.body();
                if (movieModel != null && movieModel.getSearch() != null) {
                    searchList = movieModel.getSearch();
                    mutableLiveDataSearch.setValue(searchList);
                }
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

                Log.d("ListSize"," - > Error    "+ t.getMessage());
            }
        });

        return mutableLiveDataSearch;
    }
}
