package com.danielchwh.devdemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.Random;

public class SwipeRefresh extends AppCompatActivity {
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);

        // Set action bar title
        getSupportActionBar().setTitle(R.string.swipe_refresh);

        textView2 = findViewById(R.id.textView2_SwipeRefresh);
        SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout_SwipeRefresh);

        // Refresh the random number when swipe down
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                textView2.setText(String.valueOf(new Random().nextInt(100) + 1));
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("number", textView2.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textView2.setText(savedInstanceState.getString("number"));
    }
}