package com.vlassapplication.app.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "consumables")
public class Consumable {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    private String name;
    private String description;
    private Integer useTime;
    private String moreDescription;

    public Consumable() {
    }

    public Consumable(String name, String description, Integer useTime, String moreDescription) {
        this.name = name;
        this.description = description;
        this.useTime = useTime;
        this.moreDescription = moreDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUseTime() {
        return useTime;
    }

    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
    }

    public String getMoreDescription() {
        return moreDescription;
    }

    public void setMoreDescription(String moreDescription) {
        this.moreDescription = moreDescription;
    }
}