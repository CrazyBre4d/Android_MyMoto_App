package com.vlassapplication.app.repositories;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.vlassapplication.app.entities.Consumable;

import java.util.List;

@Dao
public interface ConsumableDAO {
    @Insert
    void addConsumable(Consumable consumable);

    @Query("SELECT * FROM consumables")
    List<Consumable> getAllConsumables();
}
