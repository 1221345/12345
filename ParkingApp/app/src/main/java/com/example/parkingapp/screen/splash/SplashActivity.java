package com.example.parkingapp.screen.splash;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parkingapp.R;
import com.example.parkingapp.app.App;
import com.example.parkingapp.screen.login.LoginActivity;

import java.util.concurrent.Executors;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Executors.newSingleThreadExecutor().execute(() -> {
            App.getDatabase().userDao().findUserByMail("vik@vik.com");
//            if (App.getDatabase() != null && !App.getDatabase().userDao().getAll().isEmpty()) {
//                startNextActivity(new Intent(SplashActivity.this, MainActivity.class));
//            } else {
                startNextActivity(new Intent(SplashActivity.this, LoginActivity.class));
//            }
            finish();
        });
    }

    private void startNextActivity(Intent intent) {
        startActivity(intent);
    }
}