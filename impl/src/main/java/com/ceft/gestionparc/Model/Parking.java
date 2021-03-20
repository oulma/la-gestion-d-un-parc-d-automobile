package com.ceft.gestionparc.Model;

import java.util.ArrayList;

public class Parking {

    private int idPark;
    private String seriePark;
    private int placePark;

    public ArrayList<Voiture> voiture;


    public int getIdPark() {
        return idPark;
    }

    public void setIdPark(int idPark) {
        this.idPark = idPark;
    }

    public String getSeriePark() {
        return seriePark;
    }

    public void setSeriePark(String seriePark) {
        this.seriePark = seriePark;
    }

    public int getPlacePark() {
        return placePark;
    }

    public void setPlacePark(int placePark) {
        this.placePark = placePark;
    }

    public ArrayList<Voiture> getVoiture() {
        return voiture;
    }

    public void setVoiture(ArrayList<Voiture> voiture) {
        this.voiture = voiture;
    }

    public Parking(int idPark, String seriePark, int placePark) {
        this.idPark = idPark;
        this.seriePark = seriePark;
        this.placePark = placePark;
    }
}
