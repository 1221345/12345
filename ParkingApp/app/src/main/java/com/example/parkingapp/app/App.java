package com.example.parkingapp.app;

import android.app.Application;

import androidx.room.Room;

import com.example.parkingapp.database.AppDatabase;

public class App extends Application {

    static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();
    }

    public static AppDatabase getDatabase() {
        return db;
    }
}