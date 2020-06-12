package com.danielchwh.devdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

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

        database = RoomDatabase_Datebase.getDatabase(this);
        dao = database.getDao();
        updateView();

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = new Random().nextInt(100) + 1;
                RoomDatabase_Entity entity = new RoomDatabase_Entity(number);
                new InsertAsyncTask(dao).execute(entity);
                updateView();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DeleteFirstAsyncTask(dao).execute();
                updateView();
            }
        });
    }

    void updateView() {
        List<RoomDatabase_Entity> list = null;
        try {
            list = new GetAllAsyncTask(dao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text = "";
        for (int i = 0; i < list.size(); i++) {
            RoomDatabase_Entity entity = list.get((i));
            text += "Round " + entity.getId() + ": " + entity.getNumber() + "\n";
        }
        textViewDisplay.setText(text);
    }

    static class InsertAsyncTask extends AsyncTask<RoomDatabase_Entity, Void, Void> {
        private RoomDatabase_Dao dao;

        public InsertAsyncTask(RoomDatabase_Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(RoomDatabase_Entity... roomDatabase_entities) {
            dao.insert(roomDatabase_entities);
            return null;
        }
    }

    static class DeleteFirstAsyncTask extends AsyncTask<Void, Void, Void> {
        private RoomDatabase_Dao dao;

        public DeleteFirstAsyncTask(RoomDatabase_Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteFirst();
            return null;
        }
    }

    static class GetAllAsyncTask extends AsyncTask<Void, Void, List<RoomDatabase_Entity>> {
        private RoomDatabase_Dao dao;

        public GetAllAsyncTask(RoomDatabase_Dao dao) {
            this.dao = dao;
        }

        @Override
        protected List<RoomDatabase_Entity> doInBackground(Void... voids) {
            return dao.getAll();
        }
    }
}