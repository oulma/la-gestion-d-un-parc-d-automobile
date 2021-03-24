package com.ceft.gestionparc;


import com.ceft.gestionparc.DbConnection.DatabaseConnection;
import com.ceft.gestionparc.Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
public class DashboardController implements Initializable {
    @FXML
    private ImageView imagepark, dash1, dash2, dash3, dash4, dash5, dash6, dash7;
    @FXML
    private Button greenButton, redButton, yellowButton;
    @FXML
    private Button ajouterCompte;
    @FXML
    private Button annulerAjouterMember;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File parkFile = new File("_img/VOITURE.png");
        Image parkImage = new Image(parkFile.toURI().toString());
        imagepark.setImage(parkImage);

        File dash1File = new File("_img/blocked.png");
        Image dash1Image = new Image(dash1File.toURI().toString());
        dash1.setImage(dash1Image);

        File dash2File = new File("_img/new-user.png");
        Image dash2Image = new Image(dash2File.toURI().toString());
        dash2.setImage(dash2Image);

        File dash3File = new File("_img/_camera.png");
        Image dash3Image = new Image(dash3File.toURI().toString());
        dash3.setImage(dash3Image);

        File dash4File = new File("_img/statistics.png");
        Image dash4Image = new Image(dash4File.toURI().toString());
        dash4.setImage(dash4Image);

        File dash5File = new File("_img/_archive.png");
        Image dash5Image = new Image(dash5File.toURI().toString());
        dash5.setImage(dash5Image);

        File dash6File = new File("_img/reservation.png");
        Image dash6Image = new Image(dash6File.toURI().toString());
        dash6.setImage(dash6Image);

        File dash7File = new File("_img/save-money.png");
        Image dash7Image = new Image(dash7File.toURI().toString());
        dash7.setImage(dash7Image);
    }


    public void goToDashboard() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/ceft/gestionparc/view/Dashboard.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            scene.setFill(Color.TRANSPARENT);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

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

    //had le method kat affichi lina le window bash nzido Uitilisateur
    public void showAjouterMember() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/ceft/gestionparc/view/ajouterMember.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            scene.setFill(Color.TRANSPARENT);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}