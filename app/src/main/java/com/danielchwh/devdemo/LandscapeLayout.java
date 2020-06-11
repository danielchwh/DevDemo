package com.danielchwh.devdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LandscapeLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landscape_layout);

        // set action bar
        getSupportActionBar().setTitle(R.string.save_state_with_mvvm);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}