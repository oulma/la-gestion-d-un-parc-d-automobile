package com.ceft.gestionparc.Model;

import java.util.ArrayList;

public class liste_noire {

        private int type;
        private String description;

        public ArrayList<Voiture> voiture;

    public liste_noire(int type, String description, ArrayList<Voiture> voiture) {
        this.type = type;
        this.description = description;
        this.voiture = voiture;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Voiture> getVoiture() {
        return voiture;
    }

    public void setVoiture(ArrayList<Voiture> voiture) {
        this.voiture = voiture;
    }
}
