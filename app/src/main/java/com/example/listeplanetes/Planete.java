package com.example.listeplanetes;

public class Planete {

   private String nom;
   private String taille;

   public Planete(){

   }

    public Planete(String nom, String taille) {
        this.nom = nom;
        this.taille = taille;
    }

    public String getNom() {
        return nom;
    }

    public String getTaille() {
        return taille;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }
}
