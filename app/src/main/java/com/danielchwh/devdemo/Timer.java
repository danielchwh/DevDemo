package com.danielchwh.devdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.MenuItem;
import android.widget.Chronometer;

public class Timer extends AppCompatActivity {
    private Chronometer chronometer1, chronometer2;
    private long elapsedTime;
    private boolean isRestored = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        // set action bar
        getSupportActionBar().setTitle(R.string.timer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        chronometer1 = findViewById(R.id.chronometer1_Timer);
        chronometer2 = findViewById(R.id.chronometer2_Timer);

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
        if (isRestored == false) {
            chronometer1.setBase(SystemClock.elapsedRealtime() - elapsedTime);
        }
        chronometer1.start();
        isRestored = false;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // save state
        outState.putLong("timer1", chronometer1.getBase());
        outState.putLong("timer2", chronometer2.getBase());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // restore state
        chronometer1.setBase(savedInstanceState.getLong("timer1"));
        chronometer2.setBase(savedInstanceState.getLong("timer2"));
        isRestored = true;
    }

    // action bar back button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}