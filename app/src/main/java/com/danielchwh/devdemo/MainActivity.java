package com.danielchwh.devdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ContentsAdapter contentsAdapter;
    private List<ContentsItem> allItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        allItems = new ArrayList<ContentsItem>();
        allItems.add(new ContentsItem(getString(R.string.landscape_layout), "..."));
        allItems.add(new ContentsItem(getString(R.string.save_state), "..."));
        allItems.add(new ContentsItem(getString(R.string.save_state_with_mvvm), "..."));
        allItems.add(new ContentsItem(getString(R.string.save_preferences), "..."));
        allItems.add(new ContentsItem(getString(R.string.timer), "..."));
        allItems.add(new ContentsItem("To be continuous", "..."));

        contentsAdapter = new ContentsAdapter(this, allItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(contentsAdapter);
    }
}
