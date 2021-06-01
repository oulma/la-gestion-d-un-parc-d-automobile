package com.ceft.gestionparc.Controller;
import com.ceft.gestionparc.DbConnection.DatabaseConnection;
        import com.ceft.gestionparc.Model.Parking;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.chart.*;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
        import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

import java.io.File;
        import java.net.URL;
        import java.sql.Connection;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.ResourceBundle;

public class Statistique implements Initializable {
    @FXML private LineChart<?, ?> parcMois;
    @FXML private CategoryAxis Z;
    @FXML private NumberAxis Y;
    @FXML private Button greenButton, redButton, yellowButton;
    @FXML private Label placeVide,carIn,carIn1,placeOccuper,MantantStats;
    @FXML private PieChart piechar;
    @FXML private ImageView barreTop;
    private int placeOccupé;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Parking parking = new Parking();


        File barreTopFile = new File("_img/VOITURE1.png");
        Image barreTopImage = new Image(barreTopFile.toURI().toString());
        barreTop.setImage(barreTopImage);

        MantantStats.setText(String.valueOf(Monttent.montant())+" MAD");

        try {
            parking.SQLajouterVoiture();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        //kat 3mre lina lgraph li kayn fl l'interface statistic #mazal makamlch
        XYChart.Series set1 = new XYChart.Series<>();
        try {
            set1.getData().add(new XYChart.Data("1",parking.nomberVoiture()+getPlaceOccupéAvecReservation()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        set1.getData().add(new XYChart.Data("2",0));
        set1.getData().add(new XYChart.Data("3",0));
        set1.getData().add(new XYChart.Data("4",0));
        set1.getData().add(new XYChart.Data("5",0));
        set1.getData().add(new XYChart.Data("6",0));
        set1.getData().add(new XYChart.Data("7",0));
        set1.getData().add(new XYChart.Data("8",0));
        set1.getData().add(new XYChart.Data("9",0));
        set1.getData().add(new XYChart.Data("10",0));
        set1.getData().add(new XYChart.Data("11",0));
        set1.getData().add(new XYChart.Data("12",0));
        parcMois.getData().addAll(set1);

        //les statistic de combient de place vide ou oucupée dans notre parking
        int placeEmpty = 0;
        try {
            placeEmpty = parking.getPlaceParkMax() - (parking.nomberVoiture() + getPlaceOccupéAvecReservation());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        placeVide.setText(String.valueOf(placeEmpty));
        try {
            carIn.setText(String.valueOf(getPlaceOccupéAvecReservation()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ObservableList<PieChart.Data> pieC = null;
        try {
            pieC = FXCollections.observableArrayList(
                    new PieChart.Data("Place Vide",placeEmpty),
                    new PieChart.Data("Place Réserver", getPlaceOccupéAvecReservation()),
                    new PieChart.Data("Place Occupee",parking.nomberVoiture())
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        piechar.setData(pieC);
        carIn1.setText(String.valueOf(parking.nomberVoiture()));
        try {
            placeOccuper.setText(String.valueOf(parking.nomberVoiture() + getPlaceOccupéAvecReservation()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            if ((parking.nomberVoiture() + getPlaceOccupéAvecReservation())>=parking.getPlaceParkMax()) {
                placeVide.setText("0");
                Notifications.create()
                        .title("Warning")
                        .text("Parkc occupee")
                        .showError(); }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public int getPlaceOccupéAvecReservation() throws SQLException, ClassNotFoundException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectionDuBd();
        String countHowManyCarInPark = "SELECT count(*) FROM `réservation`";
        Statement statement = connectDB.createStatement();
        ResultSet rs = statement.executeQuery(countHowManyCarInPark);
       if(rs.next())
       {
           placeOccupé = rs.getInt("count(*)");
           return placeOccupé;
       }
       else return 0;
    }

    public int getPlaceOccupéAvecAutoDetect() throws SQLException, ClassNotFoundException
    {
        return 0;
    }
    public void redButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) redButton.getScene().getWindow();
        stage.close();
    }
    public void yellowButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) greenButton.getScene().getWindow();
        stage.toBack();
    }
    public void greenButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) yellowButton.getScene().getWindow();
        stage.toBack();

    }

}