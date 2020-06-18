package com.danielchwh.devdemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.LruCache;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

public class VolleyDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        NetworkImageView imageView = findViewById(R.id.imageView_Volley);
        Button button1 = findViewById(R.id.button1_Volley);
        Button button2 = findViewById(R.id.button2_Volley);
        Button button3 = findViewById(R.id.button3_Volley);

        // Set image url
        String url1 = "https://cdn.pixabay.com/photo/2020/06/05/01/28/compass-5261062_960_720.jpg";
        String url2 = "https://cdn.pixabay.com/photo/2016/09/08/22/43/books-1655783_960_720.jpg";
        String url3 = "https://cdn.pixabay.com/photo/2020/06/08/03/55/feather-5272833_960_720.jpg";

        // Set image loader
        RequestQueue queue = Volley.newRequestQueue(this);
        ImageLoader imageLoader = new ImageLoader(queue, new ImageLoader.ImageCache() {
            private LruCache<String, Bitmap> cache = new LruCache<>(3);

            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }
        });

        // Set button click event
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageUrl(url1, imageLoader);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageUrl(url2, imageLoader);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageUrl(url3, imageLoader);
            }
        });
    }
}