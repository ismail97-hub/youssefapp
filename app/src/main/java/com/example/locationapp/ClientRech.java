package com.example.locationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ClientRech extends AppCompatActivity {
    private TextView text;
    private EditText editxt;
    private LinearLayout layout0;
    private LinearLayout layout1;
    private TextView txtcin;
    private TextView txtnomcomplet;
    private TextView txtadr;
    private TextView txttel;
    private TextView cin;
    private EditText nom;
    private EditText prenom;
    private EditText adresse;
    private EditText tele;
    private Button valider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_rech);

    text = findViewById(R.id.txtRes);
    editxt =findViewById(R.id.editText8);
    layout0 =findViewById(R.id.lay0);
    layout1 =findViewById(R.id.lay1);
    txtcin = findViewById(R.id.textViewCin);
    txtnomcomplet = findViewById(R.id.textViewNom);
    txtadr = findViewById(R.id.textViewAdresse);
    txttel = findViewById(R.id.textViewTel);
    cin = findViewById(R.id.textCin0);
    nom = findViewById(R.id.editTextnom);
    prenom = findViewById(R.id.editTextprenom);
    adresse = findViewById(R.id.editTextadresse);
    tele = findViewById(R.id.editTexttel);
    valider =findViewById(R.id.buttonVal);
        layout0.setVisibility(LinearLayout.GONE);
        layout1.setVisibility(LinearLayout.GONE);
        valider.setVisibility(LinearLayout.GONE);
    }
    int a =0;
    public void btnRech(View view) {
        SQLiteDatabase db = DatabaseHelper.getInstance(getApplicationContext()).getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM client WHERE cin=?",new String[] { String.valueOf(editxt.getText().toString()) });
        while(cursor.moveToNext())
        {
            a = cursor.getInt(0);
        }
        if(editxt.getText().length()!=0) {
            if (a == 0) {
                text.setText("cette Client n'existe pas");
                layout1.setVisibility(LinearLayout.VISIBLE);
                layout0.setVisibility(LinearLayout.GONE);
                valider.setVisibility(LinearLayout.VISIBLE);
                cin.setText(editxt.getText().toString());
            }
            if (a != 0) {
                text.setText("cette Client deja loyer un voiture");
                layout0.setVisibility(LinearLayout.VISIBLE);
                layout1.setVisibility(LinearLayout.GONE);
                valider.setVisibility(LinearLayout.VISIBLE);
                Cursor cursor2 = db.rawQuery("SELECT cin, nom, prenom, adresse, telephone FROM client WHERE cin=?", new String[]{String.valueOf(editxt.getText().toString())});
                while (cursor2.moveToNext()) {
                    txtcin.setText(txtcin.getText() + " " + cursor2.getString(0));
                    txtnomcomplet.setText(txtnomcomplet.getText() + " " + cursor2.getString(1) + " " + cursor2.getString(2));
                    txtadr.setText(txtadr.getText() + " " + cursor2.getString(3));
                    txttel.setText(txttel.getText() + " " + cursor2.getString(4));
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent();
        i.putExtra("cin",editxt.getText().toString());
        setResult(RESULT_OK,i);
        finish();
    }
    public void btnValider(View view) {
        super.onBackPressed();
    }
}
