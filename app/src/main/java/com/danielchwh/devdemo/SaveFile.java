package com.danielchwh.devdemo;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class SaveFile extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_file);

        // Set action bar title
        getSupportActionBar().setTitle(R.string.save_file);

        Button button = findViewById(R.id.button_SaveFile);
        imageView = findViewById(R.id.imageView_SaveFile);

        // Click save button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // For version < Android M, permission require should be written in AndroidManifest
                // For version >= Android Q, save image doesn't require permission
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                        && Build.VERSION.SDK_INT < Build.VERSION_CODES.Q
                        && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                } else {
                    // Already have permission, save image now
                    saveImage();
                }
            }
        });
    }

    // Response for first time to ask for permission
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted
                saveImage();
            } else {
                // Permission is denied
                Toast.makeText(this, "Not permission", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void saveImage() {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            OutputStream fos;
            try {
                ContentResolver resolver = getContentResolver();
                ContentValues contentValues = new ContentValues();
                Uri imageUri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                fos = resolver.openOutputStream(imageUri);
                if (bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)) {
                    Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Save image failed", Toast.LENGTH_SHORT).show();
                }
                fos.flush();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "", "") == null) {
                Toast.makeText(this, "Save image failed", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
            }
        }
    }
}