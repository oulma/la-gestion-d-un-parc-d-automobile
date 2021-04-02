package com.ceft.gestionparc.Model;

import java.util.ArrayList;

public class Utilisateur {


    private int idU;
    private String serieU;
    private String nomU;
    private String motPasse;
    private String emailU;

    public ArrayList<Voiture> voiture;
    public ArrayList<Reservation> reservation;
    public ArrayList<Parking> parking;


    public Utilisateur(int idU, String serieU, String nomU, String motPasse, String emailU) {
        this.idU = idU;
        this.serieU = serieU;
        this.nomU = nomU;
        this.motPasse = motPasse;
        this.emailU = emailU;
        this.voiture = voiture;
        this.reservation = reservation;
        this.parking = parking;
    }


    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public String getSerieU() {
        return serieU;
    }

    public void setSerieU(String serieU) {
        this.serieU = serieU;
    }

    public String getNomU() {
        return nomU;
    }

    public void setNomU(String nomU) {
        this.nomU = nomU;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public String getEmailU() { return emailU; }

    public void setEmailU(String emailU) {
        this.emailU = emailU;
    }

    public ArrayList<Voiture> getVoiture() {
        return voiture;
    }

    public void setVoiture(ArrayList<Voiture> voiture) {
        this.voiture = voiture;
    }

    public ArrayList<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(ArrayList<Reservation> reservation) {
        this.reservation = reservation;
    }

    public ArrayList<Parking> getParking() {
        return parking;
    }

    public void setParking(ArrayList<Parking> parking) {
        this.parking = parking;
    }




    }




