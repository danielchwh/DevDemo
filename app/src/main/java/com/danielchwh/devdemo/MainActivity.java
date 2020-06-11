package com.danielchwh.devdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

        // Create contents and insert item
        allItems = new ArrayList<ContentsItem>();
        allItems.add(new ContentsItem(getString(R.string.landscape_layout), getString(R.string.landscape_layout_description)));
        allItems.add(new ContentsItem(getString(R.string.save_state), getString(R.string.save_state_description)));
        allItems.add(new ContentsItem(getString(R.string.save_state_with_mvvm), getString(R.string.save_state_with_mvvm_description)));
        allItems.add(new ContentsItem(getString(R.string.save_preferences), getString(R.string.save_preferences_description)));
        allItems.add(new ContentsItem(getString(R.string.timer), getString(R.string.timer_description)));
        allItems.add(new ContentsItem("To be continuous", "..."));
        allItems.add(new ContentsItem("To be continuous", "..."));
        allItems.add(new ContentsItem("To be continuous", "..."));
        allItems.add(new ContentsItem("To be continuous", "..."));

        // Create adpater and link to recyclerView
        contentsAdapter = new ContentsAdapter(allItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(contentsAdapter);
    }
}
