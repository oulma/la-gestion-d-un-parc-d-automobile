package com.ceft.gestionparc.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Montant {

    public void AjouterUtilisateur(ActionEvent actionEvent) {
    }

    public void Réservation(ActionEvent actionEvent) {
    }

    public void CaméraEtListe(ActionEvent actionEvent) {
    }
    
    public void Archive(ActionEvent actionEvent) {
    }

    public void ListeNoire(ActionEvent actionEvent) {
    }

    public void Annuler(ActionEvent actionEvent) {
    }

    public void Montant(ActionEvent actionEvent) {
    }

    public void Satistiques(ActionEvent actionEvent) {
    }

    public void Rechercher(ActionEvent actionEvent) {
    }
    @FXML
    private Button greenButton, redButton, yellowButton;
    public void redButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) redButton.getScene().getWindow();
        stage.close();
    }

    public void yellowButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) yellowButton.getScene().getWindow();
        stage.toBack();
    }

    public void greenButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) greenButton.getScene().getWindow();
        stage.sizeToScene();

    }
}
