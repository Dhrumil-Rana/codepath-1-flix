package com.gco129.flixster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gco129.flixster.R;
import com.gco129.flixster.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    public static final String TAG = "MovieAdapter";
    Context context;
    List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    // Inflate a layout from XML, return the holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(movieView);
    }

    // Populate data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder " + position);
        // Get the movie at position
        Movie movie = movies.get(position);
        // Bind movie data into the ViewHolder
        holder.bind(movie);
    }

    // Return total count of items in the list
    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);
        }

        public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());
            String imageUrl;
            int placeholderImg;

            // If phone in landscape, set imageUrl to backdrop image
            if(context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                imageUrl = movie.getBackdropPath();
                // Use landscape placeholder image
                placeholderImg = R.drawable.placeholer_land;
            }
            else{
                // Otherwise, set imageUrl to poster image
                imageUrl = movie.getPosterPath();
                // Use portrait placeholder image
                placeholderImg = R.drawable.placeholder;
            }
            // Load image, using a placeholder while it is loading
            Glide.with(context).load(imageUrl).placeholder(placeholderImg).into(ivPoster);
        }
    }
}
