package com.ceft.gestionparc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ConfirmationAjouterUtil {
    @FXML
    private Button okAjouterButton;
    public void okAtouterButtonOnAction(){
        Stage stage = (Stage) okAjouterButton.getScene().getWindow();
        stage.close();
        DashboardController dashboardController = new DashboardController();
        dashboardController.goToDashboard();
    }
}
