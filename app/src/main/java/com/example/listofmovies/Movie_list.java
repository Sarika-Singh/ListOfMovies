package com.example.listofmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Movie_list extends AppCompatActivity {
/*ImageView poster;
TextView movie_title;
    String BASE_url="https://image.tmdb.org/t/p/w500/";*/
    TextView movie_name;
    TextView date;
    TextView lang;
    TextView vote;
    TextView overView;
    ImageView poster;
    ImageView backdrop;
    String image_base="https://image.tmdb.org/t/p/w500/";
    String name;
    String dt;
    String img_path;
    String bd_path;
    String lg;
    int vt;
    String ovr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
       /* getIntent().getIntExtra()*/
        Intent intent=getIntent();
        String Vote_count=intent.getStringExtra("vote_count");
        int Vote_average=intent.getIntExtra("vote_avg",0);
        String title=intent.getStringExtra("title");
        String release_date=intent.getStringExtra("release_date");
        String backdrop_path=intent.getStringExtra("backdrop_path");
        String overview=intent.getStringExtra("overview");
        String poster_path=intent.getStringExtra("poster_path");
        String popularity=intent.getStringExtra("popularity");
        String original_language=intent.getStringExtra("original_language");
        Log.d("list","list"+intent);

        movie_name=findViewById(R.id.name);
        date=findViewById(R.id.date);
        lang=findViewById(R.id.lang);
        vote=findViewById(R.id.vote_count);
        overView=findViewById(R.id.overview);
        poster=findViewById(R.id.poster);
        backdrop=findViewById(R.id.backdrop);


        movie_name.setText(title);
        date.setText(release_date);
        lang.setText(original_language);
        vote.setText(""+Vote_count);

        overView.setText(overview);

        Picasso.with(getApplicationContext()).load(image_base+poster_path).into(poster);
        Picasso.with(getApplicationContext()).load(image_base+backdrop_path).into(backdrop);
       /* Glide.with(getApplicationContext()).load(image_base+img_path).into(poster);
        Glide.with(getApplicationContext()).load(image_base+bd_path).into(backdrop);*/
/*
        poster=findViewById(R.id.poster);
        movie_title=findViewById(R.id.title);

        Picasso.with(Movie_list.this).load(BASE_url+backdrop_path).into(poster);
        movie_title.setText(title);*/



        /*TextView movie_name;
    TextView date;
    TextView lang;
    TextView vote;
    TextView overview;
    ImageView poster;
    ImageView backdrop;
    String image_base="https://image.tmdb.org/t/p/w500/";
    String name;
    String dt;
    String img_path;
    String bd_path;
    String lg;
    int vt;
    String ovr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Intent i =getIntent();
        name= i.getStringExtra("movie_name");
        img_path=    i.getStringExtra("poster");
        bd_path=  i.getStringExtra("backdrop");
        dt= i.getStringExtra("date");
        lg= i.getStringExtra("lang");
        vt= i.getIntExtra("vote",0);
        ovr= i.getStringExtra("overview");

        movie_name=findViewById(R.id.name);
        date=findViewById(R.id.date);
        lang=findViewById(R.id.lang);
        vote=findViewById(R.id.vote);
        overview=findViewById(R.id.overview);
        poster=findViewById(R.id.poster);
        backdrop=findViewById(R.id.backdrop);


        movie_name.setText(name);
        date.setText(dt);
        lang.setText(lg);
        vote.setText(""+vt);
        overview.setText(ovr);
        Glide.with(getApplicationContext()).load(image_base+img_path).into(poster);
        Glide.with(getApplicationContext()).load(image_base+bd_path).into(backdrop);*/

    }
}
