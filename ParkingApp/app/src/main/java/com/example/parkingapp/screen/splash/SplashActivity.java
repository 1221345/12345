package com.example.parkingapp.screen.splash;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parkingapp.R;
import com.example.parkingapp.app.App;
import com.example.parkingapp.screen.home.MainActivity;

import java.util.concurrent.Executors;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                if (App.getDatabase() != null && App.getDatabase().userDao().getAll().size() > 0) {
                    Intent homeIntent = new Intent(SplashActivity.this, MainActivity.class);
                    SplashActivity.this.startActivity(homeIntent);
                } else {
                    //TODO
                    //Intent loginActivity = new Intent(this, LoginActivity.class);
                }
            }
        });
    }
}