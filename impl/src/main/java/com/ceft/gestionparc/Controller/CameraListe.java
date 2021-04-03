package com.ceft.gestionparc.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class CameraListe  implements Initializable {
    @FXML
    private ImageView Cameraliste,AjouterCompte,statistic,reservation,archive,ListeNoire,paiment;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File CameralisteFile = new File("_img/_camera.png");
        Image CameralisteImage = new Image(CameralisteFile.toURI().toString());
        Cameraliste.setImage(CameralisteImage);

        File AjouterCompteFile = new File("_img/new-user.png");
        Image AjouterCompteImage = new Image(AjouterCompteFile.toURI().toString());
        AjouterCompte.setImage(AjouterCompteImage);


        File statisticFile = new File("_img/statistics.png");
        Image statisticImage = new Image(statisticFile.toURI().toString());
        statistic.setImage(statisticImage);

        File reservationFile = new File("_img/reservation.png");
        Image reservationImage = new Image(reservationFile.toURI().toString());
        reservation.setImage(reservationImage);

        File archiveFile = new File("_img/_archive.png");
        Image archiveImage = new Image(archiveFile.toURI().toString());
        archive.setImage(archiveImage);

        File ListeNoireFile = new File("_img/blocked.png");
        Image ListeNoireImage = new Image(ListeNoireFile.toURI().toString());
        ListeNoire.setImage(ListeNoireImage);

        File paimentFile = new File("_img/save-money.png");
        Image paimentImage = new Image(paimentFile.toURI().toString());
        paiment.setImage(paimentImage);

    }
}
