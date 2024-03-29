package com.danielchwh.devdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SaveState extends AppCompatActivity {
    private TextView textView;
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_state);

        textView = findViewById(R.id.textView_SaveState);
        button1 = findViewById(R.id.button1_SaveState);
        button2 = findViewById(R.id.button2_SaveState);

        // Set action bar title
        getSupportActionBar().setTitle(R.string.save_state);

        // restore from saved state
        if (savedInstanceState != null) {
            textView.setText(savedInstanceState.getString("text"));
        }
        // set text
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(button1.getText());
            }
        });
        // set text
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(button2.getText());
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // save text before rotation
        outState.putString("text", textView.getText().toString());
    }
}
