package uk.ac.lincoln.jackduffy.cine;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import android.widget.*;
import java.util.Date;
import java.util.List;

import android.util.Log;

import com.jakewharton.processphoenix.ProcessPhoenix;
import com.squareup.picasso.Picasso;
import com.wonderkiln.blurkit.BlurKit;

import jp.wasabeef.picasso.transformations.BlurTransformation;
import jp.wasabeef.picasso.transformations.GrayscaleTransformation;

import static android.R.attr.path;
import static android.R.id.input;

public class MainUI extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    int tmdb_mode = 0; //0 is pull the most popular movies, 1 is to pull everything else
    int save_mode = 0;
    String apiKey = "api_key=822b6a3af922b0c70d5455e2d2e0f782";
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

    //region Generate Bitmap items
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
    String featuredID;
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
        new get_movie_data().execute();
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
                    List<String> movieIDs = new ArrayList<String>(json1arr.length());

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

                            if (ithObject.has("id"))
                            {
                                movieIDs.add(ithObject.getString("id"));
                            }

                            else
                            {

                            }
                        }
                    }

                    java.io.FileInputStream readIn;
                    for(String movieID : movieIDs)
                    {
                        featuredID = movieID;
                        break;
                    }

                    System.out.println("Featured ID is : " + featuredID);
                    Boolean localStorage = false;
                    for(String movieName : movieNames)
                    {
                        featured_name_1 = (TextView)findViewById(R.id.featured_movie_name);
                        featured_name_string_1 = movieName;
                        break;
                    }

                    for (String posterPath : posterPaths)
                    {
                        featured_poster_1 = (ImageView) findViewById(R.id.featured_poster_1);
                        String input = "";


                            input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + featuredID + "_poster.png");
                            featured_poster_bitmap_1 = BitmapFactory.decodeFile(input);
                            System.out.println("Stored poster image retrieved");



                            if(featured_poster_bitmap_1 == null)
                            {
                                System.out.println("Retrieving poster from the web");
                                poster_path = "https://image.tmdb.org/t/p/w300_and_h450_bestv2" + posterPath;
                                featured_poster_bitmap_1 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                            }


                        break;
                    }

                    for (String backdropPath : backdropPaths)
                    {
                        featured_backdrop_1 = (ImageView) findViewById(R.id.featured_backdrop_1);
                        String input = "";

                            input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/backdrops/" + featuredID + "_backdrop.png");
                            featured_backdrop_bitmap_1 = BitmapFactory.decodeFile(input);
                            System.out.println("Stored backdrop image retrieved");


                            if(featured_backdrop_bitmap_1 == null)
                            {
                                System.out.println("Retrieving backdrop from the web");
                                backdrop_path = "https://image.tmdb.org/t/p/w500_and_h281_bestv2" + backdropPath;
                                featured_backdrop_bitmap_1 = BitmapFactory.decodeStream((InputStream) new URL(backdrop_path).getContent());
                            }


                        break;
                    }
                }

                catch (Exception e)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Whoops... Looks like your internet connection was lost. This application will now restart and try again.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    ProcessPhoenix.triggerRebirth(context);
                }

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
                                String input = "";

                                //region Locate the card element in the activity and apply the correct poster URL's to each corrosponding bitmap
                                switch(poster_number)
                                {
                                    case 1:
                                        //region Check poster local availability or fetch data from the web
                                        poster_1 = (ImageView)findViewById(R.id.now_playing_movie_poster_1);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_1 + "_poster.png");
                                        bitmap_1 = BitmapFactory.decodeFile(input);
                                        if(bitmap_1 == null)
                                        {
                                            bitmap_1 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 2:
                                        //region Check poster local availability or fetch data from the web
                                        poster_2 = (ImageView)findViewById(R.id.now_playing_movie_poster_2);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_2 + "_poster.png");
                                        bitmap_2 = BitmapFactory.decodeFile(input);
                                        if(bitmap_2 == null)
                                        {
                                            bitmap_2 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 3:
                                        //region Check poster local availability or fetch data from the web
                                        poster_3 = (ImageView)findViewById(R.id.now_playing_movie_poster_3);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_3 + "_poster.png");
                                        bitmap_3 = BitmapFactory.decodeFile(input);
                                        if(bitmap_3 == null)
                                        {
                                            bitmap_3 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 4:
                                        //region Check poster local availability or fetch data from the web
                                        poster_4 = (ImageView)findViewById(R.id.now_playing_movie_poster_4);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_4 + "_poster.png");
                                        bitmap_4 = BitmapFactory.decodeFile(input);
                                        if(bitmap_4 == null)
                                        {
                                            bitmap_4 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 5:
                                        poster_5 = (ImageView)findViewById(R.id.now_playing_movie_poster_5);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_5 + "_poster.png");
                                        bitmap_5 = BitmapFactory.decodeFile(input);
                                        if(bitmap_5 == null)
                                        {
                                            bitmap_5 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 6:
                                        poster_6 = (ImageView)findViewById(R.id.now_playing_movie_poster_6);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_6 + "_poster.png");
                                        bitmap_6 = BitmapFactory.decodeFile(input);
                                        if(bitmap_6 == null)
                                        {
                                            bitmap_6 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 7:
                                        poster_7 = (ImageView)findViewById(R.id.now_playing_movie_poster_7);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_7 + "_poster.png");
                                        bitmap_7 = BitmapFactory.decodeFile(input);
                                        if(bitmap_7 == null)
                                        {
                                            bitmap_7 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 8:
                                        poster_8 = (ImageView)findViewById(R.id.now_playing_movie_poster_8);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_8 + "_poster.png");
                                        bitmap_8 = BitmapFactory.decodeFile(input);
                                        if(bitmap_8 == null)
                                        {
                                            bitmap_8 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 9:
                                        poster_9 = (ImageView)findViewById(R.id.now_playing_movie_poster_9);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_9 + "_poster.png");
                                        bitmap_9 = BitmapFactory.decodeFile(input);
                                        if(bitmap_9 == null)
                                        {
                                            bitmap_9 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 10:
                                        poster_10 = (ImageView)findViewById(R.id.now_playing_movie_poster_10);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_10 + "_poster.png");
                                        bitmap_10 = BitmapFactory.decodeFile(input);
                                        if(bitmap_10 == null)
                                        {
                                            bitmap_10 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 11:
                                        poster_11 = (ImageView)findViewById(R.id.now_playing_movie_poster_11);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_11 + "_poster.png");
                                        bitmap_11 = BitmapFactory.decodeFile(input);
                                        if(bitmap_11 == null)
                                        {
                                            bitmap_11 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 12:
                                        poster_12 = (ImageView)findViewById(R.id.now_playing_movie_poster_12);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_12 + "_poster.png");
                                        bitmap_12 = BitmapFactory.decodeFile(input);
                                        if(bitmap_12 == null)
                                        {
                                            bitmap_12 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 13:
                                        poster_13 = (ImageView)findViewById(R.id.now_playing_movie_poster_13);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_13 + "_poster.png");
                                        bitmap_13 = BitmapFactory.decodeFile(input);
                                        if(bitmap_13 == null)
                                        {
                                            bitmap_13 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 14:
                                        poster_14 = (ImageView)findViewById(R.id.now_playing_movie_poster_14);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_14 + "_poster.png");
                                        bitmap_14 = BitmapFactory.decodeFile(input);
                                        if(bitmap_14 == null)
                                        {
                                            bitmap_14 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 15:
                                        poster_15 = (ImageView)findViewById(R.id.now_playing_movie_poster_15);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_15 + "_poster.png");
                                        bitmap_15 = BitmapFactory.decodeFile(input);
                                        if(bitmap_15 == null)
                                        {
                                            bitmap_15 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 16:
                                        poster_16 = (ImageView)findViewById(R.id.now_playing_movie_poster_16);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_16 + "_poster.png");
                                        bitmap_16 = BitmapFactory.decodeFile(input);
                                        if(bitmap_16 == null)
                                        {
                                            bitmap_16 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 17:
                                        poster_17 = (ImageView)findViewById(R.id.now_playing_movie_poster_17);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_17 + "_poster.png");
                                        bitmap_17 = BitmapFactory.decodeFile(input);
                                        if(bitmap_17 == null)
                                        {
                                            bitmap_17 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 18:
                                        poster_18 = (ImageView)findViewById(R.id.now_playing_movie_poster_18);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_18 + "_poster.png");
                                        bitmap_18 = BitmapFactory.decodeFile(input);
                                        if(bitmap_18 == null)
                                        {
                                            bitmap_18 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 19:
                                        poster_19 = (ImageView)findViewById(R.id.now_playing_movie_poster_19);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_19 + "_poster.png");
                                        bitmap_19 = BitmapFactory.decodeFile(input);
                                        if(bitmap_19 == null)
                                        {
                                            bitmap_19 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 20:
                                        poster_20 = (ImageView)findViewById(R.id.now_playing_movie_poster_20);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_20 + "_poster.png");
                                        bitmap_20 = BitmapFactory.decodeFile(input);
                                        if(bitmap_20 == null)
                                        {
                                            bitmap_20 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
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
                        Context context = getApplicationContext();
                        CharSequence text = "Whoops... Looks like your internet connection was lost. This application will now restart and try again.";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                        ProcessPhoenix.triggerRebirth(context);
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
                                String input = "";

                                //region Locate the card element in the activity and apply the correct poster URL's to each corrosponding bitmap
                                switch(poster_number)
                                {
                                    case 1:
                                        poster_21 = (ImageView)findViewById(R.id.popular_movie_poster_1);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_21 + "_poster.png");
                                        bitmap_21 = BitmapFactory.decodeFile(input);
                                        if(bitmap_21 == null)
                                        {
                                            bitmap_21 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 2:
                                        poster_22 = (ImageView)findViewById(R.id.popular_movie_poster_2);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_22 + "_poster.png");
                                        bitmap_22 = BitmapFactory.decodeFile(input);
                                        if(bitmap_22 == null)
                                        {
                                            bitmap_22 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 3:
                                        poster_23 = (ImageView)findViewById(R.id.popular_movie_poster_3);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_23 + "_poster.png");
                                        bitmap_23 = BitmapFactory.decodeFile(input);
                                        if(bitmap_23 == null)
                                        {
                                            bitmap_23 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 4:
                                        poster_24 = (ImageView)findViewById(R.id.popular_movie_poster_4);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_24 + "_poster.png");
                                        bitmap_24 = BitmapFactory.decodeFile(input);
                                        if(bitmap_24 == null)
                                        {
                                            bitmap_24 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 5:
                                        poster_25 = (ImageView)findViewById(R.id.popular_movie_poster_5);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_25 + "_poster.png");
                                        bitmap_25 = BitmapFactory.decodeFile(input);
                                        if(bitmap_25 == null)
                                        {
                                            bitmap_25 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 6:
                                        poster_26 = (ImageView)findViewById(R.id.popular_movie_poster_6);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_26 + "_poster.png");
                                        bitmap_26 = BitmapFactory.decodeFile(input);
                                        if(bitmap_26 == null)
                                        {
                                            bitmap_26 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 7:
                                        poster_27 = (ImageView)findViewById(R.id.popular_movie_poster_7);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_27 + "_poster.png");
                                        bitmap_27 = BitmapFactory.decodeFile(input);
                                        if(bitmap_27 == null)
                                        {
                                            bitmap_27 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 8:
                                        poster_28 = (ImageView)findViewById(R.id.popular_movie_poster_8);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_28 + "_poster.png");
                                        bitmap_28 = BitmapFactory.decodeFile(input);
                                        if(bitmap_28 == null)
                                        {
                                            bitmap_28 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 9:
                                        poster_29 = (ImageView)findViewById(R.id.popular_movie_poster_9);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_29 + "_poster.png");
                                        bitmap_29 = BitmapFactory.decodeFile(input);
                                        if(bitmap_29 == null)
                                        {
                                            bitmap_29 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 10:
                                        poster_30 = (ImageView)findViewById(R.id.popular_movie_poster_10);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_30 + "_poster.png");
                                        bitmap_30 = BitmapFactory.decodeFile(input);
                                        if(bitmap_30 == null)
                                        {
                                            bitmap_30 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 11:
                                        poster_31 = (ImageView)findViewById(R.id.popular_movie_poster_11);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_31 + "_poster.png");
                                        bitmap_31 = BitmapFactory.decodeFile(input);
                                        if(bitmap_31 == null)
                                        {
                                            bitmap_31 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 12:
                                        poster_32 = (ImageView)findViewById(R.id.popular_movie_poster_12);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_32 + "_poster.png");
                                        bitmap_32 = BitmapFactory.decodeFile(input);
                                        if(bitmap_32 == null)
                                        {
                                            bitmap_32 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 13:
                                        poster_33 = (ImageView)findViewById(R.id.popular_movie_poster_13);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_33 + "_poster.png");
                                        bitmap_33 = BitmapFactory.decodeFile(input);
                                        if(bitmap_33 == null)
                                        {
                                            bitmap_33 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 14:
                                        poster_34 = (ImageView)findViewById(R.id.popular_movie_poster_14);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_34 + "_poster.png");
                                        bitmap_34 = BitmapFactory.decodeFile(input);
                                        if(bitmap_34 == null)
                                        {
                                            bitmap_34 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 15:
                                        poster_35 = (ImageView)findViewById(R.id.popular_movie_poster_15);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_35 + "_poster.png");
                                        bitmap_35 = BitmapFactory.decodeFile(input);
                                        if(bitmap_35 == null)
                                        {
                                            bitmap_35 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 16:
                                        poster_36 = (ImageView)findViewById(R.id.popular_movie_poster_16);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_36 + "_poster.png");
                                        bitmap_36 = BitmapFactory.decodeFile(input);
                                        if(bitmap_36 == null)
                                        {
                                            bitmap_36 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 17:
                                        poster_37 = (ImageView)findViewById(R.id.popular_movie_poster_17);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_37 + "_poster.png");
                                        bitmap_37 = BitmapFactory.decodeFile(input);
                                        if(bitmap_37 == null)
                                        {
                                            bitmap_37 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 18:
                                        poster_38 = (ImageView)findViewById(R.id.popular_movie_poster_18);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_38 + "_poster.png");
                                        bitmap_38 = BitmapFactory.decodeFile(input);
                                        if(bitmap_38 == null)
                                        {
                                            bitmap_38 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 19:
                                        poster_39 = (ImageView)findViewById(R.id.popular_movie_poster_19);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_39 + "_poster.png");
                                        bitmap_39 = BitmapFactory.decodeFile(input);
                                        if(bitmap_39 == null)
                                        {
                                            bitmap_39 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 20:
                                        poster_40 = (ImageView)findViewById(R.id.popular_movie_poster_20);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_40 + "_poster.png");
                                        bitmap_40 = BitmapFactory.decodeFile(input);
                                        if(bitmap_40 == null)
                                        {
                                            bitmap_40 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
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
                                String input = "";
                                //region Locate the card element in the activity and apply the correct poster URL's to each corrosponding bitmap
                                switch(poster_number)
                                {
                                    case 1:
                                        poster_41 = (ImageView)findViewById(R.id.highest_rated_movie_poster_1);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_41 + "_poster.png");
                                        bitmap_41 = BitmapFactory.decodeFile(input);
                                        if(bitmap_41 == null)
                                        {
                                            bitmap_41 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 2:
                                        poster_42 = (ImageView)findViewById(R.id.highest_rated_movie_poster_2);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_42 + "_poster.png");
                                        bitmap_42 = BitmapFactory.decodeFile(input);
                                        if(bitmap_42 == null)
                                        {
                                            bitmap_42 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 3:
                                        poster_43 = (ImageView)findViewById(R.id.highest_rated_movie_poster_3);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_43 + "_poster.png");
                                        bitmap_43 = BitmapFactory.decodeFile(input);
                                        if(bitmap_43 == null)
                                        {
                                            bitmap_43 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 4:
                                        poster_44 = (ImageView)findViewById(R.id.highest_rated_movie_poster_4);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_44 + "_poster.png");
                                        bitmap_44 = BitmapFactory.decodeFile(input);
                                        if(bitmap_44 == null)
                                        {
                                            bitmap_44 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 5:
                                        poster_45 = (ImageView)findViewById(R.id.highest_rated_movie_poster_5);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_45 + "_poster.png");
                                        bitmap_45 = BitmapFactory.decodeFile(input);
                                        if(bitmap_45 == null)
                                        {
                                            bitmap_45 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 6:
                                        poster_46 = (ImageView)findViewById(R.id.highest_rated_movie_poster_6);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_46 + "_poster.png");
                                        bitmap_46 = BitmapFactory.decodeFile(input);
                                        if(bitmap_46 == null)
                                        {
                                            bitmap_46 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 7:
                                        poster_47 = (ImageView)findViewById(R.id.highest_rated_movie_poster_7);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_47 + "_poster.png");
                                        bitmap_47 = BitmapFactory.decodeFile(input);
                                        if(bitmap_47 == null)
                                        {
                                            bitmap_47 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 8:
                                        poster_48 = (ImageView)findViewById(R.id.highest_rated_movie_poster_8);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_48 + "_poster.png");
                                        bitmap_48 = BitmapFactory.decodeFile(input);
                                        if(bitmap_48 == null)
                                        {
                                            bitmap_48 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 9:
                                        poster_49 = (ImageView)findViewById(R.id.highest_rated_movie_poster_9);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_49 + "_poster.png");
                                        bitmap_49 = BitmapFactory.decodeFile(input);
                                        if(bitmap_49 == null)
                                        {
                                            bitmap_49 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 10:
                                        poster_50 = (ImageView)findViewById(R.id.highest_rated_movie_poster_10);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_50 + "_poster.png");
                                        bitmap_50 = BitmapFactory.decodeFile(input);
                                        if(bitmap_50 == null)
                                        {
                                            bitmap_50 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 11:
                                        poster_51 = (ImageView)findViewById(R.id.highest_rated_movie_poster_11);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_51 + "_poster.png");
                                        bitmap_51 = BitmapFactory.decodeFile(input);
                                        if(bitmap_51 == null)
                                        {
                                            bitmap_51 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 12:
                                        poster_52 = (ImageView)findViewById(R.id.highest_rated_movie_poster_12);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_52 + "_poster.png");
                                        bitmap_52 = BitmapFactory.decodeFile(input);
                                        if(bitmap_52 == null)
                                        {
                                            bitmap_52 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 13:
                                        poster_53 = (ImageView)findViewById(R.id.highest_rated_movie_poster_13);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_53 + "_poster.png");
                                        bitmap_53 = BitmapFactory.decodeFile(input);
                                        if(bitmap_53 == null)
                                        {
                                            bitmap_53 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 14:
                                        poster_54 = (ImageView)findViewById(R.id.highest_rated_movie_poster_14);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_54 + "_poster.png");
                                        bitmap_54 = BitmapFactory.decodeFile(input);
                                        if(bitmap_54 == null)
                                        {
                                            bitmap_54 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 15:
                                        poster_55 = (ImageView)findViewById(R.id.highest_rated_movie_poster_15);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_55 + "_poster.png");
                                        bitmap_55 = BitmapFactory.decodeFile(input);
                                        if(bitmap_55 == null)
                                        {
                                            bitmap_55 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 16:
                                        poster_56 = (ImageView)findViewById(R.id.highest_rated_movie_poster_16);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_56 + "_poster.png");
                                        bitmap_56 = BitmapFactory.decodeFile(input);
                                        if(bitmap_56 == null)
                                        {
                                            bitmap_56 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 17:
                                        poster_57 = (ImageView)findViewById(R.id.highest_rated_movie_poster_17);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_57 + "_poster.png");
                                        bitmap_57 = BitmapFactory.decodeFile(input);
                                        if(bitmap_57 == null)
                                        {
                                            bitmap_57 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 18:
                                        poster_58 = (ImageView)findViewById(R.id.highest_rated_movie_poster_18);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_58 + "_poster.png");
                                        bitmap_58 = BitmapFactory.decodeFile(input);
                                        if(bitmap_58 == null)
                                        {
                                            bitmap_58 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 19:
                                        poster_59 = (ImageView)findViewById(R.id.highest_rated_movie_poster_19);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_59 + "_poster.png");
                                        bitmap_59 = BitmapFactory.decodeFile(input);
                                        if(bitmap_59 == null)
                                        {
                                            bitmap_59 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
                                        poster_number++;
                                        break;
                                    case 20:
                                        poster_60 = (ImageView)findViewById(R.id.highest_rated_movie_poster_20);
                                        input = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/posters/" + movie_id_60 + "_poster.png");
                                        bitmap_60 = BitmapFactory.decodeFile(input);
                                        if(bitmap_60 == null)
                                        {
                                            bitmap_60 = BitmapFactory.decodeStream((InputStream)new URL(poster_path).getContent());
                                        }
                                        //endregion
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
            switch(tmdb_mode)
            {
                case 0:
                    //region Apply featured movie poster/backdrop
                    featured_poster_1.setImageBitmap(featured_poster_bitmap_1);
                    featured_backdrop_1.setImageBitmap(featured_backdrop_bitmap_1);
                    featured_name_1.setText(featured_name_string_1);
                    //endregion

                    new save_movie_data().execute();
                    tmdb_mode = 1;
                    new get_movie_data().execute();
                    break;
                case 1:
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

                    save_mode = 1;
                    new save_movie_data().execute();

                    break;
            }

            System.out.println("successful execution");
        }
    }

    public class save_movie_data extends AsyncTask<String, String, String>
    {
        @Override
        protected void onPreExecute() {}

        @Override
        protected String doInBackground(String... arg0)
        {
            String file_path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/uk.ac.lincoln.jackduffy.cine/";
            File filePath;
            File dir;
            File file;
            FileOutputStream fOut;
            fOut = null;
            switch(save_mode)
            {
                case 0:
                    //region Save poster
                    dir = new File((file_path + "posters"));
                    if(!dir.exists())
                        dir.mkdirs();
                    file = new File(dir, featuredID + "_poster" + ".png");
                    //region Create output stream
                    try
                    {
                        fOut = new FileOutputStream(file);
                    }

                    catch (FileNotFoundException e)
                    {
                        e.printStackTrace();
                    }
                    //endregion
                    featured_poster_bitmap_1.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                    //region Close
                    try
                    {
                        fOut.flush();
                    }

                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                    try
                    {
                        fOut.close();
                    }

                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    //endregion
                    
                    //endregion
                    //region Save Backdrop
                    dir = new File((file_path + "backdrops"));
                    if(!dir.exists())
                        dir.mkdirs();
                    file = new File(dir, featuredID + "_backdrop" + ".png");
                    //region Create output stream
                        try
                        {
                            fOut = new FileOutputStream(file);
                        }

                        catch (FileNotFoundException e)
                        {
                            e.printStackTrace();
                        }
                        //endregion
                    featured_backdrop_bitmap_1.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                    //region Close
                        try
                        {
                            fOut.flush();
                        }

                        catch (IOException e)
                        {
                            e.printStackTrace();
                        }

                        try
                        {
                            fOut.close();
                        }

                        catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                        //endregion
                    
                    //endregion
                    break;
                case 1:
                    //region Save all other posters
                    System.out.println("Initiating loop");
                    dir = new File((file_path + "posters"));
                    if(!dir.exists())dir.mkdirs();

                    for(int chooser = 1; chooser <= 60; chooser++)
                    {
                        switch(chooser)
                        {
                            case 1:
                                //region Save poster
                                file = new File(dir, movie_id_1 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_1.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 2:
                                //region Save poster
                                file = new File(dir, movie_id_2 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_2.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 3:
                                //region Save poster
                                file = new File(dir, movie_id_3 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_3.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 4:
                                //region Save poster
                                file = new File(dir, movie_id_4 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_4.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 5:
                                //region Save poster
                                file = new File(dir, movie_id_5 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_5.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 6:
                                //region Save poster
                                file = new File(dir, movie_id_6 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_6.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 7:
                                //region Save poster
                                file = new File(dir, movie_id_7 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_7.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 8:
                                //region Save poster
                                file = new File(dir, movie_id_8 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_8.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 9:
                                //region Save poster
                                file = new File(dir, movie_id_9 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_9.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 10:
                                //region Save poster
                                file = new File(dir, movie_id_10 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_10.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 12:
                                //region Save poster
                                file = new File(dir, movie_id_12 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_12.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 13:
                                //region Save poster
                                file = new File(dir, movie_id_13 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_13.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 14:
                                //region Save poster
                                file = new File(dir, movie_id_14 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_14.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 15:
                                //region Save poster
                                file = new File(dir, movie_id_15 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_15.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 16:
                                //region Save poster
                                file = new File(dir, movie_id_16 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_16.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 17:
                                //region Save poster
                                file = new File(dir, movie_id_17 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_17.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 18:
                                //region Save poster
                                file = new File(dir, movie_id_18 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_18.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 19:
                                //region Save poster
                                file = new File(dir, movie_id_19 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_19.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 20:
                                //region Save poster
                                file = new File(dir, movie_id_20 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_20.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 21:
                                //region Save poster
                                file = new File(dir, movie_id_21 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_21.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 22:
                                //region Save poster
                                file = new File(dir, movie_id_22 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_22.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 23:
                                //region Save poster
                                file = new File(dir, movie_id_23 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_23.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 24:
                                //region Save poster
                                file = new File(dir, movie_id_24 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_24.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 25:
                                //region Save poster
                                file = new File(dir, movie_id_25 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_25.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 26:
                                //region Save poster
                                file = new File(dir, movie_id_26 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_26.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 27:
                                //region Save poster
                                file = new File(dir, movie_id_27 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_27.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 28:
                                //region Save poster
                                file = new File(dir, movie_id_28 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_28.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 29:
                                //region Save poster
                                file = new File(dir, movie_id_29 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_29.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 30:
                                //region Save poster
                                file = new File(dir, movie_id_30 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_30.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 31:
                                //region Save poster
                                file = new File(dir, movie_id_31 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_31.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 32:
                                //region Save poster
                                file = new File(dir, movie_id_32 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_32.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 33:
                                //region Save poster
                                file = new File(dir, movie_id_33 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_33.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 34:
                                //region Save poster
                                file = new File(dir, movie_id_34 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_34.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 35:
                                //region Save poster
                                file = new File(dir, movie_id_35 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_35.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 36:
                                //region Save poster
                                file = new File(dir, movie_id_36 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_36.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 37:
                                //region Save poster
                                file = new File(dir, movie_id_37 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_37.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 38:
                                //region Save poster
                                file = new File(dir, movie_id_38 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_38.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 39:
                                //region Save poster
                                file = new File(dir, movie_id_39 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_39.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 40:
                                //region Save poster
                                file = new File(dir, movie_id_40 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_40.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 41:
                                //region Save poster
                                file = new File(dir, movie_id_41 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_41.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 42:
                                //region Save poster
                                file = new File(dir, movie_id_42 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_42.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 43:
                                //region Save poster
                                file = new File(dir, movie_id_43 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_43.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 44:
                                //region Save poster
                                file = new File(dir, movie_id_44 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_44.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 45:
                                //region Save poster
                                file = new File(dir, movie_id_45 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_45.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 46:
                                //region Save poster
                                file = new File(dir, movie_id_46 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_46.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 47:
                                //region Save poster
                                file = new File(dir, movie_id_47 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_47.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 48:
                                //region Save poster
                                file = new File(dir, movie_id_48 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_48.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 49:
                                //region Save poster
                                file = new File(dir, movie_id_49 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_49.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 50:
                                //region Save poster
                                file = new File(dir, movie_id_50 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_50.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 51:
                                //region Save poster
                                file = new File(dir, movie_id_51 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_51.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 52:
                                //region Save poster
                                file = new File(dir, movie_id_52 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_52.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 53:
                                //region Save poster
                                file = new File(dir, movie_id_53 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_53.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 54:
                                //region Save poster
                                file = new File(dir, movie_id_54 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_54.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 55:
                                //region Save poster
                                file = new File(dir, movie_id_55 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_55.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 56:
                                //region Save poster
                                file = new File(dir, movie_id_56 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_56.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 57:
                                //region Save poster
                                file = new File(dir, movie_id_57 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_57.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 58:
                                //region Save poster
                                file = new File(dir, movie_id_58 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_58.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 59:
                                //region Save poster
                                file = new File(dir, movie_id_59 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_59.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                            case 60:
                                //region Save poster
                                file = new File(dir, movie_id_60 + "_poster" + ".png");
                                //region Create output stream
                                try
                                {
                                    fOut = new FileOutputStream(file);
                                }

                                catch (FileNotFoundException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                bitmap_60.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                //region Close
                                try
                                {
                                    fOut.flush();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }

                                try
                                {
                                    fOut.close();
                                }

                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                                //endregion
                                
                                //endregion
                                break;
                        }
                    }
                    //endregion
                    break;
            }
            return null;
        }

        @Override
        protected void onPostExecute(String strFromDoInBg) {}
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