package com.example.notesdemo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="cars")
public class Car {
    @PrimaryKey
    public int id;

    @ColumnInfo(name="make")
    public String make;

    @ColumnInfo(name="model")
    public String model;
}

