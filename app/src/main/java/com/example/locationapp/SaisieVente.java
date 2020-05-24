package com.example.locationapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class SaisieVente extends AppCompatActivity {
    private TextView cin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie_vente);

        cin = findViewById(R.id.textView5);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        ArrayList<String> listV = databaseHelper.getAllVoitures();
        Spinner sp =(Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinnerlayout,R.id.txt1,listV);
        sp.setAdapter(adapter);
    }

    public void btnClientplus(View view) {
        startActivityForResult(new Intent(getApplicationContext(),ClientRech.class),999);
        //startActivity(new Intent(this,ClientRech.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==999 && resultCode==RESULT_OK)
        {
            cin.setText(data.getStringExtra("cin"));
        }
    }
}
