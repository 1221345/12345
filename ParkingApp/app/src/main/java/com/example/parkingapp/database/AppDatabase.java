package com.example.parkingapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.parkingapp.model.User;
import com.example.parkingapp.model.UserDao;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
