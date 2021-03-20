package com.ceft.gestionparc.Model;

import java.util.Date;

public class Voiture {

    private int idV;
    private int matricule;
    private Date dateEntrer;
    private Date dateSortie;

    public Voiture(int idV, int matricule, Date dateEntrer, Date dateSortie) {
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

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public Date getDateEntrer() {
        return dateEntrer;
    }

    public void setDateEntrer(Date dateEntrer) {
        this.dateEntrer = dateEntrer;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }
}
