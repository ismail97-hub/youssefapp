package com.example.locationapp;

public class Venteliste {
    private String mmatricule;
    private String dateentree;
    private String prix;

    public String getMmatricule() {
        return mmatricule;
    }

    public void setMmatricule(String mmatricule) {
        this.mmatricule = mmatricule;
    }

    public String getDateentree() {
        return dateentree;
    }

    public void setDateentree(String dateentree) {
        this.dateentree = dateentree;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public Venteliste(String mmatricule, String dateentree, String prix) {
        this.mmatricule = mmatricule;
        this.dateentree = dateentree;
        this.prix = prix;
    }

    public Venteliste() {
    }
}
