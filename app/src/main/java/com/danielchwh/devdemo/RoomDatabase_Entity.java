package com.danielchwh.devdemo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "RoomDatabase_Entity")
public class RoomDatabase_Entity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "number")
    private int number;

    public RoomDatabase_Entity(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
