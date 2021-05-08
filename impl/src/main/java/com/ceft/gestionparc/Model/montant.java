package com.ceft.gestionparc.Model;

public class montant {

    int id;
    String Matricule;
    int Montant;

    public montant(int id , String Matricule, int Montant ) {
        this.id = id;
        this.Matricule= Matricule;
        this.Montant= Montant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return Matricule;
    }

    public void setMatricule(String matricule) {
        Matricule = matricule;
    }


    public int getMontant() {
        return Montant;
    }

    public void setMontant(int montant) {
        Montant = montant;
    }
}
