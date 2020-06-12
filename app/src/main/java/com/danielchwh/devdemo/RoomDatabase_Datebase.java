package com.danielchwh.devdemo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {RoomDatabase_Entity.class}, version = 1, exportSchema = false)
public abstract class RoomDatabase_Datebase extends RoomDatabase {
    public abstract RoomDatabase_Dao getDao();
}
