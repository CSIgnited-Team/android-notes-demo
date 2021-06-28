package com.example.notesdemo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Car.class}, version = 1)
public abstract class CarsDatabase extends RoomDatabase {
    public abstract CarDao carDao();
}

