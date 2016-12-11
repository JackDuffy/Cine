package uk.ac.lincoln.jackduffy.cine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

//rest stuff
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import android.widget.*;
import java.util.Date;
import java.util.List;

import android.util.Log;

import com.wonderkiln.blurkit.BlurKit;

public class MainUI extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    int tmdb_mode; //0 is pull the most popular movies, 1 is to pull the latest movies
    String apiKey = "api_key=822b6a3af922b0c70d5455e2d2e0f782";
    Boolean tmbd_update = false;
    String poster_path;
    String backdrop_path;
    String ID;

    //region Generate 20 ImageView elements
    ImageView featured_poster_1; ImageView featured_backdrop_1;
    ImageView featured_poster_2; ImageView featured_backdrop_2;
    ImageView featured_poster_3; ImageView featured_backdrop_3;
    TextView featured_name_1;

    ImageView poster_1;
    ImageView poster_2;
    ImageView poster_3;
    ImageView poster_4;
    ImageView poster_5;
    ImageView poster_6;
    ImageView poster_7;
    ImageView poster_8;
    ImageView poster_9;
    ImageView poster_10;
    ImageView poster_11;
    ImageView poster_12;
    ImageView poster_13;
    ImageView poster_14;
    ImageView poster_15;
    ImageView poster_16;
    ImageView poster_17;
    ImageView poster_18;
    ImageView poster_19;
    ImageView poster_20;
    ImageView poster_21;
    ImageView poster_22;
    ImageView poster_23;
    ImageView poster_24;
    ImageView poster_25;
    ImageView poster_26;
    ImageView poster_27;
    ImageView poster_28;
    ImageView poster_29;
    ImageView poster_30;
    ImageView poster_31;
    ImageView poster_32;
    ImageView poster_33;
    ImageView poster_34;
    ImageView poster_35;
    ImageView poster_36;
    ImageView poster_37;
    ImageView poster_38;
    ImageView poster_39;
    ImageView poster_40;
    ImageView poster_41;
    ImageView poster_42;
    ImageView poster_43;
    ImageView poster_44;
    ImageView poster_45;
    ImageView poster_46;
    ImageView poster_47;
    ImageView poster_48;
    ImageView poster_49;
    ImageView poster_50;
    ImageView poster_51;
    ImageView poster_52;
    ImageView poster_53;
    ImageView poster_54;
    ImageView poster_55;
    ImageView poster_56;
    ImageView poster_57;
    ImageView poster_58;
    ImageView poster_59;
    ImageView poster_60;
    //endregion

    //region Generate 20 Bitmap items
    Bitmap featured_poster_bitmap_1; Bitmap featured_backdrop_bitmap_1;
    Bitmap featured_poster_bitmap_2; Bitmap featured_backdrop_bitmap_2;
    Bitmap featured_poster_bitmap_3; Bitmap featured_backdrop_bitmap_3;
    String featured_name_string_1;

    Bitmap bitmap_1;
    Bitmap bitmap_2;
    Bitmap bitmap_3;
    Bitmap bitmap_4;
    Bitmap bitmap_5;
    Bitmap bitmap_6;
    Bitmap bitmap_7;
    Bitmap bitmap_8;
    Bitmap bitmap_9;
    Bitmap bitmap_10;
    Bitmap bitmap_11;
    Bitmap bitmap_12;
    Bitmap bitmap_13;
    Bitmap bitmap_14;
    Bitmap bitmap_15;
    Bitmap bitmap_16;
    Bitmap bitmap_17;
    Bitmap bitmap_18;
    Bitmap bitmap_19;
    Bitmap bitmap_20;
    Bitmap bitmap_21;
    Bitmap bitmap_22;
    Bitmap bitmap_23;
    Bitmap bitmap_24;
    Bitmap bitmap_25;
    Bitmap bitmap_26;
    Bitmap bitmap_27;
    Bitmap bitmap_28;
    Bitmap bitmap_29;
    Bitmap bitmap_30;
    Bitmap bitmap_31;
    Bitmap bitmap_32;
    Bitmap bitmap_33;
    Bitmap bitmap_34;
    Bitmap bitmap_35;
    Bitmap bitmap_36;
    Bitmap bitmap_37;
    Bitmap bitmap_38;
    Bitmap bitmap_39;
    Bitmap bitmap_40;
    Bitmap bitmap_41;
    Bitmap bitmap_42;
    Bitmap bitmap_43;
    Bitmap bitmap_44;
    Bitmap bitmap_45;
    Bitmap bitmap_46;
    Bitmap bitmap_47;
    Bitmap bitmap_48;
    Bitmap bitmap_49;
    Bitmap bitmap_50;
    Bitmap bitmap_51;
    Bitmap bitmap_52;
    Bitmap bitmap_53;
    Bitmap bitmap_54;
    Bitmap bitmap_55;
    Bitmap bitmap_56;
    Bitmap bitmap_57;
    Bitmap bitmap_58;
    Bitmap bitmap_59;
    Bitmap bitmap_60;
    //endregion

    //region Generate 20 String items
    String movie_id_1;
    String movie_id_2;
    String movie_id_3;
    String movie_id_4;
    String movie_id_5;
    String movie_id_6;
    String movie_id_7;
    String movie_id_8;
    String movie_id_9;
    String movie_id_10;
    String movie_id_11;
    String movie_id_12;
    String movie_id_13;
    String movie_id_14;
    String movie_id_15;
    String movie_id_16;
    String movie_id_17;
    String movie_id_18;
    String movie_id_19;
    String movie_id_20;
    String movie_id_21;
    String movie_id_22;
    String movie_id_23;
    String movie_id_24;
    String movie_id_25;
    String movie_id_26;
    String movie_id_27;
    String movie_id_28;
    String movie_id_29;
    String movie_id_30;
    String movie_id_31;
    String movie_id_32;
    String movie_id_33;
    String movie_id_34;
    String movie_id_35;
    String movie_id_36;
    String movie_id_37;
    String movie_id_38;
    String movie_id_39;
    String movie_id_40;
    String movie_id_41;
    String movie_id_42;
    String movie_id_43;
    String movie_id_44;
    String movie_id_45;
    String movie_id_46;
    String movie_id_47;
    String movie_id_48;
    String movie_id_49;
    String movie_id_50;
    String movie_id_51;
    String movie_id_52;
    String movie_id_53;
    String movie_id_54;
    String movie_id_55;
    String movie_id_56;
    String movie_id_57;
    String movie_id_58;
    String movie_id_59;
    String movie_id_60;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //region Initialise the activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ui);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //endregion

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent search = new Intent(getApplicationContext(), SearchUI.class);
                startActivity(search);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //region Populate the popular movies section
        tmdb_mode = 1;
        tmbd_update = true;
        new get_movie_data().execute();

        while(tmbd_update == true)
        {
            //do nothing
        }

        //region Apply Popular Movie Posters
        poster_1.setImageBitmap(bitmap_1);
        poster_2.setImageBitmap(bitmap_2);
        poster_3.setImageBitmap(bitmap_3);
        poster_4.setImageBitmap(bitmap_4);
        poster_5.setImageBitmap(bitmap_5);
        poster_6.setImageBitmap(bitmap_6);
        poster_7.setImageBitmap(bitmap_7);
        poster_8.setImageBitmap(bitmap_8);
        poster_9.setImageBitmap(bitmap_9);
        poster_10.setImageBitmap(bitmap_10);
        poster_11.setImageBitmap(bitmap_11);
        poster_12.setImageBitmap(bitmap_12);
        poster_13.setImageBitmap(bitmap_13);
        poster_14.setImageBitmap(bitmap_14);
        poster_15.setImageBitmap(bitmap_15);
        poster_16.setImageBitmap(bitmap_16);
        poster_17.setImageBitmap(bitmap_17);
        poster_18.setImageBitmap(bitmap_18);
        poster_19.setImageBitmap(bitmap_19);
        poster_20.setImageBitmap(bitmap_20);

        poster_21.setImageBitmap(bitmap_21);
        poster_22.setImageBitmap(bitmap_22);
        poster_23.setImageBitmap(bitmap_23);
        poster_24.setImageBitmap(bitmap_24);
        poster_25.setImageBitmap(bitmap_25);
        poster_26.setImageBitmap(bitmap_26);
        poster_27.setImageBitmap(bitmap_27);
        poster_28.setImageBitmap(bitmap_28);
        poster_29.setImageBitmap(bitmap_29);
        poster_30.setImageBitmap(bitmap_30);
        poster_31.setImageBitmap(bitmap_31);
        poster_32.setImageBitmap(bitmap_32);
        poster_33.setImageBitmap(bitmap_33);
        poster_34.setImageBitmap(bitmap_34);
        poster_35.setImageBitmap(bitmap_35);
        poster_36.setImageBitmap(bitmap_36);
        poster_37.setImageBitmap(bitmap_37);
        poster_38.setImageBitmap(bitmap_38);
        poster_39.setImageBitmap(bitmap_39);
        poster_40.setImageBitmap(bitmap_40);

        poster_41.setImageBitmap(bitmap_41);
        poster_42.setImageBitmap(bitmap_42);
        poster_43.setImageBitmap(bitmap_43);
        poster_44.setImageBitmap(bitmap_44);
        poster_45.setImageBitmap(bitmap_45);
        poster_46.setImageBitmap(bitmap_46);
        poster_47.setImageBitmap(bitmap_47);
        poster_48.setImageBitmap(bitmap_48);
        poster_49.setImageBitmap(bitmap_49);
        poster_50.setImageBitmap(bitmap_50);
        poster_51.setImageBitmap(bitmap_51);
        poster_52.setImageBitmap(bitmap_52);
        poster_53.setImageBitmap(bitmap_53);
        poster_54.setImageBitmap(bitmap_54);
        poster_55.setImageBitmap(bitmap_55);
        poster_56.setImageBitmap(bitmap_56);
        poster_57.setImageBitmap(bitmap_57);
        poster_58.setImageBitmap(bitmap_58);
        poster_59.setImageBitmap(bitmap_59);
        poster_60.setImageBitmap(bitmap_60);
        //endregion
        //endregion

        //region Populate the featured movie poster/backdrop
        tmdb_mode = 0;
        tmbd_update = true;
        new get_movie_data().execute();

        while(tmbd_update == true)
        {
            //do nothing
        }

        //region Apply featured movie poster/backdrop
        featured_poster_1.setImageBitmap(featured_poster_bitmap_1);
        featured_backdrop_1.setImageBitmap(featured_backdrop_bitmap_1);
        featured_name_1.setText(featured_name_string_1);
        //endregion
        //endregion





    }

    // added asynctask class methods below -  you can make this class as a separate class file
    public class get_movie_data extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {}

        @Override
        protected String doInBackground(String... arg0)
        {
            String url;
            switch(tmdb_mode)
            {
                case 0:
                    //region Use API to gather poster URL and backdrop URL for the featured movie section
                url = "https://api.themoviedb.org/3/movie/now_playing?" + apiKey + "&language=en-US&page=1";

                try
                {
                    httpConnect jParser = new httpConnect();
                    JSONObject json1obj = new JSONObject(jParser.getJSONFromUrl(url));
                    JSONArray json1arr = json1obj.getJSONArray("results");

                    List<String> movieNames = new ArrayList<String>(json1arr.length());
                    List<String> posterPaths = new ArrayList<String>(json1arr.length());
                    List<String> backdropPaths = new ArrayList<String>(json1arr.length());

                    for (int i = 0; i < json1arr.length(); i++) {
                        JSONObject ithObject = json1arr.getJSONObject(i);
                        if (ithObject.has("poster_path"))
                        {
                            movieNames.add(ithObject.getString("title"));
                            posterPaths.add(ithObject.getString("poster_path"));

                            if (ithObject.has("backdrop_path"))
                            {
                                backdropPaths.add(ithObject.getString("backdrop_path"));
                            }

                            else
                            {
                                backdropPaths.add("/6I2tPx6KIiBB4TWFiWwNUzrbxUn.jpg");
                            }
                        }
                    }

                    for(String movieName : movieNames)
                    {
                        featured_name_1 = (TextView)findViewById(R.id.featured_movie_name);
                        featured_name_string_1 = movieName;
                        break;
                    }

                    for (String posterPath : posterPaths)
                    {
                        poster_path = "https://image.tmdb.org/t/p/w300_and_h450_bestv2" + posterPath;
                        featured_poster_1 = (ImageView) findViewById(R.id.featured_poster_1);
                        featured_poster_bitmap_1 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                        break;
                    }

                    for (String backdropPath : backdropPaths)
                    {
                        backdrop_path = "https://image.tmdb.org/t/p/w500_and_h281_bestv2" + backdropPath;
                        featured_backdrop_1 = (ImageView) findViewById(R.id.featured_backdrop_1);
                        featured_backdrop_bitmap_1 = BitmapFactory.decodeStream((InputStream) new URL(backdrop_path).getContent());
                        break;
                    }
                }

                catch (Exception e)
                {

                }

                    tmbd_update = false;
                    break;
                //endregion

                case 1:
                    //region Use API to gather poster URL's and movie ID's for the Movies section

                    //region Now Playing Movies
                    url = "https://api.themoviedb.org/3/movie/now_playing?" + apiKey + "&language=en-US&page=1";

                    try
                    {
                        httpConnect jParser = new httpConnect();
                        JSONObject json2obj = new JSONObject(jParser.getJSONFromUrl(url));
                        JSONArray json2arr = json2obj.getJSONArray("results");
                        List<String> movieIDs = new ArrayList<String>(json2arr.length());
                        List<String> posterPaths = new ArrayList<String>(json2arr.length());

                        for (int i = 0 ; i < json2arr.length(); i++)
                        {
                            JSONObject ithObject = json2arr.getJSONObject(i);
                            if (ithObject.has("poster_path") && (ithObject.has("id")))
                            {
                                movieIDs.add(ithObject.getString("id"));
                                posterPaths.add(ithObject.getString("poster_path"));
                            }
                        }

                        int movie_ID_number = 1;
                        for (String movieID : movieIDs)
                        {
                            if(movie_ID_number <=20)
                            {
                                ID = movieID;

                                //region Apply the correct ID to each ID string
                                switch (movie_ID_number)
                                {
                                    case 1:
                                        movie_id_1 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 2:
                                        movie_id_2 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 3:
                                        movie_id_3 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 4:
                                        movie_id_4 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 5:
                                        movie_id_5 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 6:
                                        movie_id_6 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 7:
                                        movie_id_7 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 8:
                                        movie_id_8 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 9:
                                        movie_id_9 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 10:
                                        movie_id_10 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 11:
                                        movie_id_11 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 12:
                                        movie_id_12 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 13:
                                        movie_id_13 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 14:
                                        movie_id_14 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 15:
                                        movie_id_15 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 16:
                                        movie_id_16 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 17:
                                        movie_id_17 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 18:
                                        movie_id_18 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 19:
                                        movie_id_19 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 20:
                                        movie_id_20 = ID;
                                        movie_ID_number++;
                                        break;
                                }
                                //endregion
                            }

                            else
                            {
                                break;
                            }

                        }

                        int poster_number = 1;
                        for (String posterPath : posterPaths)
                        {

                            if(poster_number <= 20)
                            {
                                poster_path = "https://image.tmdb.org/t/p/w300_and_h450_bestv2" + posterPath;

                                //region Locate the card element in the activity and apply the correct poster URL's to each corrosponding bitmap
                                switch(poster_number)
                                {
                                    case 1:
                                        poster_1 = (ImageView)findViewById(R.id.now_playing_movie_poster_1);
                                        bitmap_1 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 2:
                                        poster_2 = (ImageView)findViewById(R.id.now_playing_movie_poster_2);
                                        bitmap_2 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 3:
                                        poster_3 = (ImageView)findViewById(R.id.now_playing_movie_poster_3);
                                        bitmap_3 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 4:
                                        poster_4 = (ImageView)findViewById(R.id.now_playing_movie_poster_4);
                                        bitmap_4 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 5:
                                        poster_5 = (ImageView)findViewById(R.id.now_playing_movie_poster_5);
                                        bitmap_5 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 6:
                                        poster_6 = (ImageView)findViewById(R.id.now_playing_movie_poster_6);
                                        bitmap_6 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 7:
                                        poster_7 = (ImageView)findViewById(R.id.now_playing_movie_poster_7);
                                        bitmap_7 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 8:
                                        poster_8 = (ImageView)findViewById(R.id.now_playing_movie_poster_8);
                                        bitmap_8 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 9:
                                        poster_9 = (ImageView)findViewById(R.id.now_playing_movie_poster_9);
                                        bitmap_9 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 10:
                                        poster_10 = (ImageView)findViewById(R.id.now_playing_movie_poster_10);
                                        bitmap_10 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 11:
                                        poster_11 = (ImageView)findViewById(R.id.now_playing_movie_poster_11);
                                        bitmap_11 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 12:
                                        poster_12 = (ImageView)findViewById(R.id.now_playing_movie_poster_12);
                                        bitmap_12 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 13:
                                        poster_13 = (ImageView)findViewById(R.id.now_playing_movie_poster_13);
                                        bitmap_13 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 14:
                                        poster_14 = (ImageView)findViewById(R.id.now_playing_movie_poster_14);
                                        bitmap_14 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 15:
                                        poster_15 = (ImageView)findViewById(R.id.now_playing_movie_poster_15);
                                        bitmap_15 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 16:
                                        poster_16 = (ImageView)findViewById(R.id.now_playing_movie_poster_16);
                                        bitmap_16 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 17:
                                        poster_17 = (ImageView)findViewById(R.id.now_playing_movie_poster_17);
                                        bitmap_17 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 18:
                                        poster_18 = (ImageView)findViewById(R.id.now_playing_movie_poster_18);
                                        bitmap_18 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 19:
                                        poster_19 = (ImageView)findViewById(R.id.now_playing_movie_poster_19);
                                        bitmap_19 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 20:
                                        poster_20 = (ImageView)findViewById(R.id.now_playing_movie_poster_20);
                                        bitmap_20 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                }
                                //endregion
                                //endregion
                            }

                            else
                            {
                                break;
                            }
                        }
                    }

                    catch (Exception e)
                    {

                    }
                    //endregion










                    //region Popular Movies
                    url = "https://api.themoviedb.org/3/discover/movie?" + apiKey + "&sort_by=popularity.desc";

                    try
                    {
                        httpConnect jParser = new httpConnect();
                        JSONObject json2obj = new JSONObject(jParser.getJSONFromUrl(url));
                        JSONArray json2arr = json2obj.getJSONArray("results");
                        List<String> movieIDs = new ArrayList<String>(json2arr.length());
                        List<String> posterPaths = new ArrayList<String>(json2arr.length());

                        for (int i = 0 ; i < json2arr.length(); i++)
                        {
                            JSONObject ithObject = json2arr.getJSONObject(i);
                            if (ithObject.has("poster_path") && (ithObject.has("id")))
                            {
                                movieIDs.add(ithObject.getString("id"));
                                posterPaths.add(ithObject.getString("poster_path"));
                            }
                        }

                        int movie_ID_number = 1;
                        for (String movieID : movieIDs)
                        {
                            if(movie_ID_number <=20)
                            {
                                //ID = "https://www.themoviedb.org/movie/" + movieID;
                                ID = movieID;

                                //region Apply the correct ID to each ID string
                                switch (movie_ID_number)
                                {
                                    case 1:
                                        movie_id_21 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 2:
                                        movie_id_22 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 3:
                                        movie_id_23 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 4:
                                        movie_id_24 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 5:
                                        movie_id_25 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 6:
                                        movie_id_26 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 7:
                                        movie_id_27 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 8:
                                        movie_id_28 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 9:
                                        movie_id_29 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 10:
                                        movie_id_30 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 11:
                                        movie_id_31 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 12:
                                        movie_id_32 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 13:
                                        movie_id_33 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 14:
                                        movie_id_34 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 15:
                                        movie_id_35 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 16:
                                        movie_id_36 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 17:
                                        movie_id_37 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 18:
                                        movie_id_38 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 19:
                                        movie_id_39 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 20:
                                        movie_id_40 = ID;
                                        movie_ID_number++;
                                        break;
                                }
                                //endregion
                            }

                            else
                            {
                                break;
                            }

                        }

                        int poster_number = 1;
                        for (String posterPath : posterPaths)
                        {

                            if(poster_number <= 20)
                            {
                                poster_path = "https://image.tmdb.org/t/p/w300_and_h450_bestv2" + posterPath;

                                //region Locate the card element in the activity and apply the correct poster URL's to each corrosponding bitmap
                                switch(poster_number)
                                {
                                    case 1:
                                        poster_21 = (ImageView)findViewById(R.id.popular_movie_poster_1);
                                        bitmap_21 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 2:
                                        poster_22 = (ImageView)findViewById(R.id.popular_movie_poster_2);
                                        bitmap_22 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 3:
                                        poster_23 = (ImageView)findViewById(R.id.popular_movie_poster_3);
                                        bitmap_23 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 4:
                                        poster_24 = (ImageView)findViewById(R.id.popular_movie_poster_4);
                                        bitmap_24 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 5:
                                        poster_25 = (ImageView)findViewById(R.id.popular_movie_poster_5);
                                        bitmap_25 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 6:
                                        poster_26 = (ImageView)findViewById(R.id.popular_movie_poster_6);
                                        bitmap_26 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 7:
                                        poster_27 = (ImageView)findViewById(R.id.popular_movie_poster_7);
                                        bitmap_27 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 8:
                                        poster_28 = (ImageView)findViewById(R.id.popular_movie_poster_8);
                                        bitmap_28 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 9:
                                        poster_29 = (ImageView)findViewById(R.id.popular_movie_poster_9);
                                        bitmap_29 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 10:
                                        poster_30 = (ImageView)findViewById(R.id.popular_movie_poster_10);
                                        bitmap_30 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 11:
                                        poster_31 = (ImageView)findViewById(R.id.popular_movie_poster_11);
                                        bitmap_31 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 12:
                                        poster_32 = (ImageView)findViewById(R.id.popular_movie_poster_12);
                                        bitmap_32 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 13:
                                        poster_33 = (ImageView)findViewById(R.id.popular_movie_poster_13);
                                        bitmap_33 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 14:
                                        poster_34 = (ImageView)findViewById(R.id.popular_movie_poster_14);
                                        bitmap_34 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 15:
                                        poster_35 = (ImageView)findViewById(R.id.popular_movie_poster_15);
                                        bitmap_35 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 16:
                                        poster_36 = (ImageView)findViewById(R.id.popular_movie_poster_16);
                                        bitmap_36 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 17:
                                        poster_37 = (ImageView)findViewById(R.id.popular_movie_poster_17);
                                        bitmap_37 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 18:
                                        poster_38 = (ImageView)findViewById(R.id.popular_movie_poster_18);
                                        bitmap_38 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 19:
                                        poster_39 = (ImageView)findViewById(R.id.popular_movie_poster_19);
                                        bitmap_39 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 20:
                                        poster_40 = (ImageView)findViewById(R.id.popular_movie_poster_20);
                                        bitmap_40 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                }
                                //endregion
                                //endregion
                            }

                            else
                            {
                                break;
                            }
                        }
                    }
                    //endregion

                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }



                    //region Highest Rated Movies
                    url = "https://api.themoviedb.org/3/discover/movie?" + apiKey + "&language=en-US&sort_by=vote_count.desc";

                    try
                    {
                        httpConnect jParser = new httpConnect();
                        JSONObject json2obj = new JSONObject(jParser.getJSONFromUrl(url));
                        JSONArray json2arr = json2obj.getJSONArray("results");
                        List<String> movieIDs = new ArrayList<String>(json2arr.length());
                        List<String> posterPaths = new ArrayList<String>(json2arr.length());

                        for (int i = 0 ; i < json2arr.length(); i++)
                        {
                            JSONObject ithObject = json2arr.getJSONObject(i);
                            if (ithObject.has("poster_path") && (ithObject.has("id")))
                            {
                                movieIDs.add(ithObject.getString("id"));
                                posterPaths.add(ithObject.getString("poster_path"));
                            }
                        }

                        int movie_ID_number = 1;
                        for (String movieID : movieIDs)
                        {
                            if(movie_ID_number <=20)
                            {
                                //ID = "https://www.themoviedb.org/movie/" + movieID;
                                ID = movieID;

                                //region Apply the correct ID to each ID string
                                switch (movie_ID_number)
                                {
                                    case 1:
                                        movie_id_41 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 2:
                                        movie_id_42 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 3:
                                        movie_id_43 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 4:
                                        movie_id_44 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 5:
                                        movie_id_45 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 6:
                                        movie_id_46 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 7:
                                        movie_id_47 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 8:
                                        movie_id_48 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 9:
                                        movie_id_49 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 10:
                                        movie_id_50 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 11:
                                        movie_id_51 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 12:
                                        movie_id_52 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 13:
                                        movie_id_53 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 14:
                                        movie_id_54 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 15:
                                        movie_id_55 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 16:
                                        movie_id_56 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 17:
                                        movie_id_57 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 18:
                                        movie_id_58 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 19:
                                        movie_id_59 = ID;
                                        movie_ID_number++;
                                        break;
                                    case 20:
                                        movie_id_60 = ID;
                                        movie_ID_number++;
                                        break;
                                }
                                //endregion
                            }

                            else
                            {
                                break;
                            }

                        }

                        int poster_number = 1;
                        for (String posterPath : posterPaths)
                        {

                            if(poster_number <= 20)
                            {
                                poster_path = "https://image.tmdb.org/t/p/w300_and_h450_bestv2" + posterPath;

                                //region Locate the card element in the activity and apply the correct poster URL's to each corrosponding bitmap
                                switch(poster_number)
                                {
                                    case 1:
                                        poster_41 = (ImageView)findViewById(R.id.highest_rated_movie_poster_1);
                                        bitmap_41 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 2:
                                        poster_42 = (ImageView)findViewById(R.id.highest_rated_movie_poster_2);
                                        bitmap_42 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 3:
                                        poster_43 = (ImageView)findViewById(R.id.highest_rated_movie_poster_3);
                                        bitmap_43 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 4:
                                        poster_44 = (ImageView)findViewById(R.id.highest_rated_movie_poster_4);
                                        bitmap_44 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 5:
                                        poster_45 = (ImageView)findViewById(R.id.highest_rated_movie_poster_5);
                                        bitmap_45 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 6:
                                        poster_46 = (ImageView)findViewById(R.id.highest_rated_movie_poster_6);
                                        bitmap_46 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 7:
                                        poster_47 = (ImageView)findViewById(R.id.highest_rated_movie_poster_7);
                                        bitmap_47 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 8:
                                        poster_48 = (ImageView)findViewById(R.id.highest_rated_movie_poster_8);
                                        bitmap_48 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 9:
                                        poster_49 = (ImageView)findViewById(R.id.highest_rated_movie_poster_9);
                                        bitmap_49 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 10:
                                        poster_50 = (ImageView)findViewById(R.id.highest_rated_movie_poster_10);
                                        bitmap_50 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 11:
                                        poster_51 = (ImageView)findViewById(R.id.highest_rated_movie_poster_11);
                                        bitmap_51 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 12:
                                        poster_52 = (ImageView)findViewById(R.id.highest_rated_movie_poster_12);
                                        bitmap_52 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 13:
                                        poster_53 = (ImageView)findViewById(R.id.highest_rated_movie_poster_13);
                                        bitmap_53 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 14:
                                        poster_54 = (ImageView)findViewById(R.id.highest_rated_movie_poster_14);
                                        bitmap_54 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 15:
                                        poster_55 = (ImageView)findViewById(R.id.highest_rated_movie_poster_15);
                                        bitmap_55 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 16:
                                        poster_56 = (ImageView)findViewById(R.id.highest_rated_movie_poster_16);
                                        bitmap_56 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 17:
                                        poster_57 = (ImageView)findViewById(R.id.highest_rated_movie_poster_17);
                                        bitmap_57 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 18:
                                        poster_58 = (ImageView)findViewById(R.id.highest_rated_movie_poster_18);
                                        bitmap_58 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 19:
                                        poster_59 = (ImageView)findViewById(R.id.highest_rated_movie_poster_19);
                                        bitmap_59 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                    case 20:
                                        poster_60 = (ImageView)findViewById(R.id.highest_rated_movie_poster_20);
                                        bitmap_60 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        poster_number++;
                                        break;
                                }
                                //endregion
                            }

                            else
                            {
                                break;
                            }
                        }
                    }

                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                    System.out.println("data fetched");
                    tmbd_update = false;
                    break;
                //endregion

                //endregion
            }
            return null;
        }

        @Override
        // below method will run when service HTTP request is complete,
        protected void onPostExecute(String strFromDoInBg)
        {
            System.out.println("successful execution");
        }
    }

    //region Movie Click Events
    public void nowPlaying1(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_1);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying2(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_2);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying3(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_3);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying4(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_4);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying5(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_5);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying6(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_6);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying7(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_7);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying8(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_8);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying9(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_9);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying10(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_10);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying11(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_11);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying12(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_12);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying13(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_13);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying14(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_14);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying15(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_15);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying16(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_16);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying17(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_17);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying18(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_18);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying19(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_19);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void nowPlaying20(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        Bundle extras = new Bundle();
        extras.putString("movieID", movie_id_20);
        extras.putString("inCinemas", "true");
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void popular1(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_21);
        startActivity(intent);
    }

    public void popular2(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_22);
        startActivity(intent);
    }

    public void popular3(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_23);
        startActivity(intent);
    }

    public void popular4(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_24);
        startActivity(intent);
    }

    public void popular5(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_25);
        startActivity(intent);
    }

    public void popular6(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_26);
        startActivity(intent);
    }

    public void popular7(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_27);
        startActivity(intent);
    }

    public void popular8(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_28);
        startActivity(intent);
    }

    public void popular9(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_29);
        startActivity(intent);
    }

    public void popular10(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_30);
        startActivity(intent);
    }

    public void popular11(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_31);
        startActivity(intent);
    }

    public void popular12(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_32);
        startActivity(intent);
    }

    public void popular13(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_33);
        startActivity(intent);
    }

    public void popular14(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_34);
        startActivity(intent);
    }

    public void popular15(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_35);
        startActivity(intent);
    }

    public void popular16(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_36);
        startActivity(intent);
    }

    public void popular17(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_37);
        startActivity(intent);
    }

    public void popular18(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_38);
        startActivity(intent);
    }

    public void popular19(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_39);
        startActivity(intent);
    }

    public void popular20(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_40);
        startActivity(intent);
    }

    public void highestRated1(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_41);
        startActivity(intent);
    }

    public void highestRated2(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_42);
        startActivity(intent);
    }

    public void highestRated3(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_43);
        startActivity(intent);
    }

    public void highestRated4(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_44);
        startActivity(intent);
    }

    public void highestRated5(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_45);
        startActivity(intent);
    }

    public void highestRated6(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_46);
        startActivity(intent);
    }

    public void highestRated7(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_47);
        startActivity(intent);
    }

    public void highestRated8(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_48);
        startActivity(intent);
    }

    public void highestRated9(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_49);
        startActivity(intent);
    }

    public void highestRated10(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_50);
        startActivity(intent);
    }

    public void highestRated11(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_51);
        startActivity(intent);
    }

    public void highestRated12(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_52);
        startActivity(intent);
    }

    public void highestRated13(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_53);
        startActivity(intent);
    }

    public void highestRated14(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_54);
        startActivity(intent);
    }

    public void highestRated15(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_55);
        startActivity(intent);
    }

    public void highestRated16(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_56);
        startActivity(intent);
    }

    public void highestRated17(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_57);
        startActivity(intent);
    }

    public void highestRated18(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_58);
        startActivity(intent);
    }

    public void highestRated19(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_59);
        startActivity(intent);
    }

    public void highestRated20(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
        intent.putExtra("movieID", movie_id_60);
        startActivity(intent);
    }
    //endregion

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_ui, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}