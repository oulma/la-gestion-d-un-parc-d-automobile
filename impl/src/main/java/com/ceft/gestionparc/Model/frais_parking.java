package com.ceft.gestionparc.Model;

import java.util.ArrayList;

public class frais_parking {


    private int idFrais;
    private double prix;

    public ArrayList<Voiture> voiture;

    public frais_parking(int idFrais, double prix) {
        this.idFrais = idFrais;
        this.prix = prix;
    }

    public int getIdFrais() {
        return idFrais;
    }

    public void setIdFrais(int idFrais) {
        this.idFrais = idFrais;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public ArrayList<Voiture> getVoiture() {
        return voiture;
    }

    public void setVoiture(ArrayList<Voiture> voiture) {
        this.voiture = voiture;
    }
}
