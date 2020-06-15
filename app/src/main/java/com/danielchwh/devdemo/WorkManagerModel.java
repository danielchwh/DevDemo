package com.danielchwh.devdemo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class WorkManagerModel extends Worker {
    private Context context;

    public WorkManagerModel(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        // Customize your task here
        createNotification();
        return Result.success();
    }

    // Create a simple notification
    private void createNotification() {
        NotificationManager notificationManager = (NotificationManager) this.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("WorkManagerDemo", "Work Manager Demo", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this.getApplicationContext(), "WorkManagerDemo")
                .setContentTitle("Work Manager Demo")
                .setContentText("Work Manager is running")
                .setSmallIcon(R.drawable.ic_launcher_foreground);
        notificationManager.notify((int) SystemClock.uptimeMillis(), notificationBuilder.build());
    }
}
