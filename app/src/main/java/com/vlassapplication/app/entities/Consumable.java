package com.vlassapplication.app.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "consumables")
public class Consumable {
    @PrimaryKey(autoGenerate = true)
    public Long id;

    public String name;
    public String description;
    public Integer useTime;
    public String moreDescription;

    public Consumable(String name, String description, Integer useTime, String moreDescription) {
        this.name = name;
        this.description = description;
        this.useTime = useTime;
        this.moreDescription = moreDescription;
    }
}