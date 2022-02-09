package com.DhrumilRana1998.flixster.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;

import com.DhrumilRana1998.flixster.DetailActivity;
import com.DhrumilRana1998.flixster.R;
import com.DhrumilRana1998.flixster.models.Movie;
import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

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
        View movieView = LayoutInflater.from(context).inflate( R.layout.item_movie, parent, false);
        return new ViewHolder(movieView);
    }

    // Populate data into the item through holder
    @RequiresApi(api = Build.VERSION_CODES.M)
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
        RelativeLayout container;
        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            container = itemView.findViewById(R.id.container);
        }

        @RequiresApi(api = Build.VERSION_CODES.M)
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
            Glide.with(context).load(imageUrl).placeholder(placeholderImg).transform(new RoundedCornersTransformation(100, 0)).into(ivPoster);
            // Remove the play button from the foreground if the movie is popular
            if(movie.getRating() < 8.0){
                ivPoster.setForeground(null);
            }
            else{
                ivPoster.setForeground(ContextCompat.getDrawable(context, R.drawable.ic_play_tall));
            }

            // Register click listener on whole row
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Navigate to detailed activity, sending the movie object
                    Intent i = new Intent(context, DetailActivity.class);
                    i.putExtra("movie", Parcels.wrap(movie));
                    // Shared element transition
                    Pair<View, String> pTitle = Pair.create((View) tvTitle, "tTitle");
                    Pair<View, String> pOverview = Pair.create((View) tvOverview, "tOverview");
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, pTitle, pOverview);
                    context.startActivity(i, options.toBundle());
                }
            });
        }
    }
}
