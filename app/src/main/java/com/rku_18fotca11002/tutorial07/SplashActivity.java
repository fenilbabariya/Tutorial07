package com.rku_18fotca11002.tutorial07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                SharedPreferences preferences = getSharedPreferences("user", MODE_PRIVATE);
                String userPreference =preferences.getString("username","");
                if(userPreference.equals("")){
                    startActivity(new Intent(SplashActivity.this,Login.class));
                }else{
                    startActivity(new Intent(SplashActivity.this,Welcome.class));
                }
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 1000);
    }
}