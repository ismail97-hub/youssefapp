package com.example.locationapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static DatabaseHelper instance;
    public static synchronized DatabaseHelper getInstance(Context context)
    {
        if (instance==null)
        {
            instance=new DatabaseHelper(context);
        }
        return instance;
    }
    private DatabaseHelper(Context context) {
        super(context, "Location.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE client(" +
                "cin TEXT PRIMARY KEY," +
                "nom TEXT," +
                "prenom TEXT," +
                "adresse TEXT," +
                "telephone TEXT)");
        db.execSQL("CREATE TABLE voiture(" +
                "matricule TEXT PRIMARY KEY," +
                "nom TEXT," +
                "color TEXT)");
        db.execSQL("CREATE TABLE vente(" +
                "matriculev INTEGER," +
                "cinc TEXT," +
                "datesortie TEXT," +
                "heuresort TEXT ," +
                "dateentree TEXT," +
                "heureent," +
                "prixjours," +
                "njours," +
                "mtpayes," +
                "mtcredit," +
                "FOREIGN KEY(matriculev) REFERENCES voiture(matricule)," +
                "FOREIGN KEY(cinc) REFeRENCES client(cin)," +
                "PRIMARY KEY(matriculev,cinc,datesortie))");
        db.execSQL("CREATE TABLE charge(id INTEGER PRIMARY KEY," +
                "datec TEXT," +
                "motif TEXT," +
                "prixc INTEGER," +
                "matriculevt TEXT," +
                "FOREIGN KEY(matriculevt) REFERENCES voiture(matricule)) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
             db.execSQL("DROP TABLE IF EXISTS client");
             db.execSQL("DROP TABLE IF EXISTS voiture");
             db.execSQL("DROP TABLE IF EXISTS vente");
             db.execSQL("DROP TABLE IF EXISTS charge");
             onCreate(db);
    }
}
