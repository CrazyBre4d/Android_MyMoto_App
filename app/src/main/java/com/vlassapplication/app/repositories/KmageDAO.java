package com.vlassapplication.app.repositories;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.vlassapplication.app.entities.Kmage;

import java.util.List;

import retrofit2.http.GET;

@Dao
public interface KmageDAO {
    @Query("SELECT * FROM kmage ORDER BY id DESC LIMIT 1")
    Kmage getCurrentKmage();
    @Insert
    void addKmage(Kmage kmage);


}
