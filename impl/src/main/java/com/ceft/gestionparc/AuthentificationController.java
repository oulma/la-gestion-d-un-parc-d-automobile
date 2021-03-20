package com.ceft.gestionparc;


import com.ceft.gestionparc.DbConnection.DatabaseConnection;
import com.ceft.gestionparc.Model.Utilisateur;
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

    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private ImageView brandignImageView,lockImageView;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile = new File("_img/_login.png");
        Image brandignImage = new Image(brandingFile.toURI().toString());
        brandignImageView.setImage(brandignImage);

        File lockFile = new File("_img/_person.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);
    }

    public void showAuthentification() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("view/Authentification.fxml"));
        Scene scene=new Scene(root);
        Stage primaryStage= new Stage();
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();
    }


    public void loginButtonOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()){

            validateLogin();

        }else{
            loginMessageLabel.setText("nom d'utilisateur ou le mot de passe vide");
        }
    }

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }


    public void validateLogin() throws SQLException, ClassNotFoundException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectionDuBd();

        String verifyLogin = "SELECT * FROM utilisateur where nomU = '"+usernameTextField.getText()+"' and motPasse = '"+enterPasswordField.getText()+"'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery(verifyLogin);
            while (rs.next()){

                Utilisateur util = new Utilisateur(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

                if (util.getIdU()!=0){
                    DashboardController dashboard = new DashboardController();
                      dashboard.goToDashboard();
                       Stage stage = (Stage) loginButton.getScene().getWindow();
                       stage.close();

                }else{
                        loginMessageLabel.setText("identifiant invalide");
                     }

               // if(queryResult.getInt(1)== 1 ){
                //

             //   }else{
                //    loginMessageLabel.setText("identifiant invalide");
              //  }

            }
        }catch (Exception e ){
            e.printStackTrace();
        }



    }


}
