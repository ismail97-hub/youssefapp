package com.example.locationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        ArrayList<String> listV = databaseHelper.getAllVoitures();
        Spinner sp =(Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinnerlayout,R.id.txt1,listV);
        sp.setAdapter(adapter);

    }

    public void btnajt(View view)
    {
        Intent intent=new Intent(this,ventecharge.class);
        startActivity(intent);
    }

    public void navigation(View view) {

    }
}