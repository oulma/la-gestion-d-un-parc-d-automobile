package com.ceft.gestionparc.Model;

import com.ceft.gestionparc.Controller.Archive;
import com.ceft.gestionparc.DbConnection.DatabaseConnection;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.Date;



public class Voiture {

    private IntegerProperty idVProperty;
    private StringProperty matriculeProperty;
    private StringProperty nomProperty;
    private StringProperty dateEntrerProperty;

    private int idV;
    private String matricule;
    private String nom;
    private String dateEntrer;

    private Date dateSortie;

    public Voiture(int idV, String matricule, String dateEntrer) {
        this.idV = idV;
        this.matricule = matricule;
        this.dateEntrer = dateEntrer;
    }


//getter setter for idVProperty voiture

    public int getIdVProperty() {
        return idVProperty.get();
    }
    public void setIdVProperty(int idV) {
        this.idVProperty.set(idV);
    }
    public IntegerProperty getIdVProperty1() {
        return idVProperty;
    }
    //getter setter de la date


    //getter setter for MatriculeProperty voiture

    public void setMatriculeProperty(String matricule) {
        this.matriculeProperty.set(matricule);
    }

    public String getMatriculeProperty() {
        return matriculeProperty.get();
    }

    public StringProperty getMatriculeProperty1() {
        return matriculeProperty;
    }
    //getter setter for NomProperty voiture
    public void setNomProperty(String nom) {
        this.nomProperty.set(nom);
    }

    public String getnomProperty() {
        return nomProperty.get();
    }

    public StringProperty nomPropertyProperty() {
        return nomProperty;
    }

    //--------------test----------------------------------//
    public void setdateEntrerProperty(String nom2) {
        this.dateEntrerProperty.set(nom2);
    }
    public String getdateEntrerProperty() {
        return dateEntrerProperty.get();
    }

    public StringProperty dateEntrerProperty1() {
        return dateEntrerProperty;
    }

    //----------------------------------------------------//
    public Voiture() {
        this.idVProperty = new SimpleIntegerProperty();
        this.matriculeProperty = new SimpleStringProperty();
        this.nomProperty = new SimpleStringProperty();
        this.dateEntrerProperty = new SimpleStringProperty();
    }


    //pour la class voiture en genaral

    public Voiture(int idV, String matricule, String nom, String dateEntrer, Date dateSortie) {
        this.idV = idV;
        this.matricule = matricule;
        this.nom = nom;
        this.dateEntrer = dateEntrer;
        this.dateSortie = dateSortie;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    //getting the data from the database SQL

    public static ObservableList<Voiture> getArchive() throws ClassNotFoundException, SQLException {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectionDuBd();

        String SqlgetArchive = "select * from voiture";

        Statement st = connectDB.createStatement();
        ResultSet rs = st.executeQuery(SqlgetArchive);
        ObservableList<Voiture> VoiList = getVoitureObject(rs);

        return VoiList;

    }
    // se method renvoir remplire le ObservableList<Voiture>
    private static ObservableList<Voiture> getVoitureObject(ResultSet rs) throws SQLException {
        ObservableList<Voiture> VoiList = FXCollections.observableArrayList();
        while (rs.next()){
            Voiture voiture =new Voiture();
            voiture.setIdVProperty(rs.getInt(1));
            voiture.setMatriculeProperty(rs.getString(2));
            voiture.setNomProperty(rs.getString(3));
            voiture.setdateEntrerProperty(rs.getString(4));

            VoiList.add(voiture);
        }
        return VoiList;
    }


    //--------------------------------------- Pour la Recherche par Id --------------------------------------------------//
    public static ObservableList<Voiture> getArchiveFromCherche(int ID) throws ClassNotFoundException, SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectionDuBd();
        // le problem dans le recherchr


        String SqlgetArchive = "select * from voiture where id="+ID;


        Statement st = connectDB.createStatement();
        ResultSet rsId = st.executeQuery(SqlgetArchive);
        ObservableList<Voiture> VoiList = getVoitureObjectbyId(rsId);

        return VoiList;
    }

    private static ObservableList<Voiture> getVoitureObjectbyId(ResultSet rsId) throws SQLException {
        ObservableList<Voiture> VoiList = FXCollections.observableArrayList();
        while (rsId.next()){
            Voiture voiture =new Voiture();
            voiture.setIdVProperty(rsId.getInt(1));
            voiture.setMatriculeProperty(rsId.getString(2));
            voiture.setNomProperty(rsId.getString(3));
            voiture.setdateEntrerProperty(rsId.getString(4));

            VoiList.add(voiture);
        }
        return VoiList;
    }
    //--------------------------------------- Pour la Recherche par Matricule --------------------------------------------------//
    public static ObservableList<Voiture> getArchiveFromCherche1(String matricule) throws ClassNotFoundException, SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectionDuBd();



        String SqlgetArchive = "select * from voiture where matricule LIKE lower ('"+matricule+"%')";


        Statement st = connectDB.createStatement();
        ResultSet rsmatricule = st.executeQuery(SqlgetArchive);
        ObservableList<Voiture> VoiList = getVoitureObjectbymatricule(rsmatricule);

        return VoiList;
    }
    private static ObservableList<Voiture> getVoitureObjectbymatricule(ResultSet rsmatricule) throws SQLException {
        ObservableList<Voiture> VoiList = FXCollections.observableArrayList();
        while (rsmatricule.next()){
            Voiture voiture =new Voiture();
            voiture.setIdVProperty(rsmatricule.getInt(1));
            voiture.setMatriculeProperty(rsmatricule.getString(2));
            voiture.setNomProperty(rsmatricule.getString(3));
            voiture.setdateEntrerProperty(rsmatricule.getString(4));

            VoiList.add(voiture);
        }
        return VoiList;
    }
    //--------------------------------------- Pour la Recherche par Nom --------------------------------------------------//
    public static ObservableList<Voiture> getArchiveFromCherche2(String Nom) throws ClassNotFoundException, SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectionDuBd();



        String SqlgetArchive = "select * from voiture where nom LIKE lower ('"+Nom+"%')";


        Statement st = connectDB.createStatement();
        ResultSet rsNom = st.executeQuery(SqlgetArchive);
        ObservableList<Voiture> VoiList = getVoitureObjectbyNom(rsNom);

        return VoiList;
    }
    private static ObservableList<Voiture> getVoitureObjectbyNom(ResultSet rsNom) throws SQLException {
        ObservableList<Voiture> VoiList = FXCollections.observableArrayList();
        while (rsNom.next()){
            Voiture voiture =new Voiture();
            voiture.setIdVProperty(rsNom.getInt(1));
            voiture.setMatriculeProperty(rsNom.getString(2));
            voiture.setNomProperty(rsNom.getString(3));
            voiture.setdateEntrerProperty(rsNom.getString(4));

            VoiList.add(voiture);
        }
        return VoiList;
    }
    //------------------------------------- Pour la Recherche par Date ------------------------------------------------//
    public static ObservableList<Voiture> getArchiveFromCherche3(String Datee) throws ClassNotFoundException, SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectionDuBd();



        String SqlgetArchive = "select * from voiture where date_dentrer LIKE '"+Datee+"%'";


        Statement st = connectDB.createStatement();
        ResultSet rsDatee = st.executeQuery(SqlgetArchive);
        ObservableList<Voiture> VoiList = getVoitureObjectbyDatee(rsDatee);

        return VoiList;
    }
    private static ObservableList<Voiture> getVoitureObjectbyDatee(ResultSet rsDatee) throws SQLException {
        ObservableList<Voiture> VoiList = FXCollections.observableArrayList();
        while (rsDatee.next()){
            Voiture voiture =new Voiture();
            voiture.setIdVProperty(rsDatee.getInt(1));
            voiture.setMatriculeProperty(rsDatee.getString(2));
            voiture.setNomProperty(rsDatee.getString(3));
            voiture.setdateEntrerProperty(rsDatee.getString(4));

            VoiList.add(voiture);
        }
        return VoiList;
    }










}