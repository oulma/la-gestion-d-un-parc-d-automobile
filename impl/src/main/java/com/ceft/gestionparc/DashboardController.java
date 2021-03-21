package com.ceft.gestionparc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
public class DashboardController implements Initializable {
    @FXML
    private ImageView imagepark;
    @FXML
    private Button greenButton,redButton,yellowButton;

    public void redButtonOnAction(ActionEvent event){
        Stage stage = (Stage) redButton.getScene().getWindow();
        stage.close();
    }
    public void yellowButtonOnAction(ActionEvent event){
        Stage stage = (Stage) yellowButton.getScene().getWindow();
        stage.toBack();
    }
    public void greenButtonOnAction(ActionEvent event){
        Stage stage = (Stage) greenButton.getScene().getWindow();
        stage.sizeToScene();

    }





    public void initialize(URL url, ResourceBundle resourceBundle){
        File parkFile = new File("_img/VOITURE.png");
        Image parkImage = new Image(parkFile.toURI().toString());
        imagepark.setImage(parkImage);

    }


    public void goToDashboard(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/ceft/gestionparc/view/Dashboard.fxml"));
            Stage dashStage = new Stage();
            dashStage.initStyle(StageStyle.UNDECORATED);
            dashStage.setScene(new Scene(root,1280,600));
            dashStage.show();


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }



    }
}