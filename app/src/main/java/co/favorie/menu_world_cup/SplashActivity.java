package co.favorie.menu_world_cup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import co.favorie.menu_world_cup.Preferences.ManagePreferences;

public class SplashActivity extends AppCompatActivity {

    private final static int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        ManagePreferences pref = new ManagePreferences(this);

        pref.resetAllPref();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }

        }, SPLASH_TIME_OUT);
    }
}
