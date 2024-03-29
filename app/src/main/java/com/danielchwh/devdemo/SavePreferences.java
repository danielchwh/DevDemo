package com.danielchwh.devdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SavePreferences extends AppCompatActivity {
    private TextView textView;
    private Button button1, button2;
    private int num;
    private SharedPreferences shp;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_preferences);

        textView = findViewById(R.id.textView_SavePreferences);
        button1 = findViewById(R.id.button1_SavePreferences);
        button2 = findViewById(R.id.button2_SavePreferences);

        // Set action bar title
        getSupportActionBar().setTitle(R.string.save_preferences);

        // create SharedPreferences and Editor objects
        shp = getPreferences(Context.MODE_PRIVATE);
        editor = shp.edit();

        // restore number from saved preferences
        num = shp.getInt("num", 0);
        textView.setText(String.valueOf(num));

        // plus 1
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num += 1;
                textView.setText(String.valueOf(num));
            }
        });
        // minus 1
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num -= 1;
                textView.setText(String.valueOf(num));
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // save number to saved preferences
        editor.putInt("num", num);
        editor.apply();
    }
}