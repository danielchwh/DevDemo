package com.danielchwh.devdemo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {RoomDatabase_Entity.class}, version = 1, exportSchema = false)
public abstract class RoomDatabase_Datebase extends RoomDatabase {
    private static RoomDatabase_Datebase database;
    static synchronized RoomDatabase_Datebase getDatabase(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(), RoomDatabase_Datebase.class, "RoomDatabase_Datebase")
                    .build();
        }
        return database;
    }
    public abstract RoomDatabase_Dao getDao();
}
