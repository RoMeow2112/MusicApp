package com.example.musicapp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import com.example.musicapp.R;

public class Menu extends AppCompatActivity {

    private DrawerLayout nDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, nDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        nDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }
}