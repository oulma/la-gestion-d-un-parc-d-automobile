package com.ceft.gestionparc.Model;

import com.ceft.gestionparc.DbConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Parking {

    private int idPark;
    private String seriePark;
    private int placePark;
    private int placeOccupé;
    public ArrayList<Voiture> voiture;

    public int getPlaceOccupé() throws SQLException, ClassNotFoundException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectionDuBd();
        String countHowManyCarInPark = "SELECT COUNT(*) FROM voiturein";
        Statement statement = connectDB.createStatement();
        ResultSet rs = statement.executeQuery(countHowManyCarInPark);
        placeOccupé = rs.getInt(1);
        return placeOccupé;  }

    public void setPlaceOccupé(int placeOccupé) {this.placeOccupé = placeOccupé; }

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
