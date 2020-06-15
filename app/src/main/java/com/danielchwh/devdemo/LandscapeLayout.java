package com.danielchwh.devdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LandscapeLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landscape_layout);

        // Set action bar title
        getSupportActionBar().setTitle(R.string.landscape_layout);
    }
}