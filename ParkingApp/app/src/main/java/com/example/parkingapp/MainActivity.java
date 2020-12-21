package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.parkingapp.database.AppDatabase;
import com.example.parkingapp.model.User;

import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                if( db.userDao().getAll().size() == 0) {
                    db.userDao().insertUser(new User("BuktopMKD@gmail.com", "12345?"));
                }
            }
        });

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                db.userDao().getAll();
            }
        });


    }
}