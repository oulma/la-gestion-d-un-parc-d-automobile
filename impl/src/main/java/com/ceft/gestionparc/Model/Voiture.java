package com.ceft.gestionparc.Model;

import java.util.Date;

public class Voiture {

    private int idV;
    private String matricule;
    private String dateEntrer;
    private Date dateSortie;

    public Voiture(int idV, String matricule, String dateEntrer) {
        this.idV = idV;
        this.matricule = matricule;
        this.dateEntrer = dateEntrer;
        this.dateSortie = null;
    }

    public Voiture(int idV, String matricule, String dateEntrer, Date dateSortie) {
        this.idV = idV;
        this.matricule = matricule;
        this.dateEntrer = dateEntrer;
        this.dateSortie = dateSortie;
    }


    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDateEntrer() {
        return dateEntrer;
    }

    public void setDateEntrer(String dateEntrer) {
        this.dateEntrer = dateEntrer;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }
}
