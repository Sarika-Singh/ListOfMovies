package com.example.listofmovies;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listofmovies.Model.MovieResponse;
import com.example.listofmovies.Model.ResultsItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    Context context;
    List<ResultsItem> list;
    String BASE_url="https://image.tmdb.org/t/p/w500/";





    public MovieAdapter(MainActivity mainActivity, List<ResultsItem> list) {

        this.context=mainActivity;
        this.list=list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_movie, parent, false);
        MyViewHolder viewHolder=new MyViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.movieTitle.setText(list.get(position).getTitle());
        /*holder.data.setText(list.get(position).getReleaseDate());*/
      /*  holder.movieDescription.setText(list.get(position).getOverview());*/
      //  holder.Votecount.setText(list.get(position).getVoteCount());

//        holder.rating.setText((int) list.get(position).getVoteAverage());
       // holder.ratingimg
        final String image=BASE_url+list.get(position).getBackdropPath();
    Picasso.with(context).load(image).into(holder.Image);
    holder.Image.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context,ScrollingActivity2.class);
            intent.putExtra("vote_count",list.get(position).getVoteCount());
            intent.putExtra("Vote_avg",list.get(position).getVoteAverage());
            intent.putExtra("title",list.get(position).getTitle());
            intent.putExtra("release_date",list.get(position).getReleaseDate());
            intent.putExtra("backdrop_path",list.get(position).getBackdropPath());
            intent.putExtra("overview",list.get(position).getOverview());
            intent.putExtra("poster_path",list.get(position).getPosterPath());
            intent.putExtra("popularity",list.get(position).getPopularity());
            intent.putExtra("original_language",list.get(position).getOriginalLanguage());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            Log.d("avg","avg"+list.get(position).getVoteAverage());
                    /*"id": 420818,

      "genre_ids": [
        12,
        16,
        18
      ],
      "backdrop_path": "/nRXO2SnOA75OsWhNhXstHB8ZmI3.jpg",
      "adult": false,
      "overview": "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
      "poster_path": "/2bXbqYdUdNVa8VIWXVfclP2ICtT.jpg",
      "popularity": 165.356,
      "media_type": "movie"*/
        }
    });


    }

    @Override
    public int getItemCount() {
        Log.d("list","list"+list.size());

        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView Votecount;
        ImageView Image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            movieTitle = (TextView) itemView.findViewById(R.id.movie_name);
           /* data = (TextView) itemView.findViewById(R.id.date);
            movieDescription = (TextView) itemView.findViewById(R.id.overview);

            Votecount = (TextView) itemView.findViewById(R.id.vote_count);*/
            Image=(ImageView)itemView.findViewById(R.id.movie_img);
        }
    }
}
