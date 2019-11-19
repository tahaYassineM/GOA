package com.moslih.myapplication.models;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class Etudiant implements Serializable {
    private String nom;
    private String prenom;
    private String email;

    public Etudiant(){}

    public Etudiant(String nom, String prenom, String email){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @NonNull
    @Override
    public String toString() {
        return nom + ", " + prenom + ", " + email;
    }
}
