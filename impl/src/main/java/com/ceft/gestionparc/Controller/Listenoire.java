package com.ceft.gestionparc.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class Listenoire implements Initializable {
    DashboardController dh = new DashboardController();
    @FXML private Button redButton, yellowButton, greenButton;
    @FXML private ImageView blocked, statistics, camera, User, reservation, archive, Mont, Add;
    @FXML private Label Email;
    @FXML private Button Annuler;
    @FXML private Button statistique;
    @FXML private Button AjouterUtilisateur;

    public void AnnulerListeNoire() {
        DashboardController dh = new DashboardController();
        dh.goToDashboard();
        Stage stage = (Stage) Annuler.getScene().getWindow();
        stage.close();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File blockedFile = new File("_img/blocked.png");
        Image blockedImage = new Image(blockedFile.toURI().toString());
        blocked.setImage(blockedImage);

        File statisticsFile = new File("_img/statistics.png");
        Image statisticsImage = new Image(statisticsFile.toURI().toString());
        statistics.setImage(statisticsImage);

        File UserFile = new File("_img/new-user.png");
        Image UserImage = new Image(UserFile.toURI().toString());
        User.setImage(UserImage);

        File reservationFile = new File("_img/reservation.png");
        Image reservationImage = new Image(reservationFile.toURI().toString());
        reservation.setImage(reservationImage);

        File cameraFile = new File("_img/_camera.png");
        Image cameraImage = new Image(cameraFile.toURI().toString());
        camera.setImage(cameraImage);

        File archiveFile = new File("_img/_archive.png");
        Image archiveImage = new Image(archiveFile.toURI().toString());
        archive.setImage(archiveImage);

        File MontantFile = new File("_img/save-money.png");
        Image MontantImage = new Image(MontantFile.toURI().toString());
        Mont.setImage(MontantImage);

        File AddFile = new File("_img/admin.png");
        Image AddImage = new Image(AddFile.toURI().toString());
        Add.setImage(AddImage);

        AjouterMember ajouterMember=new AjouterMember();
        try {
            Email.setText(ajouterMember.afficherEmail());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }

    public void Satistiques() {
        dh.showStatistique();
    }
    @FXML
    public void showAjouterMemberListNoir() {
        dh.showAjouterMember();
    }


    public void redButtonOnAction() {
        Stage stage = (Stage) redButton.getScene().getWindow();
        stage.close();
    }

    public void yellowButtonOnAction() {
        Stage stage = (Stage) yellowButton.getScene().getWindow();
        stage.toBack();
    }

    public void greenButtonOnAction() {
        Stage stage = (Stage) greenButton.getScene().getWindow();
        stage.sizeToScene();
    }

    public void Rechercher() {
    }

    public void Montantt() {
    }

    public void CameraEtListe() {
    }

    public void Reservation() {
    }

    public void Archive() {
    }



    public void ajouterOnAction(ActionEvent actionEvent) {
    }
    @FXML
    private Button AjouterMemberListNoir;
    public void AjouterMemberListNoirOnAction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/reservation.fxml"));
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

