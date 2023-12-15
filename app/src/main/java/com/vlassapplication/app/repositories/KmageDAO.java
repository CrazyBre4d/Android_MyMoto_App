package com.vlassapplication.app.repositories;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;
import com.vlassapplication.app.entities.Kmage;

import java.util.List;

@Dao
public interface KmageDAO {
    @Update
    void updateKmage(Kmage kmage);

    @Query("SELECT * FROM kmage")
    Kmage  getKmage();
}
