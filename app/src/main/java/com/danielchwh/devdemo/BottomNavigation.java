package com.danielchwh.devdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView_BottomNavigation);
        NavController navController = Navigation.findNavController(this, R.id.fragment_BottomNavigation);

        // Set up action bar such that it can display title set in navigation graph
        AppBarConfiguration configuration = new AppBarConfiguration.Builder(bottomNavigationView.getMenu()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, configuration);
        // Set up bottom navigation bar such that it can preform navigation
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    public void onBackPressed() {
        // When button pressed, finish activity rather than go back to previous fragment
        NavController navController = Navigation.findNavController(this, R.id.fragment_BottomNavigation);
        if (navController.getCurrentDestination().getId() != navController.getGraph().getStartDestination())
            finish();
        else
            super.onBackPressed();
    }


}
