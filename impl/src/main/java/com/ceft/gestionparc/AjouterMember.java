package com.ceft.gestionparc;

import com.ceft.gestionparc.DbConnection.DatabaseConnection;
import com.mysql.cj.jdbc.StatementImpl;
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
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AjouterMember implements Initializable {
    @FXML
    public Label setEmail;
    @FXML
    private Button annulerAjouterMember;
    @FXML
    private ImageView dash1, dash2, dash3, dash4, dash5, dash6, dash7, dash77;

    public void initialize(URL url, ResourceBundle resourceBundle) {

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
        dash77.setImage(dash7Image);

        try {
            setEmail.setText(afficherEmail());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    //se methode annuller l'ajoute d'un utilisateur
    public void annulerAjouterMemberOnAction() {
        Stage stage = (Stage) annulerAjouterMember.getScene().getWindow();
        stage.close();
    }
    // had le methode kat rej3 lina le email dyal ay wa7ed t connecta l application
    public String afficherEmail() throws SQLException, ClassNotFoundException {
        DashboardController d = new DashboardController();
        String requet = "Select * from utilisateur where nomU ='a'";
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectionDuBd();
        Statement statement = connectDB.createStatement();
        ResultSet rs = statement.executeQuery(requet);
        if(rs.next()){

                      return rs.getString(5);
                  }
                  else{
                      return "N/A";
                  }



    }
}






