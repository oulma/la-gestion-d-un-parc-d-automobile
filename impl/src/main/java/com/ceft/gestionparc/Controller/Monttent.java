package com.ceft.gestionparc.Controller;

import com.ceft.gestionparc.DbConnection.DatabaseConnection;
import com.ceft.gestionparc.Model.montant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Monttent implements Initializable{

        @FXML
        private TableView<montant> table;
        @FXML
        private TableColumn<montant, Integer> col_id;
        @FXML
        private TableColumn<montant, String> col_mat;
        @FXML
        private TableColumn<montant, Integer> col_mont;

    @FXML
    private TextField prenom;

    @FXML
    private Label po;

    @FXML
    private ImageView mm;
    @FXML
    private ImageView aa;
    @FXML
    private ImageView hh;
    @FXML
    private ImageView ju;
    @FXML
    private ImageView na;

    @FXML
    private ImageView mod;

    @FXML
    private ImageView lol;
    @FXML
    private ImageView za;

    @FXML
    private Button sati ;


    @FXML
    private Button ww;

    @FXML
    private Button lolo;
    @FXML
    private Button model;
    @FXML
    private Button chaha;
    @FXML
    private Button annul;

    @FXML
    private Button redo;

    @FXML
    private Button gree;


    ObservableList<montant> observableList = FXCollections.observableArrayList();




    DatabaseConnection co= new DatabaseConnection();



    public void initialize(URL location, ResourceBundle resources) {
            fill()   ;
            po.setText(String.valueOf(montant())+   "  DH");

        File mmFile = new File("_img/save-money.png");
        Image mmImage = new Image(mmFile.toURI().toString());
        mm.setImage(mmImage);



        File aaFile = new File("_img/statistics.png");
        Image aaImage = new Image(aaFile.toURI().toString());
        aa.setImage(aaImage);


        File hhFile = new File("_img/_camera.png");
        Image hhImage = new Image(hhFile.toURI().toString());
        hh.setImage(hhImage);


        File juFile = new File("_img/new-user.png");
        Image juImage = new Image(juFile.toURI().toString());
        ju.setImage(juImage);

        File naFile = new File("_img/reservation.png");
        Image naImage = new Image(naFile.toURI().toString());
        na.setImage(naImage);

        File modFile = new File("_img/_archive.png");
        Image modImage = new Image(modFile.toURI().toString());
        mod.setImage(modImage);


        File lolFile = new File("_img/blocked.png");
        Image lolImage = new Image(lolFile.toURI().toString());
        lol.setImage(lolImage);

        File zaFile = new File("_img/new-user.png");
        Image zaImage = new Image(zaFile.toURI().toString());
        za.setImage(zaImage);
    }





    public static int montant(){
        int value = 0;


        try {


            DatabaseConnection co= new DatabaseConnection();

            Connection connect = co.connectionDuBd();
            ResultSet rs =connect.createStatement().executeQuery("SELECT SUM(Montant) FROM parc ");
            rs.next();
            String sum = rs.getString(1);
            value = Integer.parseInt(sum);

        } catch (Exception e){
            value += 0;
        }

        return value;
    }



        public void fill() {



            try {

                Connection connect = co.connectionDuBd();
                ResultSet rs =connect.createStatement().executeQuery("select * from parc");

                while(rs.next()) {
                    this.observableList.add(new montant(rs.getInt("id"), rs.getString("Matricule"), rs.getInt("Montant")));
                }
            } catch (SQLException | ClassNotFoundException var2) {
                var2.printStackTrace();
            }

            col_id.setCellValueFactory(new PropertyValueFactory("id"));
            col_mat.setCellValueFactory(new PropertyValueFactory("Matricule"));
            col_mont.setCellValueFactory(new PropertyValueFactory("Montant"));

            table.setItems(observableList);
        }


    public void yellowButtonOnAction(ActionEvent actionEvent) {
    }

    public void redButtonOnAction(ActionEvent actionEvent) {
    }

    public void greenButtonOnAction(ActionEvent actionEvent) {
    }

    public void vue(ActionEvent actionEvent) {


        DashboardController dh = new DashboardController();
        dh.showStatistique();
        Stage stage = (Stage)  sati.getScene().getWindow();
        stage.close();
    }

    public void liste(ActionEvent actionEvent) {

        DashboardController dh = new DashboardController();
        dh.showCameraliste();
        Stage stage = (Stage)  ww.getScene().getWindow();
        stage.close();

    }


    public void ajou(ActionEvent actionEvent) {
        DashboardController dh = new DashboardController();
        dh.showAjouterMember();
        Stage stage = (Stage)  lolo.getScene().getWindow();
        stage.close();

    }

    public void mor(ActionEvent actionEvent) {

        DashboardController dh = new DashboardController();
        dh.showReservation();
        Stage stage = (Stage)  model.getScene().getWindow();
        stage.close();
    }


    public void nod(ActionEvent actionEvent) {


        DashboardController dh = new DashboardController();
        dh.showArchive();
        Stage stage = (Stage)  chaha.getScene().getWindow();
        stage.close();
    }

    public void nul(ActionEvent actionEvent) {

        DashboardController dh = new DashboardController();
        dh.showListeNoire();
        Stage stage = (Stage)  annul.getScene().getWindow();
        stage.close();
    }

    public void reddo(ActionEvent actionEvent) {


        Stage stage = (Stage) redo.getScene().getWindow();
        stage.close();
    }


    public void gros(ActionEvent actionEvent) {


        Stage stage = (Stage) gree.getScene().getWindow();
        stage.close();
    }
}


//JOINTURE
//SELECt  matricule , montant
//FROM Q.pes, Q.DEPT

// changer le nom a total as fait le changement de nom
//ELECT id,val1,val2,val1-val2 as total FROM tableName


// sommer et soustraire en utilisant SQL
// SELECT   master_table.ORDERNO,
//ster_table.ITEM,
// SUM(master_table.QTY),
// stock_bal.BAL_QTY
//
// (stock_bal.BAL_QTY - SUM(master_table.QTY)) AS NEW_BAL
//FROM     master_table INNER JOIN
// stock_bal ON master_bal.ITEM = stock_bal.ITEM
// GROUP BmaY master_table.ORDERNO,
//master_table.ITEM

// vrai hhh
// (15* (voituresort.date_sortie - voiture.date_entree)) AS total   //code de procedure


//((master_table.QTY) - stock_bal.BAL_QTY) AS NEW_BAL


///calculer la différence entre deux dates,
//SELECT TIMESTAMPDIFF(SECOND,'2007-12-30 12:01:01','2007-12-31 10:02:00');
//result: 79259  the difference in seconds



//fonction de soubstraction de date datediff
//DATEDIFF (expr1, expr2)
//renvoie expr1 - expr2 exprimée sous forme de valeur en jours

//mont(){
//   static prix=15;
//  date dtsort;
// date dtent;
// int montant ;
// montnat = (dtsortd_dtent)*prix ;
// return montant;
//important
// SELECT voitursort.datesortie - voiture.dateentreee FROM voituresort, voiture as total
// }
// labelnnnnnnnnnnnnuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu                                                                                                                                                                                                                                                                                                              uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu

//while(i<n){
// montant+=montant;

//    i++;
// label.gettext(montant);
//  }


