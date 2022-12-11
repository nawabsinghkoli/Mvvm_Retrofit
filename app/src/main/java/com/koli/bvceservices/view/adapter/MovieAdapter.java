package com.koli.bvceservices.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.koli.bvceservices.R;
import com.koli.bvceservices.databinding.MovieItemBinding;
import com.koli.bvceservices.service.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends ArrayAdapter<MovieModel.Search> {

    public MovieAdapter(@NonNull Context context, List<MovieModel.Search> searchList) {
        super(context, 0, searchList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        if (view == null){
            // Layout Inflater inflates each item to be displayed in GridView.
            view = LayoutInflater.from(getContext()).inflate(R.layout.movie_item, parent, false);
        }

        MovieModel.Search search = getItem(position);
        ImageView image_view = view.findViewById(R.id.image_view);
        TextView title_tv = view.findViewById(R.id.title_tv);
        TextView year_tv = view.findViewById(R.id.year_tv);

        title_tv.setText(search.getTitle());
        year_tv.setText(search.getYear());

        String poster = search.getPoster();
        Glide.with(getContext())
                .load(poster)
                .placeholder(R.drawable.image_placeholder)
                .error(R.drawable.image_not_found)
                .into(image_view);

        return view;
    }
}
