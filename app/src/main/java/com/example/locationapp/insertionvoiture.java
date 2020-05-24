package com.example.locationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class insertionvoiture extends AppCompatActivity {
    private EditText textnom,textmatricule,textcolor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertionvoiture);

        textmatricule=findViewById(R.id.editTextmatricule);
        textnom=findViewById(R.id.editTextcin);
        textcolor=findViewById(R.id.editTextcolor);
    }

    public void insekjbkjbrer(View view) {
        SQLiteDatabase db=DatabaseHelper.getInstance(getApplicationContext()).getWritableDatabase();
        db.execSQL("INSERT INTO voiture (matricule,nom,color) VALUES(?,?,?)",
                new String[]{
                        textmatricule.getText().toString(),
                        textnom.getText().toString(),
                        textcolor.getText().toString()
                });
    }
}
