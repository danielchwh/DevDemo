package com.danielchwh.devdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class GsonDemo extends AppCompatActivity {

    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private TextView textView11;
    private TextView textView12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson_demo);

        // Set action bar title
        getSupportActionBar().setTitle(R.string.gson);

        Button button = findViewById(R.id.button_Gson);
        textView7 = findViewById(R.id.textView7_Gson);
        textView8 = findViewById(R.id.textView8_Gson);
        textView9 = findViewById(R.id.textView9_Gson);
        textView10 = findViewById(R.id.textView10_Gson);
        textView11 = findViewById(R.id.textView11_Gson);
        textView12 = findViewById(R.id.textView12_Gson);

        String url = "http://api.openweathermap.org/data/2.5/weather?id=1821274&units=metric&appid=a552f7e6b06e918884ad937269210ba2";
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(
                StringRequest.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        update(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queue.add(stringRequest);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("temp", textView7.getText().toString());
        outState.putString("feels_like", textView8.getText().toString());
        outState.putString("temp_max", textView9.getText().toString());
        outState.putString("temp_min", textView10.getText().toString());
        outState.putString("pressure", textView11.getText().toString());
        outState.putString("humidity", textView12.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textView7.setText(savedInstanceState.getString("temp"));
        textView8.setText(savedInstanceState.getString("feels_like"));
        textView9.setText(savedInstanceState.getString("temp_max"));
        textView10.setText(savedInstanceState.getString("temp_min"));
        textView11.setText(savedInstanceState.getString("pressure"));
        textView12.setText(savedInstanceState.getString("humidity"));
    }

    private void update(String response) {
        Gson gson = new Gson();
        Weather weather = gson.fromJson(response, Weather.class);
        WeatherMain weatherMain = weather.weatherMain;
        textView7.setText(weatherMain.temp);
        textView8.setText(weatherMain.feels_like);
        textView9.setText(weatherMain.temp_max);
        textView10.setText(weatherMain.temp_min);
        textView11.setText(weatherMain.pressure);
        textView12.setText(weatherMain.humidity);
    }

    private class Weather {
        @SerializedName("main")
        WeatherMain weatherMain;
    }

    private class WeatherMain {
        String temp;
        String feels_like;
        String temp_min;
        String temp_max;
        String pressure;
        String humidity;
    }
}