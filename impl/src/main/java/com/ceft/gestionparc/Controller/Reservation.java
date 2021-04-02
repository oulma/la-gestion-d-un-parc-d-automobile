package com.ceft.gestionparc.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Reservation implements Initializable {

    @FXML
    private ImageView Reservation,AjouterCompte,statistic,Camera,archive,ListeNoire,paiment,avatar;
    @FXML
    private Label setEmail;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File ReservationFile = new File("_img/reservation.png");
        Image ReservationImage = new Image(ReservationFile.toURI().toString());
        Reservation.setImage(ReservationImage);

        File AjouterCompteFile = new File("_img/new-user.png");
        Image AjouterCompteImage = new Image(AjouterCompteFile.toURI().toString());
        AjouterCompte.setImage(AjouterCompteImage);

        File statisticFile = new File("_img/statistics.png");
        Image statisticImage = new Image(statisticFile.toURI().toString());
        statistic.setImage(statisticImage);

        File CameraFile = new File("_img/_camera.png");
        Image CameraImage = new Image(CameraFile.toURI().toString());
        Camera.setImage(CameraImage);

        File archiveFile = new File("_img/_archive.png");
        Image archiveImage = new Image(archiveFile.toURI().toString());
        archive.setImage(archiveImage);

        File ListeNoireFile = new File("_img/blocked.png");
        Image ListeNoireImage = new Image(ListeNoireFile.toURI().toString());
        ListeNoire.setImage(ListeNoireImage);

        File paimentFile = new File("_img/save-money.png");
        Image paimentImage = new Image(paimentFile.toURI().toString());
        paiment.setImage(paimentImage);


       //had code kay rj3 lina l'email lfo9 dyal kola interface
        AjouterMember aj = new AjouterMember();
        try {
            setEmail.setText(aj.afficherEmail());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button XButtonInReservation,squareButtonInReservation,downButtonInReservation;
    public void downButtonInReservationOnAction(){
        Stage stage = (Stage) downButtonInReservation.getScene().getWindow();
        stage.toBack();
    }
    public void XButtonInReservationOnAction(){
        Stage stage = (Stage) downButtonInReservation.getScene().getWindow();
        stage.close();
    }
    //kat sed lina l'interface dyal reseravation
    @FXML
    private Button annulerReservation;
    public void annulerReservationOnAction(){
        DashboardController dh = new DashboardController();
        dh.goToDashboard();
        Stage stage = (Stage) XButtonInReservation.getScene().getWindow();
        stage.toBack();


    }
    @FXML
    private Button ajouterMombreRS;
    public void ajouterMombreRSonAction() {
        DashboardController dh = new DashboardController();
        dh.showAjouterMember();
        Stage stage = (Stage)  ajouterMombreRS.getScene().getWindow();
        stage.close();
    }
}
