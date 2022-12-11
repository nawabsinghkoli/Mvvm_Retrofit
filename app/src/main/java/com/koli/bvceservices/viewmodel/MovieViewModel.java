package com.koli.bvceservices.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.koli.bvceservices.service.model.MovieModel;
import com.koli.bvceservices.service.repository.UserRepository;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {

    private UserRepository userRepository;

    public MovieViewModel(@NonNull Application application) {
        super(application);

        userRepository = new UserRepository(application);
    }

    public LiveData<List<MovieModel.Search>> getMovies(String apikey, String title, String type){

        return userRepository.getMutableLiveData(apikey, title, type);
    }
}
