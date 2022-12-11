package com.koli.bvceservices.view.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.koli.bvceservices.R;
import com.koli.bvceservices.databinding.ActivityMainBinding;
import com.koli.bvceservices.service.model.MovieModel;
import com.koli.bvceservices.view.adapter.MovieAdapter;
import com.koli.bvceservices.viewmodel.MovieViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    ActivityMainBinding mBinding;
    private MovieViewModel movieViewModel;
    ArrayList<MovieModel> movieModelList;
    MovieAdapter movieAdapter;
    String apikey = "b9bd48a6";
    String title = "";
    String type = "movie";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mContext = this;

        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        mBinding.searchIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = mBinding.titleEt.getText().toString().trim();
                if (TextUtils.isEmpty(title)){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle(R.string.app_name)
                            .setMessage(R.string.enter_title)
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else {
                    mBinding.gridView.setAdapter(null);
                    getMovies(apikey, title, type);
                }
            }
        });
    }

    private void getMovies(String apikey, String title, String type) {
        movieViewModel.getMovies(apikey, title, type).observe(this, new Observer<List<MovieModel.Search>>() {
            @Override
            public void onChanged(List<MovieModel.Search> searches) {

                movieAdapter = new MovieAdapter(mContext, searches);
                mBinding.gridView.setAdapter(movieAdapter);
            }
        });
    }
}