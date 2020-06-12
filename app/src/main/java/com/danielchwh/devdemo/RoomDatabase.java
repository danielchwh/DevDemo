package com.danielchwh.devdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class RoomDatabase extends AppCompatActivity {
    RoomDatabase_Datebase database;
    RoomDatabase_Dao dao;
    Button buttonInsert, buttonDelete;
    TextView textViewDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_database);

        buttonInsert = findViewById(R.id.buttonInsert);
        buttonDelete = findViewById(R.id.buttonDelete);
        textViewDisplay = findViewById(R.id.textViewDisplay);

        database = Room.databaseBuilder(this, RoomDatabase_Datebase.class, "RoomDatabase_Datebase")
                .allowMainThreadQueries().build();
        dao = database.getDao();
        updateView();

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = new Random().nextInt(100) + 1;
                RoomDatabase_Entity entity = new RoomDatabase_Entity(number);
                dao.insert(entity);
                updateView();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.deleteFirst();
                updateView();
            }
        });
    }

    void updateView() {
        List<RoomDatabase_Entity> list = dao.getAll();
        String text = "";
        for (int i = 0; i < list.size(); i++) {
            RoomDatabase_Entity entity = list.get((i));
            text += "Round " + entity.getId() + ": " + entity.getNumber() + "\n";
        }
        textViewDisplay.setText(text);
    }
}