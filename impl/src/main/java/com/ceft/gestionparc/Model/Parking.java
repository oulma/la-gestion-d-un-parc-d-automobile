package com.ceft.gestionparc.Model;

import com.ceft.gestionparc.DbConnection.DatabaseConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Parking {

    private int idPark;
    private String seriePark;
    private int placePark;
    private static int placeParkMax=100;
    public ArrayList<Voiture> voiture;

 public Parking(){ }

    public void SQLajouterVoiture() throws SQLException, ClassNotFoundException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectionDuBd();
        String countHowManyCarInPark = "SELECT * FROM voiture";
        Statement statement = connectDB.createStatement();
        ResultSet rs = statement.executeQuery(countHowManyCarInPark);

        while (rs.next()){
            Voiture v =new Voiture(rs.getString("matricule"),rs.getString("date_dentrer"));
            ajouterVoiture(v);
        }
    }
    public int ajouterVoiture(Voiture v)
    {   if(placePark<=placeParkMax){
        ArrayList<Voiture> voitures = new ArrayList<>();
        placePark++;
        voitures.add(v);
        return 1;
    }else{
        return 0;
    }
    }
    public int nomberVoiture(){
        return placePark;
    }

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

    public int getPlaceParkMax() {
        return placeParkMax;
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
