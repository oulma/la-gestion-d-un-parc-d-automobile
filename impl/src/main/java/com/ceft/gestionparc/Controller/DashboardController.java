package com.ceft.gestionparc.Controller;
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
    @FXML private ImageView imagepark, dash1, dash2, dash3, dash4, dash5, dash6, dash7;
    @FXML private Button Montant,greenButton, redButton, yellowButton;
    @FXML private Button réservation;
    @FXML
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
            Parent root = FXMLLoader.load(getClass().getResource("/Dashboard.fxml"));
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
    //################################################################"
    //se methode affiche l'interface de Reserevation
    //################################################################"
    public void showReservation(){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/reservation.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            scene.setFill(Color.TRANSPARENT);
            primaryStage.show();
            Stage stage=(Stage) réservation.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }
    //################################################################"
    //se methode affiche l'interface de ListNoir du voiture
    //################################################################"
    @FXML private Button listeNoire,ajouterCompte;
    public void showListeNoire() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/ListeNoireTable.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            scene.setFill(Color.TRANSPARENT);
            primaryStage.show();
            Stage stage = (Stage)  listeNoire.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    //################################################################"
    //se methode affiche l'interface de Montant
    //################################################################"
    public void showMontant() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Monttent.fxml"));
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
    //################################################################"
    //les trois button de annuler, maximiser et minimiser
    //################################################################"
    public void redButtonOnAction() {
        Stage stage = (Stage) redButton.getScene().getWindow();
        stage.close();
    }
    public void yellowButtonOnAction() {
        Stage stage = (Stage) yellowButton.getScene().getWindow();
        stage.isMaximized();
    }
    public void greenButtonOnAction() {
        Stage stage = (Stage) greenButton.getScene().getWindow();
        //Nous devons le changer On maximiser l'ecrant
        stage.toBack();
    }
    //################################################################"
    //afficher l'interface pour ajouter un utilisateur comme administrateur
    //################################################################"
    public void showAjouterMember() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/ajouterMember.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            scene.setFill(Color.TRANSPARENT);
            primaryStage.show();
            Stage stage = (Stage) ajouterCompte.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    //#####################################################################"
    //afficher l'interface de supervision et de detection des plates
    //#####################################################################"
   @FXML private Button camera_list;
    public void showCameraliste() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/cameraListe.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            scene.setFill(Color.TRANSPARENT);
            primaryStage.show();
               Stage stage=(Stage) camera_list.getScene().getWindow();
                       stage.close();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    //################################################################"
    //afficher l'interface de statistique au temp réel
    //################################################################"
    public void showStatistique(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Statistique.fxml"));
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
    //################################################################"
    //afficher l'interface tout les voiture entrant le parc
    //################################################################"
    @FXML private Button archive;
    public void showArchive(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Archive.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            scene.setFill(Color.TRANSPARENT);
            primaryStage.show();
            Stage stage=(Stage) archive.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}