package com.ceft.gestionparc.Controller;

import com.ceft.gestionparc.DbConnection.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

public class AuthentificationController implements Initializable {
    public static String user;
    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private ImageView brandignImageView, login;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;
    @FXML
    private Hyperlink oublierPass;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("_img/_login.png");
        Image brandignImage = new Image(brandingFile.toURI().toString());
        brandignImageView.setImage(brandignImage);

        File lockFile = new File("_img/login.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        login.setImage(lockImage);


    }


        //afficher l'interface d'authentification
    public void showAuthentification() throws IOException {         //changer pour tester votre inteface
        Parent root = FXMLLoader.load(getClass().getResource("/ajouterMember.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();

    }
   @FXML
   private ImageView loadgif;
        //verifier le utilisateur et le password sont vide ou no
    public void loginButtonOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()) {

            validateLogin();

        } else {
            loginMessageLabel.setText("nom d'utilisateur ou le mot de passe sont vide");
        }
    }

    public void cancelButtonOnAction() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void retrunEmail() {
        user = String.valueOf(usernameTextField.getText());
    }

    public void validateLogin() throws SQLException, ClassNotFoundException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectionDuBd();
        String verifyLogin = "SELECT count(1) FROM utilisateur where nomU = '" + usernameTextField.getText() + "' and motPasse = '" + enterPasswordField.getText() + "'";
        retrunEmail();
        try {
            Statement st = connectDB.createStatement();
            ResultSet rs = st.executeQuery(verifyLogin);
            while (rs.next()) {

                //  Utilisateur util = new Utilisateur(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                if (rs.getInt(1) == 1) {
                    DashboardController dashboard = new DashboardController();
                    dashboard.goToDashboard();
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    stage.close();

                } else {
                    loginMessageLabel.setText("identifiant invalide");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void oublierPassOnAction() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/passwordoublier.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();
        Stage stage = (Stage) oublierPass.getScene().getWindow();
        stage.close();

    }
}

