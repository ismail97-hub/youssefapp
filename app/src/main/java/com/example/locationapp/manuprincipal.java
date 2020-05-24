package com.example.locationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class manuprincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manuprincipal);
    }

    public void navigationinsertionclient(View view) {
        Intent intet=new Intent(this,insertionclient.class);
        startActivity(intet);
    }
}
