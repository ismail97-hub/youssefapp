package com.example.locationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Historique extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
