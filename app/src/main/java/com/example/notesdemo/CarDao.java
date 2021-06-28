package com.example.notesdemo;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CarDao {
    @Query("INSERT INTO cars (make, model) VALUES (:make, :model)")
    void create(String make, String model);

    @Query("SELECT * FROM cars")
    List<Car> getAllCars();
}

