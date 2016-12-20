package uk.ac.lincoln.jackduffy.cine;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import org.json.JSONArray;
import org.json.JSONObject;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import android.widget.*;
import java.util.List;

//places api
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;

import android.support.v4.app.FragmentActivity;

import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Place;

public class MovieDetailsUI extends FragmentActivity
{
    GooglePlaces client = new GooglePlaces("AIzaSyD843heTIXouL7yIZ6O1DQZP-WDC23e9f0");

    String apiKey = "?api_key=822b6a3af922b0c70d5455e2d2e0f782";
    String ID; //holds the url of the movie
    String inCinemas;
    String poster_path; //holds the url of the movie poster
    String backdrop_path; //holds the url of the movie backdrop
    String movie_title;
    String movie_release_date;
    String movie_tagline;
    String movie_overview;
    String movie_rating;

    Integer CastCrew_Error_No = 0;
    View missingTagline;

    String movie_runtime;
    String movie_language;
    String movie_budget;
    String movie_revenue;
    String movie_voters;

    //region Generate strings, views & bitmaps
    //region Generate castmember strings
    String castmember_img;
    String castmember_1_character;
    String castmember_2_character;
    String castmember_3_character;
    String castmember_4_character;
    String castmember_5_character;
    String castmember_6_character;
    String castmember_7_character;
    String castmember_8_character;
    String castmember_9_character;
    String castmember_10_character;

    String castmember_1_id;
    String castmember_2_id;
    String castmember_3_id;
    String castmember_4_id;
    String castmember_5_id;
    String castmember_6_id;
    String castmember_7_id;
    String castmember_8_id;
    String castmember_9_id;
    String castmember_10_id;

    String castmember_1_name;
    String castmember_2_name;
    String castmember_3_name;
    String castmember_4_name;
    String castmember_5_name;
    String castmember_6_name;
    String castmember_7_name;
    String castmember_8_name;
    String castmember_9_name;
    String castmember_10_name;
    //endregion

    //region Generate castmember Views & Bitmaps
    TextView castmember1Character;
    TextView castmember2Character;
    TextView castmember3Character;
    TextView castmember4Character;
    TextView castmember5Character;
    TextView castmember6Character;
    TextView castmember7Character;
    TextView castmember8Character;
    TextView castmember9Character;
    TextView castmember10Character;

    TextView castmember1ID;
    TextView castmember2ID;
    TextView castmember3ID;
    TextView castmember4ID;
    TextView castmember5ID;
    TextView castmember6ID;
    TextView castmember7ID;
    TextView castmember8ID;
    TextView castmember9ID;
    TextView castmember10ID;

    TextView castmember1Name;
    TextView castmember2Name;
    TextView castmember3Name;
    TextView castmember4Name;
    TextView castmember5Name;
    TextView castmember6Name;
    TextView castmember7Name;
    TextView castmember8Name;
    TextView castmember9Name;
    TextView castmember10Name;

    ImageView castmember1Img;
    ImageView castmember2Img;
    ImageView castmember3Img;
    ImageView castmember4Img;
    ImageView castmember5Img;
    ImageView castmember6Img;
    ImageView castmember7Img;
    ImageView castmember8Img;
    ImageView castmember9Img;
    ImageView castmember10Img;

    Bitmap castmember1ImgBitmap;
    Bitmap castmember2ImgBitmap;
    Bitmap castmember3ImgBitmap;
    Bitmap castmember4ImgBitmap;
    Bitmap castmember5ImgBitmap;
    Bitmap castmember6ImgBitmap;
    Bitmap castmember7ImgBitmap;
    Bitmap castmember8ImgBitmap;
    Bitmap castmember9ImgBitmap;
    Bitmap castmember10ImgBitmap;
    //endregion

    //region Generate crewmember strings
    String crewmember_img;
    String crewmember_1_job;
    String crewmember_2_job;
    String crewmember_3_job;
    String crewmember_4_job;
    String crewmember_5_job;
    String crewmember_6_job;
    String crewmember_7_job;
    String crewmember_8_job;
    String crewmember_9_job;
    String crewmember_10_job;

    String crewmember_1_id;
    String crewmember_2_id;
    String crewmember_3_id;
    String crewmember_4_id;
    String crewmember_5_id;
    String crewmember_6_id;
    String crewmember_7_id;
    String crewmember_8_id;
    String crewmember_9_id;
    String crewmember_10_id;

    String crewmember_1_name;
    String crewmember_2_name;
    String crewmember_3_name;
    String crewmember_4_name;
    String crewmember_5_name;
    String crewmember_6_name;
    String crewmember_7_name;
    String crewmember_8_name;
    String crewmember_9_name;
    String crewmember_10_name;

    //endregion

    //region Generate crewmember Views & Bitmaps
    TextView crewmember1Job;
    TextView crewmember2Job;
    TextView crewmember3Job;
    TextView crewmember4Job;
    TextView crewmember5Job;
    TextView crewmember6Job;
    TextView crewmember7Job;
    TextView crewmember8Job;
    TextView crewmember9Job;
    TextView crewmember10Job;

    TextView crewmember1ID;
    TextView crewmember2ID;
    TextView crewmember3ID;
    TextView crewmember4ID;
    TextView crewmember5ID;
    TextView crewmember6ID;
    TextView crewmember7ID;
    TextView crewmember8ID;
    TextView crewmember9ID;
    TextView crewmember10ID;

    TextView crewmember1Name;
    TextView crewmember2Name;
    TextView crewmember3Name;
    TextView crewmember4Name;
    TextView crewmember5Name;
    TextView crewmember6Name;
    TextView crewmember7Name;
    TextView crewmember8Name;
    TextView crewmember9Name;
    TextView crewmember10Name;

    ImageView crewmember1Img;
    ImageView crewmember2Img;
    ImageView crewmember3Img;
    ImageView crewmember4Img;
    ImageView crewmember5Img;
    ImageView crewmember6Img;
    ImageView crewmember7Img;
    ImageView crewmember8Img;
    ImageView crewmember9Img;
    ImageView crewmember10Img;

    Bitmap crewmember1ImgBitmap;
    Bitmap crewmember2ImgBitmap;
    Bitmap crewmember3ImgBitmap;
    Bitmap crewmember4ImgBitmap;
    Bitmap crewmember5ImgBitmap;
    Bitmap crewmember6ImgBitmap;
    Bitmap crewmember7ImgBitmap;
    Bitmap crewmember8ImgBitmap;
    Bitmap crewmember9ImgBitmap;
    Bitmap crewmember10ImgBitmap;
    //endregion
    //endregion

    //region Generate ImageViews & TextViews
    ImageView poster;
    Bitmap poster_bitmap;
    ImageView backdrop;
    Bitmap backdrop_bitmap;

    TextView name;
    TextView release_date;
    TextView tagline;
    TextView overview;
    ImageView rating;

    TextView runtime;
    TextView language;
    TextView budget;
    TextView revenue;
    TextView voters;
    //endregion

    double lat;
    double longi;

    String location_postcode;

    String cinema_1_name; String cinema_1_location;
    String cinema_2_name; String cinema_2_location;
    String cinema_3_name; String cinema_3_location;
    String cinema_4_name; String cinema_4_location;
    String cinema_5_name; String cinema_5_location;
    String cinema_1_id;
    String cinema_2_id;
    String cinema_3_id;
    String cinema_4_id;
    String cinema_5_id;
    String cinema_1_distance;
    String cinema_2_distance;
    String cinema_3_distance;
    String cinema_4_distance;
    String cinema_5_distance;

    TextView cinema1name;
    TextView cinema2name;
    TextView cinema3name;
    TextView cinema4name;
    TextView cinema5name;
    TextView cinema1location;
    TextView cinema2location;
    TextView cinema3location;
    TextView cinema4location;
    TextView cinema5location;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details_ui);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        ID = extras.getString("movieID");
        inCinemas = extras.getString("inCinemas");

        System.out.println("This is movie " + ID);

        if (inCinemas == null)
        {
            inCinemas = "false";
        }

        else
        {
            // Acquire a reference to the system Location Manager
            LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

            // Use network provider to get last known location
            String locationProvider = LocationManager.GPS_PROVIDER;
            Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);

            // create a few new variable to get and store the lat/long coordinates of last known location


            // check if a last known location exists
            if (lastKnownLocation == null) {
                // if no last location is available set lat/long to zero
                lat = 0;  // lat of Lincoln is 53.228029;
                longi = 0; // longi of Lincoln is -0.546055;
            } else {
                // if last location exists then get/set the lat/long
                lat = lastKnownLocation.getLatitude();
                longi = lastKnownLocation.getLongitude();
            }

            // bind the lat long coordinates to the programmatically created TextView for displaying
            new get_cinema().execute();
        }

        new get_movie_data().execute();
        TextView tv;
        tv = (TextView) this.findViewById(R.id.movie_name);
        tv.setSelected(true);
    }

    public class get_cinema extends AsyncTask<String, String, String>
    {
        @Override
        protected void onPreExecute() {}

        @Override
        protected String doInBackground(String... arg0)
        {
            String url;
            httpConnect jParser;
            String json;
            JSONObject jsonObject;

            try
            {
                url = "https://api.cinelist.co.uk/search/cinemas/coordinates/" +  lat + "/" + longi;
                System.out.println(url);
                jParser = new httpConnect();
                json = jParser.getJSONFromUrl(url);
                jsonObject = new JSONObject(json);

                JSONObject cinemasJSON = new JSONObject(jParser.getJSONFromUrl(url));
                JSONArray cinemasARRAY = cinemasJSON.getJSONArray("cinemas");

                try
                {
                    //region Retrieve cinema data
                    location_postcode = jsonObject.getString("postcode");

                    List<String> cinemaNames = new ArrayList<String>(cinemasARRAY.length());
                    List<String> cinemaIDs = new ArrayList<String>(cinemasARRAY.length());
                    List<String> cinemaDistances = new ArrayList<String>(cinemasARRAY.length());

                    for (int i = 0; i < cinemasARRAY.length(); i++)
                    {
                        JSONObject ithObject = cinemasARRAY.getJSONObject(i);
                        if ((ithObject.has("name")) && (ithObject.has("id")) && (ithObject.has("distance")))
                        {
                            cinemaNames.add(ithObject.getString("name"));
                            cinemaIDs.add(ithObject.getString("id"));
                            cinemaDistances.add(ithObject.getString("distance"));
                            System.out.println("Cinema " + i + " located");
                        }

                        else
                        {
                            //do nothing
                            System.out.println("Warning! A cinema entry has been skipped");
                        }
                    }

                    int counter = 0;
                    for (String cinema : cinemaNames)
                    {
                        if(counter >= cinemasARRAY.length() || counter > 5)
                        {
                            break;
                        }

                        else
                        {
                            String[] cinemaParts;
                            switch(counter)
                            {
                                case 0:
                                    cinemaParts = cinema.split(", ", 2);
                                    cinema_1_name = cinemaParts[0];
                                    cinema_1_location = cinemaParts[1];
                                    break;
                                case 1:
                                    cinemaParts = cinema.split(", ", 2);
                                    cinema_2_name = cinemaParts[0];
                                    cinema_2_location = cinemaParts[1];
                                    break;
                                case 2:
                                    cinemaParts = cinema.split(", ", 2);
                                    cinema_3_name = cinemaParts[0];
                                    cinema_3_location = cinemaParts[1];
                                    break;
                                case 3:
                                    cinemaParts = cinema.split(", ", 2);
                                    cinema_4_name = cinemaParts[0];
                                    cinema_4_location = cinemaParts[1];
                                    break;
                                case 4:
                                    cinemaParts = cinema.split(", ", 2);
                                    cinema_5_name = cinemaParts[0];
                                    cinema_5_location = cinemaParts[1];
                                    break;
                                default:
                                    break;
                            }
                        }
                        counter++;
                    }

                    counter = 0;
                    for (String ID : cinemaIDs) {
                        if (counter >= cinemasARRAY.length())
                        {
                            break;
                        }

                        else
                        {
                            switch (counter)
                            {
                                case 0:
                                    cinema_1_id = ID;
                                    break;
                                case 1:
                                    cinema_2_id = ID;
                                    break;
                                case 2:
                                    cinema_3_id = ID;
                                    break;
                                case 3:
                                    cinema_4_id = ID;
                                    break;
                                case 4:
                                    cinema_5_id = ID;
                                    break;
                                default:
                                    break;
                            }
                        }
                        counter++;
                    }

                    counter = 0;
                    for (String distance : cinemaDistances) {
                        if (counter >= cinemasARRAY.length())
                        {
                            break;
                        }

                        else
                        {
                            switch (counter)
                            {
                                case 0:
                                    cinema_1_distance = distance;
                                    break;
                                case 1:
                                    cinema_2_distance = distance;
                                    break;
                                case 2:
                                    cinema_3_distance = distance;
                                    break;
                                case 3:
                                    cinema_4_distance = distance;
                                    break;
                                case 4:
                                    cinema_5_distance = distance;
                                    break;
                                default:
                                    break;
                            }
                        }
                        counter++;
                    }
                    //endregion
                }

                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            catch (Exception e)
            {

            }

            return null;
        }

        protected void onPostExecute(String strFromDoInBg)
        {
            try
            {
                cinema1name = (TextView) findViewById(R.id.cinema_1_name);
                cinema2name = (TextView) findViewById(R.id.cinema_2_name);
                cinema3name = (TextView) findViewById(R.id.cinema_3_name);
                cinema4name = (TextView) findViewById(R.id.cinema_4_name);
                cinema5name = (TextView) findViewById(R.id.cinema_5_name);
                cinema1location = (TextView) findViewById(R.id.cinema_1_location);
                cinema2location = (TextView) findViewById(R.id.cinema_2_location);
                cinema3location = (TextView) findViewById(R.id.cinema_3_location);
                cinema4location = (TextView) findViewById(R.id.cinema_4_location);
                cinema5location = (TextView) findViewById(R.id.cinema_5_location);
                View cardView;


                cinema1name.setText(cinema_1_name);
                cinema1location.setText(cinema_1_location + "\n" + cinema_1_distance + "m away");
                cinema2name.setText(cinema_2_name);
                cinema2location.setText(cinema_2_location + "\n" + cinema_2_distance + "m away");
                cinema3name.setText(cinema_3_name);
                cinema3location.setText(cinema_3_location + "\n" + cinema_3_distance + "m away");
                cinema4name.setText(cinema_4_name);
                cinema4location.setText(cinema_4_location + "\n" + cinema_4_distance + "m away");
                cinema5name.setText(cinema_5_name);
                cinema5location.setText(cinema_5_location + "\n" + cinema_5_distance + "m away");

                if(cinema_1_name != null)
                {
                    cardView = MovieDetailsUI.this.findViewById(R.id.cinemas_scroller);
                    cardView.setVisibility(View.VISIBLE);
                    cardView = MovieDetailsUI.this.findViewById(R.id.cinemas_title);
                    cardView.setVisibility(View.VISIBLE);
                    cardView = MovieDetailsUI.this.findViewById(R.id.cinema_card_1);
                    cardView.setVisibility(View.VISIBLE);
                    setCinemaImage(1);
                }

                if(cinema_2_name != null)
                {
                    cardView = MovieDetailsUI.this.findViewById(R.id.cinema_card_2);
                    cardView.setVisibility(View.VISIBLE);
                    setCinemaImage(2);
                }

                if(cinema_3_name != null)
                {
                    cardView = MovieDetailsUI.this.findViewById(R.id.cinema_card_3);
                    cardView.setVisibility(View.VISIBLE);
                    setCinemaImage(3);
                }

                if(cinema_4_name != null)
                {
                    cardView = MovieDetailsUI.this.findViewById(R.id.cinema_card_4);
                    cardView.setVisibility(View.VISIBLE);
                    setCinemaImage(4);
                }

                if(cinema_5_name != null)
                {
                    cardView = MovieDetailsUI.this.findViewById(R.id.cinema_card_5);
                    cardView.setVisibility(View.VISIBLE);
                    setCinemaImage(5);
                }

                if(cinema_1_name == null && cinema_2_name == null && cinema_3_name == null && cinema_4_name == null && cinema_5_name == null)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Something's wrong... There may not be any cinemas nearby or your location is not working.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    cardView = MovieDetailsUI.this.findViewById(R.id.cinemas_scroller);
                    cardView.setVisibility(View.GONE);
                }
            }

            catch (Exception e)
            {

            }

        }

        public void setCinemaImage(int cardSelector)
        {
            Boolean detector;
            ImageView cinemaImage;
            switch(cardSelector)
            {
                case 1:
                    cinemaImage = (ImageView) findViewById(R.id.cinema_1_image);
                    cinemaImage.setImageResource(R.drawable.default_cinema);

                    if((cinema_1_name.contains("Cineworld")) || (cinema_1_name.contains("cineworld")))
                    {
                        cinemaImage.setImageResource(R.drawable.cineworld_a);
                    }

                    if((cinema_1_name.contains("Curzon")) || (cinema_1_name.contains("curzon")))
                    {
                        cinemaImage.setImageResource(R.drawable.curzon_a);
                    }

                    if((cinema_1_name.contains("Empire")) || (cinema_1_name.contains("empire")))
                    {
                        cinemaImage.setImageResource(R.drawable.empire_a);
                    }

                    if((cinema_1_name.contains("Everyman")) || (cinema_1_name.contains("everyman")))
                    {
                        cinemaImage.setImageResource(R.drawable.everyman_a);
                    }

                    if((cinema_1_name.contains("Gaumont")) || (cinema_1_name.contains("gaumont")))
                    {
                        cinemaImage.setImageResource(R.drawable.gaumont_a);
                    }

                    if((cinema_1_name.contains("Moviehouse")) || (cinema_1_name.contains("moviehouse")) || (cinema_1_name.contains("Movie house")) || (cinema_1_name.contains("Movie House"))|| (cinema_1_name.contains("movie house")))
                    {
                        cinemaImage.setImageResource(R.drawable.moviehouse_a);
                    }

                    if((cinema_1_name.contains("Odeon")) || (cinema_1_name.contains("odeon")))
                    {
                        cinemaImage.setImageResource(R.drawable.odeon_a);
                    }

                    if((cinema_1_name.contains("Picturehouse")) || (cinema_1_name.contains("picturehouse")) || (cinema_1_name.contains("Picture house")) || (cinema_1_name.contains("Picture House")) || (cinema_1_name.contains("picture house")))
                    {
                        cinemaImage.setImageResource(R.drawable.picturehouse_a);
                    }

                    if((cinema_1_name.contains("Reel")) || (cinema_1_name.contains("reel")))
                    {
                        cinemaImage.setImageResource(R.drawable.reel_a);
                    }

                    if((cinema_1_name.contains("Regal")) || (cinema_1_name.contains("regal")))
                    {
                        cinemaImage.setImageResource(R.drawable.regal_a);
                    }

                    if((cinema_1_name.contains("Showcase")) || (cinema_1_name.contains("showcase")))
                    {
                        cinemaImage.setImageResource(R.drawable.showcase_a);
                    }

                    if((cinema_1_name.contains("Light")) || (cinema_1_name.contains("light")))
                    {
                        cinemaImage.setImageResource(R.drawable.thelight_a);
                    }

                    if((cinema_1_name.contains("Vue")) || (cinema_1_name.contains("vue")))
                    {
                        cinemaImage.setImageResource(R.drawable.vue_a);
                    }

                    break;
                case 2:
                    cinemaImage = (ImageView) findViewById(R.id.cinema_2_image);
                    cinemaImage.setImageResource(R.drawable.default_cinema);

                    if((cinema_2_name.contains("Cineworld")) || (cinema_2_name.contains("cineworld")))
                    {
                        cinemaImage.setImageResource(R.drawable.cineworld_a);
                    }

                    if((cinema_2_name.contains("Curzon")) || (cinema_2_name.contains("curzon")))
                    {
                        cinemaImage.setImageResource(R.drawable.curzon_a);
                    }

                    if((cinema_2_name.contains("Empire")) || (cinema_2_name.contains("empire")))
                    {
                        cinemaImage.setImageResource(R.drawable.empire_a);
                    }

                    if((cinema_2_name.contains("Everyman")) || (cinema_2_name.contains("everyman")))
                    {
                        cinemaImage.setImageResource(R.drawable.everyman_a);
                    }

                    if((cinema_2_name.contains("Gaumont")) || (cinema_2_name.contains("gaumont")))
                    {
                        cinemaImage.setImageResource(R.drawable.gaumont_a);
                    }

                    if((cinema_2_name.contains("Moviehouse")) || (cinema_2_name.contains("moviehouse")) || (cinema_2_name.contains("Movie house")) || (cinema_2_name.contains("Movie House"))|| (cinema_2_name.contains("movie house")))
                    {
                        cinemaImage.setImageResource(R.drawable.moviehouse_a);
                    }

                    if((cinema_2_name.contains("Odeon")) || (cinema_2_name.contains("odeon")))
                    {
                        cinemaImage.setImageResource(R.drawable.odeon_a);
                    }

                    if((cinema_2_name.contains("Picturehouse")) || (cinema_2_name.contains("picturehouse")) || (cinema_2_name.contains("Picture house")) || (cinema_2_name.contains("Picture House")) || (cinema_2_name.contains("picture house")))
                    {
                        cinemaImage.setImageResource(R.drawable.picturehouse_a);
                    }

                    if((cinema_2_name.contains("Reel")) || (cinema_2_name.contains("reel")))
                    {
                        cinemaImage.setImageResource(R.drawable.reel_a);
                    }

                    if((cinema_2_name.contains("Regal")) || (cinema_2_name.contains("regal")))
                    {
                        cinemaImage.setImageResource(R.drawable.regal_a);
                    }

                    if((cinema_2_name.contains("Showcase")) || (cinema_2_name.contains("showcase")))
                    {
                        cinemaImage.setImageResource(R.drawable.showcase_a);
                    }

                    if((cinema_2_name.contains("Light")) || (cinema_2_name.contains("light")))
                    {
                        cinemaImage.setImageResource(R.drawable.thelight_a);
                    }

                    if((cinema_2_name.contains("Vue")) || (cinema_2_name.contains("vue")))
                    {
                        cinemaImage.setImageResource(R.drawable.vue_a);
                    }

                    break;
                case 3:
                    cinemaImage = (ImageView) findViewById(R.id.cinema_3_image);
                    cinemaImage.setImageResource(R.drawable.default_cinema);

                    if((cinema_3_name.contains("Cineworld")) || (cinema_3_name.contains("cineworld")))
                    {
                        cinemaImage.setImageResource(R.drawable.cineworld_a);
                    }

                    if((cinema_3_name.contains("Curzon")) || (cinema_3_name.contains("curzon")))
                    {
                        cinemaImage.setImageResource(R.drawable.curzon_a);
                    }

                    if((cinema_3_name.contains("Empire")) || (cinema_3_name.contains("empire")))
                    {
                        cinemaImage.setImageResource(R.drawable.empire_a);
                    }

                    if((cinema_3_name.contains("Everyman")) || (cinema_3_name.contains("everyman")))
                    {
                        cinemaImage.setImageResource(R.drawable.everyman_a);
                    }

                    if((cinema_3_name.contains("Gaumont")) || (cinema_3_name.contains("gaumont")))
                    {
                        cinemaImage.setImageResource(R.drawable.gaumont_a);
                    }

                    if((cinema_3_name.contains("Moviehouse")) || (cinema_3_name.contains("moviehouse")) || (cinema_3_name.contains("Movie house")) || (cinema_3_name.contains("Movie House"))|| (cinema_3_name.contains("movie house")))
                    {
                        cinemaImage.setImageResource(R.drawable.moviehouse_a);
                    }

                    if((cinema_3_name.contains("Odeon")) || (cinema_3_name.contains("odeon")))
                    {
                        cinemaImage.setImageResource(R.drawable.odeon_a);
                    }

                    if((cinema_3_name.contains("Picturehouse")) || (cinema_3_name.contains("picturehouse")) || (cinema_3_name.contains("Picture house")) || (cinema_3_name.contains("Picture House")) || (cinema_3_name.contains("picture house")))
                    {
                        cinemaImage.setImageResource(R.drawable.picturehouse_a);
                    }

                    if((cinema_3_name.contains("Reel")) || (cinema_3_name.contains("reel")))
                    {
                        cinemaImage.setImageResource(R.drawable.reel_a);
                    }

                    if((cinema_3_name.contains("Regal")) || (cinema_3_name.contains("regal")))
                    {
                        cinemaImage.setImageResource(R.drawable.regal_a);
                    }

                    if((cinema_3_name.contains("Showcase")) || (cinema_3_name.contains("showcase")))
                    {
                        cinemaImage.setImageResource(R.drawable.showcase_a);
                    }

                    if((cinema_3_name.contains("Light")) || (cinema_3_name.contains("light")))
                    {
                        cinemaImage.setImageResource(R.drawable.thelight_a);
                    }

                    if((cinema_3_name.contains("Vue")) || (cinema_3_name.contains("vue")))
                    {
                        cinemaImage.setImageResource(R.drawable.vue_a);
                    }

                    break;
                case 4:
                    cinemaImage = (ImageView) findViewById(R.id.cinema_4_image);
                    cinemaImage.setImageResource(R.drawable.default_cinema);

                    if((cinema_4_name.contains("Cineworld")) || (cinema_4_name.contains("cineworld")))
                    {
                        cinemaImage.setImageResource(R.drawable.cineworld_a);
                    }

                    if((cinema_4_name.contains("Curzon")) || (cinema_4_name.contains("curzon")))
                    {
                        cinemaImage.setImageResource(R.drawable.curzon_a);
                    }

                    if((cinema_4_name.contains("Empire")) || (cinema_4_name.contains("empire")))
                    {
                        cinemaImage.setImageResource(R.drawable.empire_a);
                    }

                    if((cinema_4_name.contains("Everyman")) || (cinema_4_name.contains("everyman")))
                    {
                        cinemaImage.setImageResource(R.drawable.everyman_a);
                    }

                    if((cinema_4_name.contains("Gaumont")) || (cinema_4_name.contains("gaumont")))
                    {
                        cinemaImage.setImageResource(R.drawable.gaumont_a);
                    }

                    if((cinema_4_name.contains("Moviehouse")) || (cinema_4_name.contains("moviehouse")) || (cinema_4_name.contains("Movie house")) || (cinema_4_name.contains("Movie House"))|| (cinema_4_name.contains("movie house")))
                    {
                        cinemaImage.setImageResource(R.drawable.moviehouse_a);
                    }

                    if((cinema_4_name.contains("Odeon")) || (cinema_4_name.contains("odeon")))
                    {
                        cinemaImage.setImageResource(R.drawable.odeon_a);
                    }

                    if((cinema_4_name.contains("Picturehouse")) || (cinema_4_name.contains("picturehouse")) || (cinema_4_name.contains("Picture house")) || (cinema_4_name.contains("Picture House")) || (cinema_4_name.contains("picture house")))
                    {
                        cinemaImage.setImageResource(R.drawable.picturehouse_a);
                    }

                    if((cinema_4_name.contains("Reel")) || (cinema_4_name.contains("reel")))
                    {
                        cinemaImage.setImageResource(R.drawable.reel_a);
                    }

                    if((cinema_4_name.contains("Regal")) || (cinema_4_name.contains("regal")))
                    {
                        cinemaImage.setImageResource(R.drawable.regal_a);
                    }

                    if((cinema_4_name.contains("Showcase")) || (cinema_4_name.contains("showcase")))
                    {
                        cinemaImage.setImageResource(R.drawable.showcase_a);
                    }

                    if((cinema_4_name.contains("Light")) || (cinema_4_name.contains("light")))
                    {
                        cinemaImage.setImageResource(R.drawable.thelight_a);
                    }

                    if((cinema_4_name.contains("Vue")) || (cinema_4_name.contains("vue")))
                    {
                        cinemaImage.setImageResource(R.drawable.vue_a);
                    }

                    break;
                case 5:
                    cinemaImage = (ImageView) findViewById(R.id.cinema_5_image);
                    cinemaImage.setImageResource(R.drawable.default_cinema);

                    if((cinema_5_name.contains("Cineworld")) || (cinema_5_name.contains("cineworld")))
                    {
                        cinemaImage.setImageResource(R.drawable.cineworld_a);
                    }

                    if((cinema_5_name.contains("Curzon")) || (cinema_5_name.contains("curzon")))
                    {
                        cinemaImage.setImageResource(R.drawable.curzon_a);
                    }

                    if((cinema_5_name.contains("Empire")) || (cinema_5_name.contains("empire")))
                    {
                        cinemaImage.setImageResource(R.drawable.empire_a);
                    }

                    if((cinema_5_name.contains("Everyman")) || (cinema_5_name.contains("everyman")))
                    {
                        cinemaImage.setImageResource(R.drawable.everyman_a);
                    }

                    if((cinema_5_name.contains("Gaumont")) || (cinema_5_name.contains("gaumont")))
                    {
                        cinemaImage.setImageResource(R.drawable.gaumont_a);
                    }

                    if((cinema_5_name.contains("Moviehouse")) || (cinema_5_name.contains("moviehouse")) || (cinema_5_name.contains("Movie house")) || (cinema_5_name.contains("Movie House"))|| (cinema_5_name.contains("movie house")))
                    {
                        cinemaImage.setImageResource(R.drawable.moviehouse_a);
                    }

                    if((cinema_5_name.contains("Odeon")) || (cinema_5_name.contains("odeon")))
                    {
                        cinemaImage.setImageResource(R.drawable.odeon_a);
                    }

                    if((cinema_5_name.contains("Picturehouse")) || (cinema_5_name.contains("picturehouse")) || (cinema_5_name.contains("Picture house")) || (cinema_5_name.contains("Picture House")) || (cinema_5_name.contains("picture house")))
                    {
                        cinemaImage.setImageResource(R.drawable.picturehouse_a);
                    }

                    if((cinema_5_name.contains("Reel")) || (cinema_5_name.contains("reel")))
                    {
                        cinemaImage.setImageResource(R.drawable.reel_a);
                    }

                    if((cinema_5_name.contains("Regal")) || (cinema_5_name.contains("regal")))
                    {
                        cinemaImage.setImageResource(R.drawable.regal_a);
                    }

                    if((cinema_5_name.contains("Showcase")) || (cinema_5_name.contains("showcase")))
                    {
                        cinemaImage.setImageResource(R.drawable.showcase_a);
                    }

                    if((cinema_5_name.contains("Light")) || (cinema_5_name.contains("light")))
                    {
                        cinemaImage.setImageResource(R.drawable.thelight_a);
                    }

                    if((cinema_5_name.contains("Vue")) || (cinema_5_name.contains("vue")))
                    {
                        cinemaImage.setImageResource(R.drawable.vue_a);
                    }

                    break;
            }
        }
    }

    public class get_movie_data extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
        }

        @Override
        protected String doInBackground(String... arg0)
        {
            String url;
            httpConnect jParser;
            String json;
            JSONObject jsonObject;

            try
            {
                //region If movie has already been visited
                StringBuilder fileReader = new StringBuilder("");
                try
                {
                    // open location file from private storage area
                    FileInputStream fIn = openFileInput("Movie-" + ID);
                    InputStreamReader isr = new InputStreamReader( fIn ) ;
                    BufferedReader buffreader = new BufferedReader( isr ) ;
                    // loop to read each line, each line has a long and lat value
                    String readString = buffreader.readLine ( ) ;

                    while ( readString != null )
                    {
                        fileReader.append(readString);
                        readString = buffreader.readLine ( ) ;
                    }

                    String[] movieData = fileReader.toString().split("##");
                    System.out.println(Arrays.toString(movieData));
                    movie_title = movieData[0];
                    movie_release_date = movieData[1];
                    movie_tagline = movieData[2];
                    movie_overview = movieData[3];
                    movie_rating = movieData[4];
                    poster_path = movieData[5];
                    backdrop_path = movieData[6];
                    movie_runtime = movieData[7];
                    movie_language = movieData[8];
                    movie_budget = movieData[9];
                    movie_revenue = movieData[10];
                    movie_voters = movieData[11];

                    //region Decode Poster and Backdrop & get ready to apply them
                    poster = (ImageView) findViewById(R.id.movie_poster);
                    poster_bitmap = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                    backdrop = (ImageView) findViewById(R.id.movie_backdrop);
                    backdrop_bitmap = BitmapFactory.decodeStream((InputStream) new URL(backdrop_path).getContent());
                    //endregion
                    //region locates all Movie Data elements and gets ready to apply them
                    name = (TextView) findViewById(R.id.movie_name);
                    release_date = (TextView) findViewById(R.id.movie_release_date);
                    tagline = (TextView) findViewById(R.id.movie_tagline);
                    overview = (TextView) findViewById(R.id.movie_overview);
                    rating = (ImageView) findViewById(R.id.movie_rating);
                    runtime = (TextView) findViewById(R.id.movie_runtime);
                    language = (TextView) findViewById(R.id.movie_language);
//                    budget = (TextView) findViewById(R.id.movie_budget);
//                    revenue = (TextView) findViewById(R.id.movie_revenue);
//                    voters = (TextView) findViewById(R.id.movie_voters);
                    //endregion

                    System.out.println("You're seeing data that was saved to the phone");
                    isr.close ( ) ;
                }
                //endregion

                //region If not, get data for movie
                catch ( IOException ioe )
                {
                    url = "https://api.themoviedb.org/3/movie/" + ID + apiKey + "&language=en-US";
                    jParser = new httpConnect();
                    json = jParser.getJSONFromUrl(url);
                    jsonObject = new JSONObject(json);

                    try
                    {
                        String importantInformationTest;
                        //region Check and get Poster
                        importantInformationTest = jsonObject.getString("poster_path");
                        if (importantInformationTest == "null") {
                            poster_path = "https://www.themoviedb.org/assets/e2dd052f141e33392eb749aab2414ec0/images/no-poster-w300_and_h450_bestv2-v2.png";
                        } else {
                            poster_path = "https://image.tmdb.org/t/p/w300_and_h450_bestv2" + importantInformationTest;
                        }
                        //endregion
                        //region Check and get Backdrop
                        importantInformationTest = jsonObject.getString("backdrop_path");
                        if (importantInformationTest == "null") {
                            backdrop_path = "https://www.themoviedb.org/assets/e2dd052f141e33392eb749aab2414ec0/images/no-poster-w300_and_h450_bestv2-v2.png";
                        } else {
                            backdrop_path = "https://image.tmdb.org/t/p/w500_and_h281_bestv2" + importantInformationTest;
                        }
                        //endregion

                        //region Retrieve movie data
                        movie_title = jsonObject.getString("title");
                        movie_release_date = jsonObject.getString("release_date");
                        movie_release_date = "(" + (movie_release_date.substring(0, movie_release_date.length() - 6)) + ")";
                        movie_tagline = jsonObject.getString("tagline");
                        movie_overview = jsonObject.getString("overview");
                        movie_rating = jsonObject.getString("vote_average");
                        movie_runtime = jsonObject.getString("runtime") + "m";
                        movie_language = jsonObject.getString("original_language");
                        movie_budget = jsonObject.getString("budget");
                        movie_revenue = jsonObject.getString("revenue");
                        movie_voters = jsonObject.getString("vote_count");
                        //endregion
                    }

                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                    try
                    {
                        //region Decode Poster and Backdrop & get ready to apply them
                        poster = (ImageView) findViewById(R.id.movie_poster);
                        poster_bitmap = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                        backdrop = (ImageView) findViewById(R.id.movie_backdrop);
                        backdrop_bitmap = BitmapFactory.decodeStream((InputStream) new URL(backdrop_path).getContent());
                        //endregion
                        //region locates all Movie Data elements and gets ready to apply them
                        name = (TextView) findViewById(R.id.movie_name);
                        release_date = (TextView) findViewById(R.id.movie_release_date);
                        tagline = (TextView) findViewById(R.id.movie_tagline);
                        overview = (TextView) findViewById(R.id.movie_overview);
                        rating = (ImageView) findViewById(R.id.movie_rating);
                        runtime = (TextView) findViewById(R.id.movie_runtime);
                        language = (TextView) findViewById(R.id.movie_language);
//                        budget = (TextView) findViewById(R.id.movie_budget);
//                        revenue = (TextView) findViewById(R.id.movie_revenue);
//                        voters = (TextView) findViewById(R.id.movie_voters);
                        //endregion
                    }

                    catch (MalformedURLException e)
                    {
                        e.printStackTrace();
                    }

                }
                //endregion


                url = "https://api.themoviedb.org/3/movie/" + ID + "/credits" + apiKey;
                jParser = new httpConnect();
                JSONObject creditsRetrieval = new JSONObject(jParser.getJSONFromUrl(url));
                JSONArray castArray = creditsRetrieval.getJSONArray("cast");
                List<String> castCharacters = new ArrayList<String>(castArray.length());
                List<String> castIDs = new ArrayList<String>(castArray.length());
                List<String> castNames = new ArrayList<String>(castArray.length());
                List<String> castProfiles = new ArrayList<String>(castArray.length());
                JSONArray crewArray = creditsRetrieval.getJSONArray("crew");
                List<String> crewIDs = new ArrayList<String>(castArray.length());
                List<String> crewJobs = new ArrayList<String>(castArray.length());
                List<String> crewNames = new ArrayList<String>(castArray.length());
                List<String> crewProfiles = new ArrayList<String>(castArray.length());
                Integer limit = 10;
                Integer counter = 0;

                //region Retrieve cast list
                for (int i = 0; i < castArray.length(); i++) {
                    if (counter > limit) {
                        counter = 1;
                        break;
                    }

                    JSONObject ithObject = castArray.getJSONObject(i);

                    try {

                        if (ithObject.has("character") && (ithObject.has("id")) && (ithObject.has("name")) && (ithObject.has("profile_path"))) {
                            castCharacters.add(ithObject.getString("character"));
                            castIDs.add(ithObject.getString("id"));
                            castNames.add(ithObject.getString("name"));
                            castProfiles.add(ithObject.getString("profile_path"));
                        } else {
                            castCharacters.add("Mystery");
                            castIDs.add("Mystery");
                            castNames.add("Mystery");
                            castProfiles.add("null");
                        }

                        counter++;
                    } catch (Exception dataError) {
                        System.out.println("Error! Something went wrong here!");
                    }

                }

                for (String castProfile : castProfiles) {
                    if (counter > limit) {
                        counter = 1;
                        break;
                    }

                    if (castProfile == "null") {
                        castmember_img = "https://www.themoviedb.org/assets/e2dd052f141e33392eb749aab2414ec0/images/no-poster-w300_and_h450_bestv2-v2.png";
                    } else {
                        castmember_img = "https://image.tmdb.org/t/p/w132_and_h132_bestv2" + castProfile;
                    }


                    switch (counter) {
                        case 1:
                            castmember1Img = (ImageView) findViewById(R.id.cast_actor_1_img);
                            castmember1ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(castmember_img).getContent());
                            break;
                        case 2:
                            castmember2Img = (ImageView) findViewById(R.id.cast_actor_2_img);
                            castmember2ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(castmember_img).getContent());
                            break;
                        case 3:
                            castmember3Img = (ImageView) findViewById(R.id.cast_actor_3_img);
                            castmember3ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(castmember_img).getContent());
                            break;
                        case 4:
                            castmember4Img = (ImageView) findViewById(R.id.cast_actor_4_img);
                            castmember4ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(castmember_img).getContent());
                            break;
                        case 5:
                            castmember5Img = (ImageView) findViewById(R.id.cast_actor_5_img);
                            castmember5ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(castmember_img).getContent());
                            break;
                        case 6:
                            castmember6Img = (ImageView) findViewById(R.id.cast_actor_6_img);
                            castmember6ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(castmember_img).getContent());
                            break;
                        case 7:
                            castmember7Img = (ImageView) findViewById(R.id.cast_actor_7_img);
                            castmember7ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(castmember_img).getContent());
                            break;
                        case 8:
                            castmember8Img = (ImageView) findViewById(R.id.cast_actor_8_img);
                            castmember8ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(castmember_img).getContent());
                            break;
                        case 9:
                            castmember9Img = (ImageView) findViewById(R.id.cast_actor_9_img);
                            castmember9ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(castmember_img).getContent());
                            break;
                        case 10:
                            castmember10Img = (ImageView) findViewById(R.id.cast_actor_10_img);
                            castmember10ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(castmember_img).getContent());
                            break;
                    }

                    counter++;
                }

                for (String castName : castNames) {
                    if (counter > limit) {
                        counter = 1;
                        break;
                    }

                    if (castName == "null") {
                        castName = "???";
                    }

                    switch (counter) {
                        case 1:
                            castmember1Name = (TextView) findViewById(R.id.cast_actor_1_name);
                            castmember_1_name = castName;
                            break;
                        case 2:
                            castmember2Name = (TextView) findViewById(R.id.cast_actor_2_name);
                            castmember_2_name = castName;
                            break;
                        case 3:
                            castmember3Name = (TextView) findViewById(R.id.cast_actor_3_name);
                            castmember_3_name = castName;
                            break;
                        case 4:
                            castmember4Name = (TextView) findViewById(R.id.cast_actor_4_name);
                            castmember_4_name = castName;
                            break;
                        case 5:
                            castmember5Name = (TextView) findViewById(R.id.cast_actor_5_name);
                            castmember_5_name = castName;
                            break;
                        case 6:
                            castmember6Name = (TextView) findViewById(R.id.cast_actor_6_name);
                            castmember_6_name = castName;
                            break;
                        case 7:
                            castmember7Name = (TextView) findViewById(R.id.cast_actor_7_name);
                            castmember_7_name = castName;
                            break;
                        case 8:
                            castmember8Name = (TextView) findViewById(R.id.cast_actor_8_name);
                            castmember_8_name = castName;
                            break;
                        case 9:
                            castmember9Name = (TextView) findViewById(R.id.cast_actor_9_name);
                            castmember_9_name = castName;
                            break;
                        case 10:
                            castmember10Name = (TextView) findViewById(R.id.cast_actor_10_name);
                            castmember_10_name = castName;
                            break;
                    }
                    counter++;
                }

                for (String castCharacter : castCharacters) {
                    if (counter > limit) {
                        counter = 1;
                        break;
                    }

                    if (castCharacter == "null") {
                        castCharacter = "???";
                    }

                    switch (counter) {
                        case 1:
                            castmember1Character = (TextView) findViewById(R.id.cast_actor_1_character);
                            castmember_1_character = castCharacter;
                            break;
                        case 2:
                            castmember2Character = (TextView) findViewById(R.id.cast_actor_2_character);
                            castmember_2_character = castCharacter;
                            break;
                        case 3:
                            castmember3Character = (TextView) findViewById(R.id.cast_actor_3_character);
                            castmember_3_character = castCharacter;
                            break;
                        case 4:
                            castmember4Character = (TextView) findViewById(R.id.cast_actor_4_character);
                            castmember_4_character = castCharacter;
                            break;
                        case 5:
                            castmember5Character = (TextView) findViewById(R.id.cast_actor_5_character);
                            castmember_5_character = castCharacter;
                            break;
                        case 6:
                            castmember6Character = (TextView) findViewById(R.id.cast_actor_6_character);
                            castmember_6_character = castCharacter;
                            break;
                        case 7:
                            castmember7Character = (TextView) findViewById(R.id.cast_actor_7_character);
                            castmember_7_character = castCharacter;
                            break;
                        case 8:
                            castmember8Character = (TextView) findViewById(R.id.cast_actor_8_character);
                            castmember_8_character = castCharacter;
                            break;
                        case 9:
                            castmember9Character = (TextView) findViewById(R.id.cast_actor_9_character);
                            castmember_9_character = castCharacter;
                            break;
                        case 10:
                            castmember10Character = (TextView) findViewById(R.id.cast_actor_10_character);
                            castmember_10_character = castCharacter;
                            break;
                    }
                    counter++;
                }

                for (String castID : castIDs) {
                    if (counter > limit) {
                        counter = 1;
                        break;
                    }

                    if (castID == "null") {
                        castID = "???";
                    }

                    switch (counter) {
                        case 1:
                            castmember_1_id = castID;
                            break;
                        case 2:
                            castmember_2_id = castID;
                            break;
                        case 3:
                            castmember_3_id = castID;
                            break;
                        case 4:
                            castmember_4_id = castID;
                            break;
                        case 5:
                            castmember_5_id = castID;
                            break;
                        case 6:
                            castmember_6_id = castID;
                            break;
                        case 7:
                            castmember_7_id = castID;
                            break;
                        case 8:
                            castmember_8_id = castID;
                            break;
                        case 9:
                            castmember_9_id = castID;
                            break;
                        case 10:
                            castmember_10_id = castID;
                            break;
                    }
                    counter++;
                }
                //endregion

                //region Retrieve crew list
                counter = 0;
                for (int i = 0; i < crewArray.length(); i++) {
                    if (counter > limit) {
                        counter = 1;
                        break;
                    }

                    try {
                        JSONObject ithObject = crewArray.getJSONObject(i);
                        if (ithObject.has("job") && (ithObject.has("id")) && (ithObject.has("name")) && (ithObject.has("profile_path"))) {
                            crewJobs.add(ithObject.getString("job"));
                            crewIDs.add(ithObject.getString("id"));
                            crewNames.add(ithObject.getString("name"));
                            crewProfiles.add(ithObject.getString("profile_path"));
                        } else {
                            crewJobs.add("null");
                            crewIDs.add("null");
                            crewNames.add("null");
                            crewProfiles.add("null");
                        }

                        counter++;
                    } catch (Exception dataError) {
                        System.out.println("Error! Something went wrong here!");
                    }

                }

                counter = 0;
                for (String crewProfile : crewProfiles) {
                    if (counter > limit) {
                        counter = 1;
                        break;
                    }

                    if (crewProfile == "null") {
                        crewmember_img = "https://www.themoviedb.org/assets/e2dd052f141e33392eb749aab2414ec0/images/no-poster-w300_and_h450_bestv2-v2.png";
                    } else {
                        crewmember_img = "https://image.tmdb.org/t/p/w132_and_h132_bestv2" + crewProfile;
                    }


                    switch (counter) {
                        case 1:
                            crewmember1Img = (ImageView) findViewById(R.id.crew_1_img);
                            crewmember1ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(crewmember_img).getContent());
                            break;
                        case 2:
                            crewmember2Img = (ImageView) findViewById(R.id.crew_2_img);
                            crewmember2ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(crewmember_img).getContent());
                            break;
                        case 3:
                            crewmember3Img = (ImageView) findViewById(R.id.crew_3_img);
                            crewmember3ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(crewmember_img).getContent());
                            break;
                        case 4:
                            crewmember4Img = (ImageView) findViewById(R.id.crew_4_img);
                            crewmember4ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(crewmember_img).getContent());
                            break;
                        case 5:
                            crewmember5Img = (ImageView) findViewById(R.id.crew_5_img);
                            crewmember5ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(crewmember_img).getContent());
                            break;
                        case 6:
                            crewmember6Img = (ImageView) findViewById(R.id.crew_6_img);
                            crewmember6ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(crewmember_img).getContent());
                            break;
                        case 7:
                            crewmember7Img = (ImageView) findViewById(R.id.crew_7_img);
                            crewmember7ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(crewmember_img).getContent());
                            break;
                        case 8:
                            crewmember8Img = (ImageView) findViewById(R.id.crew_8_img);
                            crewmember8ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(crewmember_img).getContent());
                            break;
                        case 9:
                            crewmember9Img = (ImageView) findViewById(R.id.crew_9_img);
                            crewmember9ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(crewmember_img).getContent());
                            break;
                        case 10:
                            crewmember10Img = (ImageView) findViewById(R.id.crew_10_img);
                            crewmember10ImgBitmap = BitmapFactory.decodeStream((InputStream) new URL(crewmember_img).getContent());
                            break;
                    }

                    counter++;
                }

                counter = 0;
                for (String crewName : crewNames) {
                    if (counter > limit) {
                        counter = 1;
                        break;
                    }

                    if (crewName == "null") {
                        crewName = "???";
                    }

                    switch (counter) {
                        case 1:
                            crewmember1Name = (TextView) findViewById(R.id.crew_1_name);
                            crewmember_1_name = crewName;
                            break;
                        case 2:
                            crewmember2Name = (TextView) findViewById(R.id.crew_2_name);
                            crewmember_2_name = crewName;
                            break;
                        case 3:
                            crewmember3Name = (TextView) findViewById(R.id.crew_3_name);
                            crewmember_3_name = crewName;
                            break;
                        case 4:
                            crewmember4Name = (TextView) findViewById(R.id.crew_4_name);
                            crewmember_4_name = crewName;
                            break;
                        case 5:
                            crewmember5Name = (TextView) findViewById(R.id.crew_5_name);
                            crewmember_5_name = crewName;
                            break;
                        case 6:
                            crewmember6Name = (TextView) findViewById(R.id.crew_6_name);
                            crewmember_6_name = crewName;
                            break;
                        case 7:
                            crewmember7Name = (TextView) findViewById(R.id.crew_7_name);
                            crewmember_7_name = crewName;
                            break;
                        case 8:
                            crewmember8Name = (TextView) findViewById(R.id.crew_8_name);
                            crewmember_8_name = crewName;
                            break;
                        case 9:
                            crewmember9Name = (TextView) findViewById(R.id.crew_9_name);
                            crewmember_9_name = crewName;
                            break;
                        case 10:
                            crewmember10Name = (TextView) findViewById(R.id.crew_10_name);
                            crewmember_10_name = crewName;
                            break;
                    }
                    counter++;
                }

                counter = 0;
                for (String crewJob : crewJobs) {
                    if (counter > limit) {
                        counter = 1;
                        break;
                    }

                    if (crewJob == "null") {
                        crewJob = "???";
                    }

                    switch (counter) {
                        case 1:
                            crewmember1Job = (TextView) findViewById(R.id.crew_1_job);
                            crewmember_1_job = crewJob;
                            break;
                        case 2:
                            crewmember2Job = (TextView) findViewById(R.id.crew_2_job);
                            crewmember_2_job = crewJob;
                            break;
                        case 3:
                            crewmember3Job = (TextView) findViewById(R.id.crew_3_job);
                            crewmember_3_job = crewJob;
                            break;
                        case 4:
                            crewmember4Job = (TextView) findViewById(R.id.crew_4_job);
                            crewmember_4_job = crewJob;
                            break;
                        case 5:
                            crewmember5Job = (TextView) findViewById(R.id.crew_5_job);
                            crewmember_5_job = crewJob;
                            break;
                        case 6:
                            crewmember6Job = (TextView) findViewById(R.id.crew_6_job);
                            crewmember_6_job = crewJob;
                            break;
                        case 7:
                            crewmember7Job = (TextView) findViewById(R.id.crew_7_job);
                            crewmember_7_job = crewJob;
                            break;
                        case 8:
                            crewmember8Job = (TextView) findViewById(R.id.crew_8_job);
                            crewmember_8_job = crewJob;
                            break;
                        case 9:
                            crewmember9Job = (TextView) findViewById(R.id.crew_9_job);
                            crewmember_9_job = crewJob;
                            break;
                        case 10:
                            crewmember10Job = (TextView) findViewById(R.id.crew_10_job);
                            crewmember_10_job = crewJob;
                            break;
                    }
                    counter++;
                }

                counter = 0;
                for (String crewID : crewIDs) {
                    if (counter > limit) {
                        counter = 1;
                        break;
                    }

                    if (crewID == "null") {
                        crewID = "???";
                    }

                    switch (counter) {
                        case 1:
                            crewmember_1_id = crewID;
                            break;
                        case 2:
                            crewmember_2_id = crewID;
                            break;
                        case 3:
                            crewmember_3_id = crewID;
                            break;
                        case 4:
                            crewmember_4_id = crewID;
                            break;
                        case 5:
                            crewmember_5_id = crewID;
                            break;
                        case 6:
                            crewmember_6_id = crewID;
                            break;
                        case 7:
                            crewmember_7_id = crewID;
                            break;
                        case 8:
                            crewmember_8_id = crewID;
                            break;
                        case 9:
                            crewmember_9_id = crewID;
                            break;
                        case 10:
                            crewmember_10_id = crewID;
                            break;
                    }
                    counter++;
                }
                //endregion

            }

            catch (Exception e)
            {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String strFromDoInBg)
        {
            //region Apply Poster & Backdrop
            poster.setImageBitmap(poster_bitmap);
            backdrop.setImageBitmap(backdrop_bitmap);
            //endregion
            //region Apply movie data
            name.setText(movie_title);
            release_date.setText(movie_release_date);

            if(TextUtils.isEmpty(movie_tagline))
            {
                missingTagline = MovieDetailsUI.this.findViewById(R.id.movie_tagline);
                missingTagline.setVisibility(View.GONE);
                missingTagline = MovieDetailsUI.this.findViewById(R.id.movie_overview);
                missingTagline.setPadding(0, 100, 0, 0);
            }

            else
            {
                tagline.setText("'\'" + movie_tagline + "'\'");
            }


            overview.setText(movie_overview);
            calculateRating();
            runtime.setText(movie_runtime);
            generateLanguageLabel();
            //calculateBudgetRevenue();
            //voters.setText(movie_voters);
            //endregion

            //region Apply castmember details

            try
            {
                castmember1Img.setImageBitmap(castmember1ImgBitmap);
                castmember1Name.setText(castmember_1_name);
                castmember1Character.setText(castmember_1_character);
            }

            catch (Exception e)
            {
                CardView ErrorCardView = (CardView) findViewById(R.id.cast_actor_1);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_1_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_1_character);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;

            }

            try {
                castmember2Img.setImageBitmap(castmember2ImgBitmap);
                castmember2Name.setText(castmember_2_name);
                castmember2Character.setText(castmember_2_character);
            }

            catch (Exception e)
            {
                CardView ErrorCardView = (CardView) findViewById(R.id.cast_actor_2);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_2_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_2_character);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }

            try {
                castmember3Img.setImageBitmap(castmember3ImgBitmap);
                castmember3Name.setText(castmember_3_name);
                castmember3Character.setText(castmember_3_character);
            }

            catch (Exception e)
            {
                CardView ErrorCardView = (CardView) findViewById(R.id.cast_actor_3);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_3_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_3_character);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }

            try {
                castmember4Img.setImageBitmap(castmember4ImgBitmap);
                castmember4Name.setText(castmember_4_name);
                castmember4Character.setText(castmember_4_character);
            }

            catch (Exception e)
            {
                CardView ErrorCardView = (CardView) findViewById(R.id.cast_actor_4);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_4_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_4_character);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }

            try {
                castmember5Img.setImageBitmap(castmember5ImgBitmap);
                castmember5Name.setText(castmember_5_name);
                castmember5Character.setText(castmember_5_character);
            }

            catch (Exception e)
            {
                CardView ErrorCardView = (CardView) findViewById(R.id.cast_actor_5);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_5_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_5_character);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }

            try {
                castmember6Img.setImageBitmap(castmember6ImgBitmap);
                castmember6Name.setText(castmember_6_name);
                castmember6Character.setText(castmember_6_character);
            }

            catch (Exception e)
            {
                CardView ErrorCardView = (CardView) findViewById(R.id.cast_actor_6);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_6_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_6_character);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }

            try {
                castmember7Img.setImageBitmap(castmember7ImgBitmap);
                castmember7Name.setText(castmember_7_name);
                castmember7Character.setText(castmember_7_character);
            }

            catch (Exception e)
            {
                CardView ErrorCardView = (CardView) findViewById(R.id.cast_actor_7);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_7_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_7_character);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }

            try {
                castmember8Img.setImageBitmap(castmember8ImgBitmap);
                castmember8Name.setText(castmember_8_name);
                castmember8Character.setText(castmember_8_character);
            }

            catch (Exception e)
            {
                CardView ErrorCardView = (CardView) findViewById(R.id.cast_actor_8);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_8_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_8_character);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }

            try {
                castmember9Img.setImageBitmap(castmember9ImgBitmap);
                castmember9Name.setText(castmember_9_name);
                castmember9Character.setText(castmember_9_character);
            }

            catch (Exception e)
            {
                CardView ErrorCardView = (CardView) findViewById(R.id.cast_actor_9);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_9_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_9_character);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }

            try {
                castmember10Img.setImageBitmap(castmember10ImgBitmap);
                castmember10Name.setText(castmember_10_name);
                castmember10Character.setText(castmember_10_character);
            }

            catch (Exception e)
            {
                CardView ErrorCardView = (CardView) findViewById(R.id.cast_actor_10);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_10_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_actor_10_character);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }

            //region Remove section if no values
            if(CastCrew_Error_No == 100)
            {
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_title);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.cast_view);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_title);
                ErrorView.setPadding(0, 300, 0, 0);
                CastCrew_Error_No = 0;
            }

            else
            {
                CastCrew_Error_No = 0;
            }
            //endregion

            //endregion

            //region Apply crewmember details
            //region Crewmember 1
            try {
                crewmember1Img.setImageBitmap(crewmember1ImgBitmap);
                crewmember1Name.setText(crewmember_1_name);
                crewmember1Job.setText(crewmember_1_job);
            } catch (Exception e) {
                CardView ErrorCardView = (CardView) findViewById(R.id.crew_1);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_1_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_1_job);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }
            //endregion
            //region Crewmember 2
            try {
                crewmember2Img.setImageBitmap(crewmember2ImgBitmap);
                crewmember2Name.setText(crewmember_2_name);
                crewmember2Job.setText(crewmember_2_job);
            } catch (Exception e) {
                CardView ErrorCardView = (CardView) findViewById(R.id.crew_2);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_2_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_2_job);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }
            //endregion
            //region Crewmember 3
            try {
                crewmember3Img.setImageBitmap(crewmember3ImgBitmap);
                crewmember3Name.setText(crewmember_3_name);
                crewmember3Job.setText(crewmember_3_job);
            } catch (Exception e) {
                CardView ErrorCardView = (CardView) findViewById(R.id.crew_3);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_3_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_3_job);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }
            //endregion
            //region Crewmember 4
            try {
                crewmember4Img.setImageBitmap(crewmember4ImgBitmap);
                crewmember4Name.setText(crewmember_4_name);
                crewmember4Job.setText(crewmember_4_job);
            } catch (Exception e) {
                CardView ErrorCardView = (CardView) findViewById(R.id.crew_4);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_4_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_4_job);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }
            //endregion
            //region Crewmember 5
            try {
                crewmember5Img.setImageBitmap(crewmember5ImgBitmap);
                crewmember5Name.setText(crewmember_5_name);
                crewmember5Job.setText(crewmember_5_job);
            } catch (Exception e) {
                CardView ErrorCardView = (CardView) findViewById(R.id.crew_5);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_5_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_5_job);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }
            //endregion
            //region Crewmember 6
            try {
                crewmember6Img.setImageBitmap(crewmember6ImgBitmap);
                crewmember6Name.setText(crewmember_6_name);
                crewmember6Job.setText(crewmember_6_job);
            } catch (Exception e) {
                CardView ErrorCardView = (CardView) findViewById(R.id.crew_6);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_6_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_6_job);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }
            //endregion
            //region Crewmember 7
            try {
                crewmember7Img.setImageBitmap(crewmember7ImgBitmap);
                crewmember7Name.setText(crewmember_7_name);
                crewmember7Job.setText(crewmember_7_job);
            } catch (Exception e) {
                CardView ErrorCardView = (CardView) findViewById(R.id.crew_7);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_7_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_7_job);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }
            //endregion
            //region Crewmember 8
            try {
                crewmember8Img.setImageBitmap(crewmember8ImgBitmap);
                crewmember8Name.setText(crewmember_8_name);
                crewmember8Job.setText(crewmember_8_job);
            } catch (Exception e) {
                CardView ErrorCardView = (CardView) findViewById(R.id.crew_8);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_8_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_8_job);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }
            //endregion
            //region Crewmember 9
            try {
                crewmember9Img.setImageBitmap(crewmember9ImgBitmap);
                crewmember9Name.setText(crewmember_9_name);
                crewmember9Job.setText(crewmember_9_job);
            } catch (Exception e) {
                CardView ErrorCardView = (CardView) findViewById(R.id.crew_9);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_9_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_9_job);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }
            //endregion
            //region Crewmember 10
            try {
                crewmember10Img.setImageBitmap(crewmember10ImgBitmap);
                crewmember10Name.setText(crewmember_10_name);
                crewmember10Job.setText(crewmember_10_job);
            } catch (Exception e) {
                CardView ErrorCardView = (CardView) findViewById(R.id.crew_10);
                ErrorCardView.setVisibility(View.GONE);
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_10_name);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_10_job);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = CastCrew_Error_No + 10;
            }
            //endregion

            //region Remove section if no values
            if(CastCrew_Error_No == 100)
            {
                View ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_title);
                ErrorView.setVisibility(View.GONE);
                ErrorView = MovieDetailsUI.this.findViewById(R.id.crew_view);
                ErrorView.setVisibility(View.GONE);
                CastCrew_Error_No = 0;
            }

            else
            {
                CastCrew_Error_No = 0;
            }
            //endregion

            //endregion

            //region Save data for potential future use

            //region Save movie data
            String filename = "Movie" + "-" + ID;
            String string = movie_title + "##" + movie_release_date + "##" + movie_tagline + "##" + movie_overview + "##" + movie_rating + "##" + poster_path + "##" + backdrop_path + "##" + movie_runtime + "##" + movie_language + "##" + movie_budget + "##" + movie_revenue + "##" + movie_voters;
            FileOutputStream outputStream;
            File file = getFileStreamPath(filename);

            if(file == null || !file.exists())
            {
                try
                {
                    outputStream = openFileOutput(filename, MODE_PRIVATE);
                    outputStream.write(string.getBytes());
                    outputStream.write("\r\n".getBytes());
                    outputStream.close();
                }

                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            else
            {

            }
            //endregion

            //endregion
        }
    }

    public void calculateRating() {
        movie_rating = movie_rating.replace(".", "");
        int ratingInt = Integer.parseInt(movie_rating);
        ImageView ratingIcon = (ImageView) findViewById(R.id.movie_rating);
        ImageView ratingBackdrop = (ImageView) findViewById(R.id.movie_rating_backdrop);

        //region Calculate Rating
        if (ratingInt >= 70) {
            ratingIcon.setImageResource(R.mipmap.rating_thumbs_up_plus);
            ratingBackdrop.setImageResource(R.drawable.positive_banner);
        } else {
            if (ratingInt >= 60) {
                ratingIcon.setImageResource(R.mipmap.rating_thumbs_up);
                ratingBackdrop.setImageResource(R.drawable.positive_banner);
            } else {
                if (ratingInt >= 50) {
                    ratingIcon.setImageResource(R.mipmap.rating_neutral);
                    ratingBackdrop.setImageResource(R.drawable.neutral_banner);
                } else {
                    if (ratingInt >= 40) {
                        ratingIcon.setImageResource(R.mipmap.rating_thumbs_down);
                        ratingBackdrop.setImageResource(R.drawable.negative_banner);
                    } else {
                        ratingIcon.setImageResource(R.mipmap.rating_thumbs_down_plus);
                        ratingBackdrop.setImageResource(R.drawable.negative_banner);
                    }
                }
            }
        }
        //endregion
    }

    public void generateLanguageLabel()
    {
        switch(movie_language)
        {
            case "en":
                movie_language = "English";
                break;
            case "English":
                break;
            default:
                movie_language = "Foreign";
            break;
        }



        language.setText(movie_language);
    }

    public void calculateBudgetRevenue() {
        int budget_length = movie_budget.length();
        int revenue_length = movie_revenue.length();

        //region Calculate Budget
        if (budget_length == 9) {
            movie_budget = "$" + (movie_budget.substring(0, 3)) + "m";
            //budget.setText(movie_budget);
        } else {
            if (budget_length == 8) {
                movie_budget = "$" + (movie_budget.substring(0, 2)) + "m";
                //budget.setText(movie_budget);
            } else {
                if (budget_length == 7) {
                    movie_budget = "$" + (movie_budget.substring(0, 1)) + "m";
                    //budget.setText(movie_budget);
                } else {
                    if (budget_length == 6) {
                        movie_budget = "$" + (movie_budget.substring(0, 3)) + "k";
                        //budget.setText(movie_budget);
                    } else {
                        if (budget_length == 5) {
                            movie_budget = "$" + (movie_budget.substring(0, 2)) + "k";
                            //budget.setText(movie_budget);
                        } else {
                            if (budget_length == 4) {
                                movie_budget = "$" + (movie_budget.substring(0, 1)) + "k";
                                //budget.setText(movie_budget);
                            } else {
                                if (budget_length == 3) {
                                    movie_budget = "$" + (movie_budget.substring(0, 3));
                                    //budget.setText(movie_budget);
                                } else {
                                    if (budget_length == 2) {
                                        movie_budget = "$" + (movie_budget.substring(0, 2));
                                        //budget.setText(movie_budget);
                                    } else {
                                        if (budget_length == 1) {
                                            movie_budget = "$" + (movie_budget.substring(0, 1));
                                            //budget.setText(movie_budget);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //endregion

        //region Calculate Revenue
        if (revenue_length == 10) {
            movie_revenue = "$" + (movie_revenue.substring(0, 1)) + "." + (movie_revenue.substring(1, 2)) + "b";
            //revenue.setText(movie_revenue);
        } else {
            if (revenue_length == 9) {
                movie_revenue = "$" + (movie_revenue.substring(0, 3)) + "m";
                //revenue.setText(movie_revenue);
            } else {
                if (revenue_length == 8) {
                    movie_revenue = "$" + (movie_revenue.substring(0, 2)) + "m";
                    //revenue.setText(movie_revenue);
                } else {
                    if (revenue_length == 7) {
                        movie_revenue = "$" + (movie_revenue.substring(0, 1)) + "m";
                        ////revenue.setText(movie_revenue);
                    } else {
                        if (revenue_length == 6) {
                            movie_revenue = "$" + (movie_revenue.substring(0, 3)) + "k";
                            //revenue.setText(movie_revenue);
                        } else {
                            if (revenue_length == 5) {
                                movie_revenue = "$" + (movie_revenue.substring(0, 2)) + "k";
                                //revenue.setText(movie_revenue);
                            } else {
                                if (revenue_length == 4) {
                                    movie_revenue = "$" + (movie_revenue.substring(0, 1)) + "k";
                                    //revenue.setText(movie_revenue);
                                } else {
                                    if (revenue_length == 3) {
                                        movie_revenue = "$" + (movie_revenue.substring(0, 3));
                                        //revenue.setText(movie_revenue);
                                    } else {
                                        if (revenue_length == 2) {
                                            movie_revenue = "$" + (movie_revenue.substring(0, 2));
                                            //revenue.setText(movie_revenue);
                                        } else {
                                            if (revenue_length == 1) {
                                                if (movie_revenue == "0") {
                                                    movie_revenue = "TBD";

                                                    revenue.setText("movie_revenue");
                                                } else {
                                                    movie_revenue = "$" + (movie_revenue.substring(0, 1));
                                                    //revenue.setText(movie_revenue);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //endregion
    }
}


