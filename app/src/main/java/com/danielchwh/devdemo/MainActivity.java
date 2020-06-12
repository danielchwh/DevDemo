package com.danielchwh.devdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MainActivity_Adapter adapter;
    private List<MainActivity_Item> allItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Create contents and insert item
        allItems = new ArrayList<MainActivity_Item>();
        allItems.add(new MainActivity_Item(getString(R.string.landscape_layout), getString(R.string.landscape_layout_description)));
        allItems.add(new MainActivity_Item(getString(R.string.save_state), getString(R.string.save_state_description)));
        allItems.add(new MainActivity_Item(getString(R.string.save_state_with_mvvm), getString(R.string.save_state_with_mvvm_description)));
        allItems.add(new MainActivity_Item(getString(R.string.save_preferences), getString(R.string.save_preferences_description)));
        allItems.add(new MainActivity_Item(getString(R.string.timer), getString(R.string.timer_description)));
        allItems.add(new MainActivity_Item(getString(R.string.room_database), getString(R.string.room_database_description)));
        allItems.add(new MainActivity_Item(getString(R.string.navigation), getString(R.string.navigation_description)));
        allItems.add(new MainActivity_Item(getString(R.string.action_bar), getString(R.string.action_bar_description)));

        // Create adpater and link to recyclerView
        adapter = new MainActivity_Adapter(allItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
