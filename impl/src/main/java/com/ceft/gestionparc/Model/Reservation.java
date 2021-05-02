package com.ceft.gestionparc.Model;

import com.ceft.gestionparc.Controller.ReservationController;

import java.time.LocalDate;

public class Reservation extends ReservationController {

    private String idR;
    private String nomR;
    private String CIN;
    private String matricule;
    private String dateEntre;
    private String dateSortie;



    public Reservation(String idR, String CIN, String nomR, String matricule, String dateEntre, String dateSortie) {
        this.idR = idR;
        this.nomR = nomR;
        this.CIN=CIN;
        this.matricule = matricule;
        this.dateEntre = dateEntre;
        this.dateSortie = dateSortie;

    }

    public String getIdR() {
        return idR;
    }



    public void setIdR(String idR) {
        this.idR = idR;
    }

    public String getNomR() {
        return nomR;
    }

    public void setNomR(String nomR) {
        this.nomR = nomR;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDateEntre() {
        return dateEntre;
    }

    public void setDateEntre(String dateEntre) {
        this.dateEntre = dateEntre;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }
}



