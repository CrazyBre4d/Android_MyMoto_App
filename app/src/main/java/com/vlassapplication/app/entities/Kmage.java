package com.vlassapplication.app.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "kmage")
public class Kmage {
    @PrimaryKey
    @NonNull
    private String kmage;

    public Kmage() {
    }

    public Kmage(@NonNull String  kmage) {
        this.kmage = kmage;
    }

    public String  getKmage() {
        return kmage;
    }

    public void setKmage(String  kmage) {
        this.kmage = kmage;
    }
}
