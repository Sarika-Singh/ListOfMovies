package com.example.listofmovies;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ScrollingActivity2 extends AppCompatActivity {
    TextView movie_name;
    TextView date;
    TextView lang;
    TextView vote;
    TextView vote_avg;
    TextView overView;
    ImageView poster;
    ImageView backdrop;
    String image_base="https://image.tmdb.org/t/p/w500/";
    AppBarLayout app_bar;
    CollapsingToolbarLayout coll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        coll=findViewById(R.id.toolbar_layout);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                         String Vote_count=intent.getStringExtra("vote_count");
        int Vote_average=intent.getIntExtra("vote_avg",0);
            }
        });*/

        Intent intent=getIntent();
//        String Vote_count=intent.getStringExtra("vote_count");
        int Vote_count=intent.getIntExtra("vote_count",0);
        String title=intent.getStringExtra("title");
        String release_date=intent.getStringExtra("release_date");
        String backdrop_path=intent.getStringExtra("backdrop_path");
        String overview=intent.getStringExtra("overview");
        String poster_path=intent.getStringExtra("poster_path");
        String popularity=intent.getStringExtra("popularity");
        float Vote_avg=intent.getFloatExtra("vote_avg",0);
        String original_language=intent.getStringExtra("original_language");
        Log.d("list","list"+intent);

        app_bar=findViewById(R.id.app_bar);

        coll.setTitle(title);
        movie_name=findViewById(R.id.name);
        date=findViewById(R.id.date);
        lang=findViewById(R.id.lang);
        vote=findViewById(R.id.vote_count);
        overView=findViewById(R.id.overview);
        poster=findViewById(R.id.poster);
        backdrop=findViewById(R.id.Sbackdrop);
        vote_avg=findViewById(R.id.vote_avg);


        movie_name.setText(title);
        date.setText(release_date);
        lang.setText(original_language);
        vote.setText(""+Vote_count);
        vote_avg.setText(""+Vote_avg);
        Log.d("votecount","votecount"+vote+"  ,"+Vote_avg);

        overView.setText(overview);
// app_bar.setBackgroundResource(backdrop);
        Picasso.with(getApplicationContext()).load(image_base+poster_path).into(poster);
        Picasso.with(getApplicationContext()).load(image_base+backdrop_path).into( backdrop);
    }
}
