package com.danielchwh.devdemo;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Animator extends AppCompatActivity {

    private ImageView imageView;
    private Button button1, button2, button3, button4, button5, button6, button7;
    // Using relative position rather than absolute position because resolution is changed after screen rotaton
    private float dX = 0, dY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);

        // Set action bar title
        getSupportActionBar().setTitle(R.string.animator);

        imageView = findViewById(R.id.imageView_Animator);
        button1 = findViewById(R.id.button1_Animator);
        button2 = findViewById(R.id.button2_Animator);
        button3 = findViewById(R.id.button3_Animator);
        button4 = findViewById(R.id.button4_Animator);
        button5 = findViewById(R.id.button5_Animator);
        button6 = findViewById(R.id.button6_Animator);
        button7 = findViewById(R.id.button7_Animator);

        // Set up ObjectAnimator
        ObjectAnimator rotation = ObjectAnimator.ofFloat(imageView, "rotation", 0, 0);
        rotation.setDuration(500);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 0, 0);
        scaleX.setDuration(500);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 0, 0);
        scaleY.setDuration(500);
        ObjectAnimator moveX = ObjectAnimator.ofFloat(imageView, "x", 0, 0);
        moveX.setDuration(500);
        ObjectAnimator moveY = ObjectAnimator.ofFloat(imageView, "y", 0, 0);
        moveY.setDuration(500);

        // Rotation
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!rotation.isRunning()) {
                    rotation.setFloatValues(imageView.getRotation(), imageView.getRotation() + 180);
                    rotation.start();
                }
            }
        });
        // Move up
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!moveY.isRunning()) {
                    moveY.setFloatValues(imageView.getY(), imageView.getY() - 64);
                    dY -= 64;
                    moveY.start();
                }
            }
        });
        // Move down
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!moveY.isRunning()) {
                    moveY.setFloatValues(imageView.getY(), imageView.getY() + 64);
                    dY += 64;
                    moveY.start();
                }
            }
        });
        // Move left
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!moveX.isRunning()) {
                    moveX.setFloatValues(imageView.getX(), imageView.getX() - 64);
                    dX -= 64;
                    moveX.start();
                }
            }
        });
        // Move right
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!moveX.isRunning()) {
                    moveX.setFloatValues(imageView.getX(), imageView.getX() + 64);
                    dX += 64;
                    moveX.start();
                }
            }
        });
        // Scale up
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!scaleX.isRunning()) {
                    scaleX.setFloatValues(imageView.getScaleX(), imageView.getScaleX() + 0.5f);
                    scaleY.setFloatValues(imageView.getScaleY(), imageView.getScaleY() + 0.5f);
                    scaleX.start();
                    scaleY.start();
                }
            }
        });
        // Scale down
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!scaleX.isRunning()) {
                    scaleX.setFloatValues(imageView.getScaleX(), imageView.getScaleX() - 0.5f);
                    scaleY.setFloatValues(imageView.getScaleY(), imageView.getScaleY() - 0.5f);
                    scaleX.start();
                    scaleY.start();
                }
            }
        });
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // save data
        outState.putFloat("rotation", imageView.getRotation());
        outState.putFloat("dX", dX);
        outState.putFloat("dY", dY);
        outState.putFloat("scaleX", imageView.getScaleX());
        outState.putFloat("scaleY", imageView.getScaleY());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // restore data
        imageView.setRotation(savedInstanceState.getFloat("rotation"));
        imageView.setX(imageView.getX() + savedInstanceState.getFloat("dX"));
        imageView.setY(imageView.getY() + savedInstanceState.getFloat("dY"));
        imageView.setScaleX(savedInstanceState.getFloat("scaleX"));
        imageView.setScaleY(savedInstanceState.getFloat("scaleY"));
    }
}