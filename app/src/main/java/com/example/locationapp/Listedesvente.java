package com.example.locationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Listedesvente extends AppCompatActivity {
    private ListView listevente;
    private List<Venteliste> ventes=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listedesvente);
        listevente=findViewById(R.id.ListeView);


        SQLiteDatabase db=DatabaseHelper.getInstance(getApplicationContext()).getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM vente ",null);
        while(cursor.moveToNext())
        {
            Venteliste venteliste=new Venteliste();
            venteliste.setMmatricule(cursor.getString(0));
            venteliste.setDateentree(cursor.getString(4));
            venteliste.setPrix(cursor.getString(6));
            ventes.add(venteliste);
        }
        ArrayAdapter<Venteliste> adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,ventes);
        listevente.setAdapter(adapter);

    }
}
