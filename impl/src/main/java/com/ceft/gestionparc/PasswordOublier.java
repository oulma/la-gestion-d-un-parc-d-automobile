package com.ceft.gestionparc;

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

public class PasswordOublier {
    @FXML
    private Button annulerOublierPass,resinistialisation;
    @FXML
    private TextField serial;
    @FXML
    private PasswordField PASSWORD2,PASSWORD1;
    @FXML
    private Label messageErreurOublierPass;

    public void annulerOublierPassOnAction(){
        Stage stage = (Stage) annulerOublierPass.getScene().getWindow();
        stage.close();

    }
    public void resinistialisationOnAction(ActionEvent event) throws SQLException, ClassNotFoundException{
        if (!serial.getText().isBlank() && !PASSWORD2.getText().isBlank() && !PASSWORD1.getText().isBlank()) {
               validateRes();
            } else {
            messageErreurOublierPass.setText("Serie ou le mot de passe son vide");
            }
        }

    public void validateRes()throws SQLException, ClassNotFoundException  {
      if(PASSWORD1.getText().equals(PASSWORD2.getText())) {
          DatabaseConnection connectNow = new DatabaseConnection();
          Connection connectDB = connectNow.connectionDuBd();

          String verifyRes = "SELECT count(1) FROM utilisateur where serieU = '" + serial.getText() + "'";

          try {
              Statement statement = connectDB.createStatement();
              ResultSet oublier = statement.executeQuery(verifyRes);
              while (oublier.next()) {

                  if (oublier.getInt(1) == 1) {
                      Statement st = new DatabaseConnection().connectionDuBd().createStatement();
                      String updateAccount = "UPDATE `utilisateur` SET `motPasse` = '" + PASSWORD2.getText() + "' WHERE utilisateur.serieU ='" + serial.getText() + "'";
                      st.executeUpdate(updateAccount);
                      Parent root = FXMLLoader.load(getClass().getResource("/com/ceft/gestionparc/view/Confirmation.fxml"));
                      Scene scene = new Scene(root);
                      Stage primaryStage = new Stage();
                      primaryStage.initStyle(StageStyle.TRANSPARENT);
                      primaryStage.setScene(scene);
                      scene.setFill(Color.TRANSPARENT);
                      primaryStage.show();
                      Stage stage = (Stage) resinistialisation.getScene().getWindow();
                      stage.close();

                  } else {
                      messageErreurOublierPass.setText("votre série est invalide");
                  }


              }
          } catch (Exception e) {
              e.printStackTrace();

          }
      }else{
          messageErreurOublierPass.setText("les mots de passe ne correspondent pas");
      }

    }
        @FXML
        private Button ok;
        public void okOnAction() throws IOException {
            AuthentificationController a = new AuthentificationController();
            a.showAuthentification();
            Stage stage = (Stage) ok.getScene().getWindow();
            stage.close();
        }

}




