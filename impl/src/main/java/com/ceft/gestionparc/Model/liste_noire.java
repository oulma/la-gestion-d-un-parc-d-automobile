package com.ceft.gestionparc.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class liste_noire {
      private SimpleStringProperty  Matricule;
    private SimpleStringProperty Marque;
    private SimpleStringProperty Etat;

        public liste_noire(String matricule, String marque, String etat) {
            this.Matricule = new SimpleStringProperty(matricule);
            this.Marque = new SimpleStringProperty(marque);
            this.Etat = new SimpleStringProperty(etat);
        }

    public String getMatricule() {
        return Matricule.get();
    }

    public SimpleStringProperty matriculeProperty() {
        return Matricule;
    }

    public void setMatricule(String matricule) {
        this.Matricule.set(matricule);
    }

    public String getMarque() {
        return Marque.get();
    }

    public SimpleStringProperty marqueProperty() {
        return Marque;
    }

    public void setMarque(String marque) {
        this.Marque.set(marque);
    }

    public String getEtat() {
        return Etat.get();
    }

    public SimpleStringProperty etatProperty() {
        return Etat;
    }

    public void setEtat(String etat) {
        this.Etat.set(etat);
    }
}

