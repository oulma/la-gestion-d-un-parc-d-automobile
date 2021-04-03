package com.ceft.gestionparc.Controller;
import com.ceft.gestionparc.DbConnection.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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


       //return l'email au haut de la interface
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
    //qui ferme l'interface de réservation
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
    //######################################################
    //# l'ajoute d'une reservation
    //######################################################
    @FXML
    private Label reservationmessageErreur;
    @FXML
    private TextField NomPrenom,cin,matricule,dateEntrer,datesortie;
    @FXML
    private Button ajouterReservation;
    public void ajouterReservationOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        if(!NomPrenom.getText().isBlank() && !cin.getText().isBlank() && !matricule.getText().isBlank()
        && !dateEntrer.getText().isBlank()){


        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectionDuBd();
        String addReservation = "INSERT INTO `réservation` (`nom`, `CIN`, `Matricule`, `date d'entrée`, `date de sortie`) " +
                              "VALUES ('"+NomPrenom.getText()+"', '"+cin.getText()+"'," +
                                " '"+matricule.getText()+"', '"+dateEntrer.getText()+"', '"+datesortie.getText()+"');";
            Statement statement = connectDB.createStatement();
             statement.executeUpdate(addReservation);
            Stage stage = (Stage) ajouterReservation.getScene().getWindow();
            stage.close();

            Parent root = FXMLLoader.load(getClass().getResource("/ConfirmationAjouterReservation.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            scene.setFill(Color.TRANSPARENT);
            primaryStage.show();


        }else {
            reservationmessageErreur.setText("Entrer touts les champs");
        }

    }
@FXML
private Button ok;
    public void okOnAction() {
        Stage stage = (Stage) ok.getScene().getWindow();
        stage.close();
    }
}
