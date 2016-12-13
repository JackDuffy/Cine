package uk.ac.lincoln.jackduffy.cine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

// https://github.com/cstew/Splash/blob/master/app/src/main/java/com/bignerdranch/android/splash/SplashActivity.java
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainUI.class);
        startActivity(intent);
        finish();
    }
}