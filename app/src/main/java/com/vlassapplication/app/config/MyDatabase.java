package com.vlassapplication.app.config;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.vlassapplication.app.entities.Consumable;
import com.vlassapplication.app.repositories.ConsumableDAO;

@Database(entities = {Consumable.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract ConsumableDAO consumableDAO();
}