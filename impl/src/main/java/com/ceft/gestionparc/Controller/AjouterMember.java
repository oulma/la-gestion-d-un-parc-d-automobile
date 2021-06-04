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
import javafx.scene.control.PasswordField;
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

public class AjouterMember implements Initializable {

    @FXML
    private TextField nomAjouterUtilisateur, cinAjouterUtilisateur, prenomAjouterUtilisateur, emailAjouterUtilisateur;
    @FXML
    private PasswordField passAjouterUtilisateur, npassAjouterUtilisateur;
    @FXML
    public Label setEmail,confirmAjouter;
    @FXML
    private TextField setSerie;
    @FXML
    private Button annulerAjouterMember;
    @FXML
    private ImageView dash1, dash2, dash3, dash4, dash5, dash6, dash7, side1,side2;
    @FXML
    private Button ajouterUtilisateur;
    DashboardController dh = new DashboardController();
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File sideFile = new File("_img/_side.png");
        Image sideImage = new Image(sideFile.toURI().toString());



        File dash1File = new File("_img/statistics.png");
        Image dash1Image = new Image(dash1File.toURI().toString());
        dash1.setImage(dash1Image);

        File dash2File = new File("_img/_camera.png");
        Image dash2Image = new Image(dash2File.toURI().toString());
        dash2.setImage(dash2Image);

        File dash3File = new File("_img/_archive.png");
        Image dash3Image = new Image(dash3File.toURI().toString());
        dash3.setImage(dash3Image);

        File dash4File = new File("_img/blocked.png");
        Image dash4Image = new Image(dash4File.toURI().toString());
        dash4.setImage(dash4Image);

        File dash5File = new File("_img/reservation.png");
        Image dash5Image = new Image(dash5File.toURI().toString());
        dash5.setImage(dash5Image);

        File dash6File = new File("_img/save-money.png");
        Image dash6Image = new Image(dash6File.toURI().toString());
        dash6.setImage(dash6Image);

        File dash7File = new File("_img/new-user.png");
        Image dash7Image = new Image(dash7File.toURI().toString());
        dash7.setImage(dash7Image);

        try {
            setEmail.setText(afficherEmail());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //qui ajoute un utilisateur dans la base de donner
    public void ajouterUtilisateurOnAction() throws SQLException, IOException, ClassNotFoundException {
        if (!emailAjouterUtilisateur.getText().isBlank() && !prenomAjouterUtilisateur.getText().isBlank() && !cinAjouterUtilisateur.getText().isBlank() && !passAjouterUtilisateur.getText().isBlank() && !npassAjouterUtilisateur.getText().isBlank() && !nomAjouterUtilisateur.getText().isBlank()) {
            validateAjouter();
        } else {
            confirmAjouter.setText("Entrer tout les champ");
        }
    }


    public void validateAjouter() throws SQLException, ClassNotFoundException, IOException {
        if (passAjouterUtilisateur.getText().equals(npassAjouterUtilisateur.getText())) {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.connectionDuBd();

            try {
                Statement st = connectDB.createStatement();
                String addAccount = "INSERT INTO utilisateur (serieU, nomU,PrenomU, motPasse, emailU, cinU) VALUES ('"+setSerie.getText()+"','"+prenomAjouterUtilisateur.getText() +"','"+nomAjouterUtilisateur.getText()+"','"+npassAjouterUtilisateur.getText()+"','" + emailAjouterUtilisateur.getText() + "', '" + cinAjouterUtilisateur.getText() + "')";
                st.executeUpdate(addAccount);
                Parent root = FXMLLoader.load(getClass().getResource("/ConfirmationAjouterUtil.fxml"));
                Scene scene = new Scene(root);
                Stage primaryStage = new Stage();
                primaryStage.initStyle(StageStyle.TRANSPARENT);
                primaryStage.setScene(scene);
                scene.setFill(Color.TRANSPARENT);
                primaryStage.show();
                Stage stage = (Stage) ajouterUtilisateur.getScene().getWindow();
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            confirmAjouter.setText("les mots de passe ne correspondent pas");
        }
    }
        //se methode annuler l'ajout d'un utilisateur
        public void annulerAjouterMemberOnAction () {
            Stage stage = (Stage) annulerAjouterMember.getScene().getWindow();
            stage.close();
        }
        // return l'email de l'utilisateur connecter
        public String afficherEmail () throws SQLException, ClassNotFoundException {
            String requet = "Select * from utilisateur where nomU ='" + AuthentificationController.user + "'";
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.connectionDuBd();
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery(requet);
            if (rs.next()) {

                return rs.getString(5);
            } else {
                return "N/A";
            }
        }
        @FXML
        private Button redButton;
    public void redButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) redButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private Button greenButton;
    public void greenButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) greenButton.getScene().getWindow();
        stage.toBack();
    }
    @FXML
    private Button yellowButton;
    public void yellowButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) yellowButton.getScene().getWindow();
        stage.toBack();
    }

        //##########################################################"
        // les interface & button de couté
        //##########################################################"
        @FXML
        private Button statistiqueAjouterMember;
        public void statistiqueAjouterMemberOnAction(){
            dh.showStatistique();
            Stage stage = (Stage) statistiqueAjouterMember.getScene().getWindow();
            stage.close();
        }
        @FXML
        private Button cameralistAjouterMember;
        public void cameralistAjouterMemberOnAction(){
            dh.showCameraliste();
            Stage stage = (Stage) cameralistAjouterMember.getScene().getWindow();
            stage.close();
        }
        @FXML
        private Button listnoirAjouterMember;
        public void listnoirAjouterMemberOnAction(){
            dh.showListeNoire();
            Stage stage = (Stage) listnoirAjouterMember.getScene().getWindow();
            stage.close();
        }
        @FXML
        private Button reservationAjouterMember;
        public void reservationAjouterMemberOnAction(){
            dh.showReservation();
            Stage stage = (Stage) reservationAjouterMember.getScene().getWindow();
            stage.close();
        }
        @FXML
        private Button archiveAjouterMember;
        public void archiveAjouterMemberOnAction(){
            dh.showArchive();
            Stage stage = (Stage) archiveAjouterMember.getScene().getWindow();
            stage.close();
        }
        @FXML
        private Button MontantAjouterMember;
        public void MontantAjouterMemberOnAction(){
            dh.showMontant();
            Stage stage = (Stage) MontantAjouterMember.getScene().getWindow();
            stage.close();
        }

    @FXML
    private Button dashboard;
    public void dashboardOnAction() {
            dh.goToDashboard();
            Stage stage = (Stage) dashboard.getScene().getWindow();
            stage.close();
    }
}







