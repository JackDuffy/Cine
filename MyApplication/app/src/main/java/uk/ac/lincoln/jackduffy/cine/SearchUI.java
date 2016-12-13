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
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
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

import android.view.View;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.util.Log;


public class SearchUI extends AppCompatActivity {
    String apiKey = "&api_key=822b6a3af922b0c70d5455e2d2e0f782";
    String searchQuery = "";
    Boolean searchInProgress = false;

    Integer numberOfResults;
    String poster_path;
    String ID;

    //region Generate all potential ImageView elements
    ImageView searchPoster1;
    ImageView searchPoster2;
    ImageView searchPoster3;
    ImageView searchPoster4;
    ImageView searchPoster5;
    ImageView searchPoster6;
    ImageView searchPoster7;
    ImageView searchPoster8;
    ImageView searchPoster9;
    ImageView searchPoster10;
    ImageView searchPoster11;
    ImageView searchPoster12;
    ImageView searchPoster13;
    ImageView searchPoster14;
    ImageView searchPoster15;
    ImageView searchPoster16;
    ImageView searchPoster17;
    ImageView searchPoster18;
    ImageView searchPoster19;
    ImageView searchPoster20;
    ImageView searchPoster21;
    ImageView searchPoster22;
    ImageView searchPoster23;
    ImageView searchPoster24;
    ImageView searchPoster25;
    //endregion

    TextView searchNameLabel1;
    TextView searchNameLabel2;
    TextView searchNameLabel3;
    TextView searchNameLabel4;
    TextView searchNameLabel5;
    TextView searchNameLabel6;
    TextView searchNameLabel7;
    TextView searchNameLabel8;
    TextView searchNameLabel9;
    TextView searchNameLabel10;
    TextView searchNameLabel11;
    TextView searchNameLabel12;
    TextView searchNameLabel13;
    TextView searchNameLabel14;
    TextView searchNameLabel15;
    TextView searchNameLabel16;
    TextView searchNameLabel17;
    TextView searchNameLabel18;
    TextView searchNameLabel19;
    TextView searchNameLabel20;
    TextView searchNameLabel21;
    TextView searchNameLabel22;
    TextView searchNameLabel23;
    TextView searchNameLabel24;
    TextView searchNameLabel25;

    //region Generate all potential Bitmap items
    Bitmap searchPosterBitmap1;
    Bitmap searchPosterBitmap2;
    Bitmap searchPosterBitmap3;
    Bitmap searchPosterBitmap4;
    Bitmap searchPosterBitmap5;
    Bitmap searchPosterBitmap6;
    Bitmap searchPosterBitmap7;
    Bitmap searchPosterBitmap8;
    Bitmap searchPosterBitmap9;
    Bitmap searchPosterBitmap10;
    Bitmap searchPosterBitmap11;
    Bitmap searchPosterBitmap12;
    Bitmap searchPosterBitmap13;
    Bitmap searchPosterBitmap14;
    Bitmap searchPosterBitmap15;
    Bitmap searchPosterBitmap16;
    Bitmap searchPosterBitmap17;
    Bitmap searchPosterBitmap18;
    Bitmap searchPosterBitmap19;
    Bitmap searchPosterBitmap20;
    Bitmap searchPosterBitmap21;
    Bitmap searchPosterBitmap22;
    Bitmap searchPosterBitmap23;
    Bitmap searchPosterBitmap24;
    Bitmap searchPosterBitmap25;
    //endregion

    //region Generate all potential String items
    String searchID1;
    String searchID2;
    String searchID3;
    String searchID4;
    String searchID5;
    String searchID6;
    String searchID7;
    String searchID8;
    String searchID9;
    String searchID10;
    String searchID11;
    String searchID12;
    String searchID13;
    String searchID14;
    String searchID15;
    String searchID16;
    String searchID17;
    String searchID18;
    String searchID19;
    String searchID20;
    String searchID21;
    String searchID22;
    String searchID23;
    String searchID24;
    String searchID25;

    String searchName1;
    String searchName2;
    String searchName3;
    String searchName4;
    String searchName5;
    String searchName6;
    String searchName7;
    String searchName8;
    String searchName9;
    String searchName10;
    String searchName11;
    String searchName12;
    String searchName13;
    String searchName14;
    String searchName15;
    String searchName16;
    String searchName17;
    String searchName18;
    String searchName19;
    String searchName20;
    String searchName21;
    String searchName22;
    String searchName23;
    String searchName24;
    String searchName25;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_ui);
        TextView name = (TextView)findViewById(R.id.searchField);
        SharedPreferences userInfo = getSharedPreferences("searchQueries", Context.MODE_PRIVATE);
        name.setText(userInfo.getString("searchQuery", ""));
    }

    public class search extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
        }

        @Override
        protected String doInBackground(String... arg0) {
            String url = "http://api.themoviedb.org/3/search/movie?query=" + searchQuery + apiKey;
            //String url = "https://api.themoviedb.org/3/movie/now_playing?" + apiKey + "&language=en-US&page=1";

            System.out.println("The URL I am attempting to access is:");
            System.out.println(url);

            try
            {
                httpConnect jParser = new httpConnect();
                JSONObject json2obj = new JSONObject(jParser.getJSONFromUrl(url));
                JSONArray json2arr = json2obj.getJSONArray("results");
                List<String> movieIDs = new ArrayList<String>(json2arr.length());
                List<String> posterPaths = new ArrayList<String>(json2arr.length());
                List<String> movieNames = new ArrayList<String>(json2arr.length());


                for (int i = 0; i < json2arr.length(); i++)
                {
                    JSONObject ithObject = json2arr.getJSONObject(i);
                    if (ithObject.has("poster_path") && (ithObject.has("id")) && (ithObject.has("title"))) {
                        movieIDs.add(ithObject.getString("id"));
                        posterPaths.add(ithObject.getString("poster_path"));
                        movieNames.add(ithObject.getString("title"));
                    }
                }

                numberOfResults = movieIDs.size();
                System.out.println(numberOfResults + " results found");

                int movie_ID_number = 1;
                for (String movieID : movieIDs)
                {
                    if (numberOfResults == 0)
                    {
                        System.out.println("Something went wrong");
                        break;
                    }

                    if (movie_ID_number <= numberOfResults) {
                        ID = movieID;
                        //region Apply the correct ID to each ID string
                        switch (movie_ID_number) {
                            case 1:
                                searchID1 = ID;
                                movie_ID_number++;
                                break;
                            case 2:
                                searchID2 = ID;
                                movie_ID_number++;
                                break;
                            case 3:
                                searchID3 = ID;
                                movie_ID_number++;
                                break;
                            case 4:
                                searchID4 = ID;
                                movie_ID_number++;
                                break;
                            case 5:
                                searchID5 = ID;
                                movie_ID_number++;
                                break;
                            case 6:
                                searchID6 = ID;
                                movie_ID_number++;
                                break;
                            case 7:
                                searchID7 = ID;
                                movie_ID_number++;
                                break;
                            case 8:
                                searchID8 = ID;
                                movie_ID_number++;
                                break;
                            case 9:
                                searchID9 = ID;
                                movie_ID_number++;
                                break;
                            case 10:
                                searchID10 = ID;
                                movie_ID_number++;
                                break;
                            case 11:
                                searchID11 = ID;
                                movie_ID_number++;
                                break;
                            case 12:
                                searchID12 = ID;
                                movie_ID_number++;
                                break;
                            case 13:
                                searchID13 = ID;
                                movie_ID_number++;
                                break;
                            case 14:
                                searchID14 = ID;
                                movie_ID_number++;
                                break;
                            case 15:
                                searchID15 = ID;
                                movie_ID_number++;
                                break;
                            case 16:
                                searchID16 = ID;
                                movie_ID_number++;
                                break;
                            case 17:
                                searchID17 = ID;
                                movie_ID_number++;
                                break;
                            case 18:
                                searchID18 = ID;
                                movie_ID_number++;
                                break;
                            case 19:
                                searchID19 = ID;
                                movie_ID_number++;
                                break;
                            case 20:
                                searchID20 = ID;
                                movie_ID_number++;
                                break;
                        }
                        //endregion
                    } else {
                        break;
                    }

                }

                int poster_number = 1;
                for (String posterPath : posterPaths) {
                    if (numberOfResults == 0) {
                        break;
                    }

                    if (poster_number <= numberOfResults) {
                        if (poster_number > numberOfResults) {
                            break;
                        }

                        if (posterPath == "null") {
                            poster_path = "https://www.themoviedb.org/assets/e2dd052f141e33392eb749aab2414ec0/images/no-poster-w300_and_h450_bestv2-v2.png";
                        } else {
                            poster_path = "https://image.tmdb.org/t/p/w300_and_h450_bestv2" + posterPath;
                        }

                        //region Locate the card element in the activity and apply the correct poster URL's to each corrosponding bitmap
                        switch (poster_number) {
                            case 1:
                                searchPoster1 = (ImageView) findViewById(R.id.search_result_1_poster);
                                searchPosterBitmap1 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 2:
                                searchPoster2 = (ImageView) findViewById(R.id.search_result_2_poster);
                                searchPosterBitmap2 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 3:
                                searchPoster3 = (ImageView) findViewById(R.id.search_result_3_poster);
                                searchPosterBitmap3 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 4:
                                searchPoster4 = (ImageView) findViewById(R.id.search_result_4_poster);
                                searchPosterBitmap4 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 5:
                                searchPoster5 = (ImageView) findViewById(R.id.search_result_5_poster);
                                searchPosterBitmap5 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 6:
                                searchPoster6 = (ImageView) findViewById(R.id.search_result_6_poster);
                                searchPosterBitmap6 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 7:
                                searchPoster7 = (ImageView) findViewById(R.id.search_result_7_poster);
                                searchPosterBitmap7 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 8:
                                searchPoster8 = (ImageView) findViewById(R.id.search_result_8_poster);
                                searchPosterBitmap8 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 9:
                                searchPoster9 = (ImageView) findViewById(R.id.search_result_9_poster);
                                searchPosterBitmap9 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 10:
                                searchPoster10 = (ImageView) findViewById(R.id.search_result_10_poster);
                                searchPosterBitmap10 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 11:
                                searchPoster11 = (ImageView) findViewById(R.id.search_result_11_poster);
                                searchPosterBitmap11 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 12:
                                searchPoster12 = (ImageView) findViewById(R.id.search_result_12_poster);
                                searchPosterBitmap12 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 13:
                                searchPoster13 = (ImageView) findViewById(R.id.search_result_13_poster);
                                searchPosterBitmap13 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 14:
                                searchPoster14 = (ImageView) findViewById(R.id.search_result_14_poster);
                                searchPosterBitmap14 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 15:
                                searchPoster15 = (ImageView) findViewById(R.id.search_result_15_poster);
                                searchPosterBitmap15 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 16:
                                searchPoster16 = (ImageView) findViewById(R.id.search_result_16_poster);
                                searchPosterBitmap16 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 17:
                                searchPoster17 = (ImageView) findViewById(R.id.search_result_17_poster);
                                searchPosterBitmap17 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 18:
                                searchPoster18 = (ImageView) findViewById(R.id.search_result_18_poster);
                                searchPosterBitmap18 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 19:
                                searchPoster19 = (ImageView) findViewById(R.id.search_result_19_poster);
                                searchPosterBitmap19 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 20:
                                searchPoster20 = (ImageView) findViewById(R.id.search_result_20_poster);
                                searchPosterBitmap20 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                        }
                    }
                }

                int movieNo = 1;
                for (String movieName : movieNames)
                {
                    if (numberOfResults == 0) {
                        break;
                    }

                    if (movieNo <= numberOfResults) {
                        String Name = movieName;
                        System.out.println("Movie: " + Name);

                        //region Locate the card element in the activity and apply the correct poster URL's to each corrosponding bitmap
                        switch (movieNo) {
                            case 1:
                                searchName1 = Name;
                                movieNo++;
                                break;
                            case 2:
                                searchName2 = Name;
                                movieNo++;
                                break;
                            case 3:
                                searchName3 = Name;
                                movieNo++;
                                break;
                            case 4:
                                searchName4 = Name;
                                movieNo++;
                                break;
                            case 5:
                                searchName5 = Name;
                                movieNo++;
                                break;
                            case 6:
                                searchName6 = Name;
                                movieNo++;
                                break;
                            case 7:
                                searchName7 = Name;
                                movieNo++;
                                break;
                            case 8:
                                searchName8 = Name;
                                movieNo++;
                                break;
                            case 9:
                                searchName9 = Name;
                                movieNo++;
                                break;
                            case 10:
                                searchName10 = Name;
                                movieNo++;
                                break;
                            case 11:
                                searchName11 = Name;
                                movieNo++;
                                break;
                            case 12:
                                searchName12 = Name;
                                movieNo++;
                                break;
                            case 13:
                                searchName13 = Name;
                                movieNo++;
                                break;
                            case 14:
                                searchName14 = Name;
                                movieNo++;
                                break;
                            case 15:
                                searchName15 = Name;
                                movieNo++;
                                break;
                            case 16:
                                searchName16 = Name;
                                movieNo++;
                                break;
                            case 17:
                                searchName17 = Name;
                                movieNo++;
                                break;
                            case 18:
                                searchName18 = Name;
                                movieNo++;
                                break;
                            case 19:
                                searchName19 = Name;
                                movieNo++;
                                break;
                            case 20:
                                searchName20 = Name;
                                movieNo++;
                                break;
                        }
                    }
                }
            }

            catch (Exception e)
            {
                System.out.println("O shit");
            }

            return null;

        }


        @Override
        // below method will run when service HTTP request is complete,
        protected void onPostExecute(String strFromDoInBg)
        {
            CardView card;
            TextView text;
            if(numberOfResults != 0)
            {
                for (int posterToApply = 1; posterToApply <= numberOfResults; posterToApply++)
                {
                    switch (posterToApply) {
                        case 1:
                            card = (CardView) findViewById(R.id.search_result_1);
                            searchPoster1.setImageBitmap(searchPosterBitmap1);
                            searchNameLabel1 = (TextView) findViewById(R.id.search_result_1_name);
                            searchNameLabel1.setText(searchName1);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_1_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            card = (CardView) findViewById(R.id.search_result_2);
                            searchPoster2.setImageBitmap(searchPosterBitmap2);
                            searchNameLabel2 = (TextView) findViewById(R.id.search_result_2_name);
                            searchNameLabel2.setText(searchName2);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_2_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            card = (CardView) findViewById(R.id.search_result_3);
                            searchPoster3.setImageBitmap(searchPosterBitmap3);
                            searchNameLabel3 = (TextView) findViewById(R.id.search_result_3_name);
                            searchNameLabel3.setText(searchName3);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_3_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            card = (CardView) findViewById(R.id.search_result_4);
                            searchPoster4.setImageBitmap(searchPosterBitmap4);
                            searchNameLabel4 = (TextView) findViewById(R.id.search_result_4_name);
                            searchNameLabel4.setText(searchName4);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_4_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 5:
                            card = (CardView) findViewById(R.id.search_result_5);
                            searchPoster5.setImageBitmap(searchPosterBitmap5);
                            searchNameLabel5 = (TextView) findViewById(R.id.search_result_5_name);
                            searchNameLabel5.setText(searchName5);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_5_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 6:
                            card = (CardView) findViewById(R.id.search_result_6);
                            searchPoster6.setImageBitmap(searchPosterBitmap6);
                            searchNameLabel6 = (TextView) findViewById(R.id.search_result_6_name);
                            searchNameLabel6.setText(searchName6);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_6_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 7:
                            card = (CardView) findViewById(R.id.search_result_7);
                            searchPoster7.setImageBitmap(searchPosterBitmap7);
                            searchNameLabel7 = (TextView) findViewById(R.id.search_result_7_name);
                            searchNameLabel7.setText(searchName7);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_7_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 8:
                            card = (CardView) findViewById(R.id.search_result_8);
                            searchPoster8.setImageBitmap(searchPosterBitmap8);
                            searchNameLabel8 = (TextView) findViewById(R.id.search_result_8_name);
                            searchNameLabel8.setText(searchName8);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_8_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 9:
                            card = (CardView) findViewById(R.id.search_result_9);
                            searchPoster9.setImageBitmap(searchPosterBitmap9);
                            searchNameLabel9 = (TextView) findViewById(R.id.search_result_9_name);
                            searchNameLabel9.setText(searchName9);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_9_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 10:
                            card = (CardView) findViewById(R.id.search_result_10);
                            searchPoster10.setImageBitmap(searchPosterBitmap10);
                            searchNameLabel10 = (TextView) findViewById(R.id.search_result_10_name);
                            searchNameLabel10.setText(searchName10);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_10_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 11:
                            card = (CardView) findViewById(R.id.search_result_11);
                            searchPoster11.setImageBitmap(searchPosterBitmap11);
                            searchNameLabel11 = (TextView) findViewById(R.id.search_result_11_name);
                            searchNameLabel11.setText(searchName11);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_11_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 12:
                            card = (CardView) findViewById(R.id.search_result_12);
                            searchPoster12.setImageBitmap(searchPosterBitmap12);
                            searchNameLabel12 = (TextView) findViewById(R.id.search_result_12_name);
                            searchNameLabel12.setText(searchName12);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_12_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 13:
                            card = (CardView) findViewById(R.id.search_result_13);
                            searchPoster13.setImageBitmap(searchPosterBitmap13);
                            searchNameLabel13 = (TextView) findViewById(R.id.search_result_13_name);
                            searchNameLabel13.setText(searchName13);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_13_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 14:
                            card = (CardView) findViewById(R.id.search_result_14);
                            searchPoster14.setImageBitmap(searchPosterBitmap14);
                            searchNameLabel14 = (TextView) findViewById(R.id.search_result_14_name);
                            searchNameLabel14.setText(searchName14);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_14_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 15:
                            card = (CardView) findViewById(R.id.search_result_15);
                            searchPoster15.setImageBitmap(searchPosterBitmap15);
                            searchNameLabel15 = (TextView) findViewById(R.id.search_result_15_name);
                            searchNameLabel15.setText(searchName15);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_15_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 16:
                            card = (CardView) findViewById(R.id.search_result_16);
                            searchPoster16.setImageBitmap(searchPosterBitmap16);
                            searchNameLabel16 = (TextView) findViewById(R.id.search_result_16_name);
                            searchNameLabel16.setText(searchName16);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_16_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 17:
                            card = (CardView) findViewById(R.id.search_result_17);
                            searchPoster17.setImageBitmap(searchPosterBitmap17);
                            searchNameLabel17 = (TextView) findViewById(R.id.search_result_17_name);
                            searchNameLabel17.setText(searchName17);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_17_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 18:
                            card = (CardView) findViewById(R.id.search_result_18);
                            searchPoster18.setImageBitmap(searchPosterBitmap18);
                            searchNameLabel18 = (TextView) findViewById(R.id.search_result_18_name);
                            searchNameLabel18.setText(searchName18);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_18_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 19:
                            card = (CardView) findViewById(R.id.search_result_19);
                            searchPoster19.setImageBitmap(searchPosterBitmap19);
                            searchNameLabel19 = (TextView) findViewById(R.id.search_result_19_name);
                            searchNameLabel19.setText(searchName19);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_19_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                        case 20:
                            card = (CardView) findViewById(R.id.search_result_20);
                            searchPoster20.setImageBitmap(searchPosterBitmap20);
                            searchNameLabel20 = (TextView) findViewById(R.id.search_result_20_name);
                            searchNameLabel20.setText(searchName20);
                            card.setVisibility(View.VISIBLE);
                            text = (TextView) findViewById(R.id.search_result_20_name);
                            text.setVisibility(View.VISIBLE);
                            break;
                    }
                }
            }

            else
            {
                System.out.println("no data");
            }

            searchInProgress = false;
        }
    }

    public void searchMovies (View view)
    {
        EditText searchFieldQuery = (EditText)findViewById(R.id.searchField);

        try
        {
            final EditText edit =  (EditText) findViewById(R.id.searchField);
            searchQuery = edit.getText().toString();
            searchQuery = searchQuery.replaceAll(" ", "%20").toLowerCase();
            System.out.println("Your search query is: " + searchQuery);
            new search().execute();

            SharedPreferences userInfo = getSharedPreferences("searchQueries", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = userInfo.edit();
            editor.putString("searchQuery", searchFieldQuery.getText().toString());
            editor.commit();
        }

        catch(Exception ex)
        {
            Context context = getApplicationContext();
            CharSequence text = "Something went wrong there...";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void searchResult1 (View view)
    {
        if (searchID1 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID1);
            startActivity(intent);
        }
    }

    public void searchResult2 (View view)
    {
        if (searchID2 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID2);
            startActivity(intent);
        }
    }

    public void searchResult3 (View view)
    {
        if (searchID3 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID3);
            startActivity(intent);
        }
    }

    public void searchResult4 (View view)
    {
        if (searchID4 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID4);
            startActivity(intent);
        }
    }

    public void searchResult5 (View view)
    {
        if (searchID5 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID5);
            startActivity(intent);
        }
    }

    public void searchResult6 (View view)
    {
        if (searchID6 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID6);
            startActivity(intent);
        }
    }

    public void searchResult7 (View view)
    {
        if (searchID7 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID7);
            startActivity(intent);
        }
    }

    public void searchResult8 (View view)
    {
        if (searchID8 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID8);
            startActivity(intent);
        }
    }

    public void searchResult9 (View view)
    {
        if (searchID9 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID9);
            startActivity(intent);
        }
    }

    public void searchResult10 (View view)
    {
        if (searchID10 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID10);
            startActivity(intent);
        }
    }

    public void searchResult11 (View view)
    {
        if (searchID11 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID11);
            startActivity(intent);
        }
    }

    public void searchResult12 (View view)
    {
        if (searchID12 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID12);
            startActivity(intent);
        }
    }

    public void searchResult13 (View view)
    {
        if (searchID13 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID13);
            startActivity(intent);
        }
    }

    public void searchResult14 (View view)
    {
        if (searchID14 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID14);
            startActivity(intent);
        }
    }

    public void searchResult15 (View view)
    {
        if (searchID15 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID15);
            startActivity(intent);
        }
    }

    public void searchResult16 (View view)
    {
        if (searchID16 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID16);
            startActivity(intent);
        }
    }

    public void searchResult17 (View view)
    {
        if (searchID17 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID17);
            startActivity(intent);
        }
    }

    public void searchResult18 (View view)
    {
        if (searchID18 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID18);
            startActivity(intent);
        }
    }

    public void searchResult19 (View view)
    {
        if (searchID19 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID19);
            startActivity(intent);
        }
    }

    public void searchResult20 (View view)
    {
        if (searchID20 != null) {
            Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
            intent.putExtra("movieID", searchID20);
            startActivity(intent);
        }
    }
}
