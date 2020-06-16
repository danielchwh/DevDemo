package com.danielchwh.devdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        allItems.add(new MainActivity_Item(getString(R.string.bottom_navigation), getString(R.string.bottom_navigation_description)));
        allItems.add(new MainActivity_Item(getString(R.string.animator), getString(R.string.animator_description)));
        allItems.add(new MainActivity_Item(getString(R.string.work_manager), getString(R.string.work_manager_description)));
        allItems.add(new MainActivity_Item(getString(R.string.navigation_drawer), getString(R.string.navigation_drawer_description)));
        allItems.add(new MainActivity_Item(getString(R.string.swipe_refresh), getString(R.string.swipe_refresh_description)));

        // Create adapter and link to recyclerView
        adapter = new MainActivity_Adapter(allItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
