package com.ceft.gestionparc.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ConfirmationOublierPass {

    @FXML
    private Button ok;

    @FXML
    void okOnAction(ActionEvent event) throws IOException {
        AuthentificationController authentificationController = new AuthentificationController();
        authentificationController.showAuthentification();
        Stage stage = (Stage) ok.getScene().getWindow();
        stage.close();
    }

}