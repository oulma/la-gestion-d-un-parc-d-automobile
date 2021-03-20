package com.ceft.gestionparc;


import com.ceft.gestionparc.Dashboard;
import com.ceft.gestionparc.DbConnection.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
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

        String verifyLogin = "SELECT count(1) FROM users where username = '"+usernameTextField.getText()+"' and password = '"+enterPasswordField.getText()+"'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next()){
                if(queryResult.getInt(1)== 1 ){
                    // System.out.println("zft");
                    Dashboard dashboard = new Dashboard();
                    dashboard.goToDashboard();
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    stage.close();

                }else{
                    loginMessageLabel.setText("identifiant invalide");
                }

            }
        }catch (Exception e ){
            e.printStackTrace();
        }



    }


}
