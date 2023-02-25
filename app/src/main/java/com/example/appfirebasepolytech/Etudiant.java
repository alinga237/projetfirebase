package com.example.appfirebasepolytech;

import java.util.Date;

public class Etudiant {
    private String nom;
    private String prenom;
    private Date dateN;
    private Adresse adresse;

    public Etudiant() {
    }

    public Etudiant(String nom, String prenom, Date dateN, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateN = dateN;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateN() {
        return dateN;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateN(Date dateN) {
        this.dateN = dateN;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
