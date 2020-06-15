package com.danielchwh.devdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class NavigationDrawer extends AppCompatActivity {
    private NavigationView navigationView;
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        Toolbar toolbar = findViewById(R.id.toolbar_NavigationDrawer);
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout_NavigationDrawer);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navigationView_NavigationDrawer);
        navController = Navigation.findNavController(this, R.id.fragment_NavigationDrawer);
        appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigationDrawer_Fragment1, R.id.navigationDrawer_Fragment2)
                .setDrawerLayout(drawerLayout)
                .build();

        // Set up action bar such that it can display title set in navigation graph
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        // Set up bottom navigation bar such that it can preform navigation
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }
}