package com.ceft.gestionparc.Model;

import java.util.Date;

public class Reservation {

    private int idR;
    private String nomR;
    private String matricule;
    private Date dateEntre;
    private Date dateSortie;


    public Reservation(int idR, String nomR, String matricule, Date dateEntre, Date dateSortie) {
        this.idR = idR;
        this.nomR = nomR;
        this.matricule = matricule;
        this.dateEntre = dateEntre;
        this.dateSortie = dateSortie;
    }


    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getNomR() {
        return nomR;
    }

    public void setNomR(String nomR) {
        this.nomR = nomR;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Date getDateEntre() {
        return dateEntre;
    }

    public void setDateEntre(Date dateEntre) {
        this.dateEntre = dateEntre;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }
}
