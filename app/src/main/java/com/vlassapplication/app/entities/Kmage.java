package com.vlassapplication.app.entities;

import androidx.room.Entity;

@Entity(tableName = "kmage")
public class Kmage {
    private Integer kmage;

    public Kmage() {
    }

    public Kmage(Integer kmage) {
        this.kmage = kmage;
    }

    public Integer getKmage() {
        return kmage;
    }

    public void setKmage(Integer kmage) {
        this.kmage = kmage;
    }
}
