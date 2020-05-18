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
    private List<Voiture> voitures=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner2);




        SQLiteDatabase db=DatabaseHelper.getInstance(getApplicationContext()).getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM voiture",null);
        while (cursor.moveToNext())
        {
            Voiture voiture=new Voiture();
           voiture.setMatricule(cursor.getInt(1));
           voiture.setNom(cursor.getString(2));
           voitures.add(voiture);
        }
         ArrayAdapter<Voiture>adapter=new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,voitures);
        spinner.setAdapter(adapter);
    }

    public void btnajt(View view)
    {
        DatabaseHelper.getInstance(getApplicationContext()).getWritableDatabase();

    }

    public void navigation(View view) {
        Intent intent = new Intent(this, ventecharge.class);
        startActivity(intent);
    }
}