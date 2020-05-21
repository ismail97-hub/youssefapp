package com.example.locationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class insertionvente extends AppCompatActivity {
private EditText matriculev,cinc,dates,hs,datee,heuree,prix,njour,mtpaye,mycredit;
private Button btnenre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertionvente);
        matriculev=findViewById(R.id.editTextmatricule);
        cinc=findViewById(R.id.editTextcin);
        dates=findViewById(R.id.editTextdateso);
        hs=findViewById(R.id.editTextheurs);
        datee=findViewById(R.id.editTextdateent);
        heuree=findViewById(R.id.editTextheurentre);
        prix=findViewById(R.id.editTextprix);
        njour=findViewById(R.id.editTextnbrj);
        mtpaye=findViewById(R.id.editTextmtpaye);
        mycredit=findViewById(R.id.editTextmtcredet);
        btnenre=findViewById(R.id.buttonenre);
        
        
                            SQLiteDatabase db=DatabaseHelper.getInstance(getApplicationContext()).getWritableDatabase();
                    db.execSQL("INSERT INTO vente (matricule,cinc,dates,hs,de,he,prix,njour,mypayee,mycredet) VALUES(?,?,?,?,?,?,?,?,?,?)",
                            new String[]{
                                    matriculev.getText().toString(),
                                    cinc.getText().toString(),
                                    dates.getText().toString(),
                                    hs.getText().toString(),
                                    datee.getText().toString(),
                                    heuree.getText().toString(),
                                    prix.getText().toString(),
                                    njour.getText().toString(),
                                    mtpaye.getText().toString(),
                                    mycredit.getText().toString()
                            });

    }

}
