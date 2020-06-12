package com.danielchwh.devdemo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao // Dao = Database access object
public interface RoomDatabase_Dao {
    @Insert
    void insert(RoomDatabase_Entity... roomDatabase_entities);

    // Never use in this app, just for reference
    @Update // Return number of updated row
    int update(RoomDatabase_Entity... roomDatabase_entities);

    // Never use in this app, just for reference
    @Delete
    void delete(RoomDatabase_Entity... roomDatabase_entities);

    @Query("DELETE FROM RoomDatabase_Entity WHERE ID IN (SELECT ID FROM RoomDatabase_Entity ORDER BY ID ASC LIMIT 1)")
    void deleteFirst();

    @Query("SELECT * FROM RoomDatabase_Entity ORDER BY ID DESC")
    List<RoomDatabase_Entity> getAll();
}
