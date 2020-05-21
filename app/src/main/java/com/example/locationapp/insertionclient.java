package com.example.locationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class insertionclient extends AppCompatActivity {
private EditText textcin,textnom,textprenom,textadress,texttele;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertionclient);
        textcin=findViewById(R.id.editTextmatriculev);
        textnom=findViewById(R.id.editTextcin);
        textprenom=findViewById(R.id.editTextdatesortie);
        textadress=findViewById(R.id.editTextdateso);
        texttele=findViewById(R.id.editTextheurs);




    }






    public void insertionn(View view) {
        SQLiteDatabase db=DatabaseHelper.getInstance(getApplicationContext()).getWritableDatabase();
        db.execSQL("INSERT INTO client (cin,nom,prenom,adresse,telephone) VALUES(?,?,?,?,?)",
                new String[]{
                        textcin.getText().toString(),
                        textnom.getText().toString(),
                        textprenom.getText().toString(),
                        textadress.getText().toString(),
                        texttele.getText().toString(),
                });
    }}
