package com.danielchwh.devdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import java.util.concurrent.TimeUnit;

public class WorkManagerDemo extends AppCompatActivity {
    WorkManager workManager = WorkManager.getInstance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manager);

        // Set action bar title
        getSupportActionBar().setTitle(R.string.work_manager);

        // Enqueue work
        Button button1 = findViewById(R.id.button1_WorkManager);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(WorkManagerModel.class)
                        .setInitialDelay(3, TimeUnit.SECONDS)
                        .addTag("workRequest1")
                        .build();
                workManager.enqueueUniqueWork("workRequest1", ExistingWorkPolicy.APPEND, workRequest);
            }
        });
    }
}