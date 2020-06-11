package com.danielchwh.devdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;

public class Timer extends AppCompatActivity {
    private Chronometer chronometer1, chronometer2;
    private long elapsedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        chronometer1 = findViewById(R.id.chronometer1);
        chronometer2 = findViewById(R.id.chronometer2);
        chronometer1.setBase(SystemClock.elapsedRealtime());
        chronometer2.setBase(SystemClock.elapsedRealtime());
        chronometer2.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // save elapsed time after pause
        elapsedTime = SystemClock.elapsedRealtime() - chronometer1.getBase();
        chronometer1.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // update base of timer
        chronometer1.setBase(SystemClock.elapsedRealtime() - elapsedTime);
        chronometer1.start();
    }
}