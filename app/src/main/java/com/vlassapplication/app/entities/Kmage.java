package com.vlassapplication.app.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "kmage")
public class Kmage {
    @PrimaryKey
    @NonNull
    private Integer id;
    private Integer kmage;

    public Kmage() {
    }

    public Kmage( Integer kmage) {
        this.kmage = kmage;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public Integer getKmage() {
        return kmage;
    }

    public void setKmage(Integer kmage) {
        this.kmage = kmage;
    }
}
