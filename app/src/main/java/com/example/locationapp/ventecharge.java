package com.example.locationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ventecharge extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventecharge);

        getSupportActionBar().setTitle("venteCharge");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void navigattionvente(View view) {
        Intent intent = new Intent(this, vente.class);
        startActivity(intent);
    }

    public void navigationcharge(View view) {
        Intent intent = new Intent(this,Charge.class);
        startActivity(intent);
    }
}
