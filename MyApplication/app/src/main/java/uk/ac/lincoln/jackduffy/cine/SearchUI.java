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
    ImageView iv1;
    ImageView iv2;
    ImageView iv3;
    ImageView iv4;
    ImageView iv5;
    ImageView iv6;
    ImageView iv7;
    ImageView iv8;
    ImageView iv9;
    //endregion

    //region Generate all potential Bitmap items
    Bitmap bitmap1;
    Bitmap bitmap2;
    Bitmap bitmap3;
    Bitmap bitmap4;
    Bitmap bitmap5;
    Bitmap bitmap6;
    Bitmap bitmap7;
    Bitmap bitmap8;
    Bitmap bitmap9;
    //endregion

    //region Generate all potential String items
    String mID1;
    String mID2;
    String mID3;
    String mID4;
    String mID5;
    String mID6;
    String mID7;
    String mID8;
    String mID9;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_ui);
        TextView name = (TextView)findViewById(R.id.searchField);
        SharedPreferences userInfo = getSharedPreferences("searchQueries", Context.MODE_PRIVATE);
        name.setText(userInfo.getString("searchQuery", ""));

        ImageView PM1 = (ImageView) findViewById(R.id.search_result_1_poster);
        PM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mID1 != null) {
                    Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
                    intent.putExtra("movieID", mID1);
                    startActivity(intent);
                }
            }
        });

        ImageView PM2 = (ImageView) findViewById(R.id.search_result_2_poster);
        PM2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mID2 != null) {
                    Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
                    intent.putExtra("movieID", mID2);
                    startActivity(intent);
                }
            }
        });

        ImageView PM3 = (ImageView) findViewById(R.id.search_result_3_poster);
        PM3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mID3 != null) {
                    Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
                    intent.putExtra("movieID", mID3);
                    startActivity(intent);
                }
            }
        });

        ImageView PM4 = (ImageView) findViewById(R.id.search_result_4_poster);
        PM4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mID4 != null) {
                    Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
                    intent.putExtra("movieID", mID4);
                    startActivity(intent);
                }
            }
        });

        ImageView PM5 = (ImageView) findViewById(R.id.search_result_5_poster);
        PM5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mID5 != null) {
                    Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
                    intent.putExtra("movieID", mID5);
                    startActivity(intent);
                }
            }
        });

        ImageView PM6 = (ImageView) findViewById(R.id.search_result_6_poster);
        PM6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mID6 != null) {
                    Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
                    intent.putExtra("movieID", mID6);
                    startActivity(intent);
                }
            }
        });

        ImageView PM7 = (ImageView) findViewById(R.id.search_result_7_poster);
        PM7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mID7 != null) {
                    Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
                    intent.putExtra("movieID", mID7);
                    startActivity(intent);
                }
            }
        });

        ImageView PM8 = (ImageView) findViewById(R.id.search_result_8_poster);
        PM8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mID8 != null) {
                    Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
                    intent.putExtra("movieID", mID8);
                    startActivity(intent);
                }
            }
        });

        ImageView PM9 = (ImageView) findViewById(R.id.search_result_9_poster);
        PM9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mID9 != null) {
                    Intent intent = new Intent(getApplicationContext(), MovieDetailsUI.class);
                    intent.putExtra("movieID", mID9);
                    startActivity(intent);
                }
            }
        });
        //endregion
    }

    public class search extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
        }

        @Override
        protected String doInBackground(String... arg0) {
            String url = "http://api.themoviedb.org/3/search/movie?query=" + searchQuery + apiKey;

            try {
                httpConnect jParser = new httpConnect();
                JSONObject json2obj = new JSONObject(jParser.getJSONFromUrl(url));
                JSONArray json2arr = json2obj.getJSONArray("results");
                List<String> movieIDs = new ArrayList<String>(json2arr.length());
                List<String> posterPaths = new ArrayList<String>(json2arr.length());

                for (int i = 0; i < json2arr.length(); i++) {
                    JSONObject ithObject = json2arr.getJSONObject(i);
                    if (ithObject.has("poster_path") && (ithObject.has("id"))) {
                        movieIDs.add(ithObject.getString("id"));
                        posterPaths.add(ithObject.getString("poster_path"));
                    }
                }

                numberOfResults = movieIDs.size();
                System.out.println(numberOfResults + " results found");
                //TEMPORARY - REMOVE WHEN FULLY OPERATIONAL
                if (numberOfResults > 9) {
                    numberOfResults = 9;
                }

                int movie_ID_number = 1;
                for (String movieID : movieIDs) {
                    if (numberOfResults == 0) {
                        break;
                    }

                    if (movie_ID_number <= numberOfResults) {
                        ID = movieID;
                        //region Apply the correct ID to each ID string
                        switch (movie_ID_number) {
                            case 1:
                                mID1 = ID;
                                movie_ID_number++;
                                break;
                            case 2:
                                mID2 = ID;
                                movie_ID_number++;
                                break;
                            case 3:
                                mID3 = ID;
                                movie_ID_number++;
                                break;
                            case 4:
                                mID4 = ID;
                                movie_ID_number++;
                                break;
                            case 5:
                                mID5 = ID;
                                movie_ID_number++;
                                break;
                            case 6:
                                mID6 = ID;
                                movie_ID_number++;
                                break;
                            case 7:
                                mID7 = ID;
                                movie_ID_number++;
                                break;
                            case 8:
                                mID8 = ID;
                                movie_ID_number++;
                                break;
                            case 9:
                                mID9 = ID;
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
                                iv1 = (ImageView) findViewById(R.id.search_result_1_poster);
                                bitmap1 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 2:
                                iv2 = (ImageView) findViewById(R.id.search_result_2_poster);
                                bitmap2 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 3:
                                iv3 = (ImageView) findViewById(R.id.search_result_3_poster);
                                bitmap3 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 4:
                                iv4 = (ImageView) findViewById(R.id.search_result_4_poster);
                                bitmap4 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 5:
                                iv5 = (ImageView) findViewById(R.id.search_result_5_poster);
                                bitmap5 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 6:
                                iv6 = (ImageView) findViewById(R.id.search_result_6_poster);
                                bitmap6 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 7:
                                iv7 = (ImageView) findViewById(R.id.search_result_7_poster);
                                bitmap7 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 8:
                                iv8 = (ImageView) findViewById(R.id.search_result_8_poster);
                                bitmap8 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                            case 9:
                                iv9 = (ImageView) findViewById(R.id.search_result_9_poster);
                                bitmap9 = BitmapFactory.decodeStream((InputStream) new URL(poster_path).getContent());
                                poster_number++;
                                break;
                        }
                    }
                }
            } catch (Exception e) {

            }
            return null;
        }

        @Override
        // below method will run when service HTTP request is complete,
        protected void onPostExecute(String strFromDoInBg)
        {
            CardView card;
            if(numberOfResults != 0)
            {
                for (int posterToApply = 1; posterToApply <= numberOfResults; posterToApply++)
                {
                    switch (posterToApply) {
                        case 1:
                            card = (CardView) findViewById(R.id.search_result_1);
                            iv1.setImageBitmap(bitmap1);
                            card.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            card = (CardView) findViewById(R.id.search_result_2);
                            iv2.setImageBitmap(bitmap2);
                            card.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            card = (CardView) findViewById(R.id.search_result_3);
                            iv3.setImageBitmap(bitmap3);
                            card.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            card = (CardView) findViewById(R.id.search_result_4);
                            iv4.setImageBitmap(bitmap4);
                            card.setVisibility(View.VISIBLE);
                            break;
                        case 5:
                            card = (CardView) findViewById(R.id.search_result_5);
                            iv5.setImageBitmap(bitmap5);
                            card.setVisibility(View.VISIBLE);
                            break;
                        case 6:
                            card = (CardView) findViewById(R.id.search_result_6);
                            iv6.setImageBitmap(bitmap6);
                            card.setVisibility(View.VISIBLE);
                            break;
                        case 7:
                            card = (CardView) findViewById(R.id.search_result_7);
                            iv7.setImageBitmap(bitmap7);
                            card.setVisibility(View.VISIBLE);
                            break;
                        case 8:
                            card = (CardView) findViewById(R.id.search_result_8);
                            iv8.setImageBitmap(bitmap8);
                            card.setVisibility(View.VISIBLE);
                            break;
                        case 9:
                            card = (CardView) findViewById(R.id.search_result_9);
                            iv9.setImageBitmap(bitmap9);
                            card.setVisibility(View.VISIBLE);
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

    public void searchMovies (View view) {

        // get string values of user name and email EditText widgets
        EditText searchFieldQuery = (EditText)findViewById(R.id.searchField);

        // create a new shared preferences file by name
        // if it already exists it will use existing file
        try
        {
            final EditText edit =  (EditText) findViewById(R.id.searchField);
            searchQuery = edit.getText().toString();
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
}
