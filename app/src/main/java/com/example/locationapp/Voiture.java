package com.example.locationapp;

public class Voiture {
    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Voiture(int matricule, String nom, String color) {
        this.matricule = matricule;
        this.nom = nom;
        this.color = color;
    }

    private int matricule;
    private String nom;
   private String color;

    public Voiture() {
    }
}
