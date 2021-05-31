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
    @FXML private Label placeVide,carIn,carIn1;
    @FXML private PieChart piechar;
    @FXML private ImageView barreTop;
    private int placeOccupé;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File barreTopFile = new File("_img/VOITURE1.png");
        Image barreTopImage = new Image(barreTopFile.toURI().toString());
        barreTop.setImage(barreTopImage);


        ObservableList<PieChart.Data> pieC = null;
        try {
            pieC = FXCollections.observableArrayList(
              new PieChart.Data("Place Vide",100-getPlaceOccupéAvecReservation()),
              new PieChart.Data("Place Réserver", getPlaceOccupéAvecReservation()),
              new PieChart.Data("Place Full",40)
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        piechar.setData(pieC);
        //kat 3mre lina lgraph li kayn fl l'interface statistic #mazal makamlch
        XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data("1",100));
        set1.getData().add(new XYChart.Data("2",10));
        set1.getData().add(new XYChart.Data("3",50));
        set1.getData().add(new XYChart.Data("4",60));
        set1.getData().add(new XYChart.Data("5",99));
        set1.getData().add(new XYChart.Data("6",56));
        set1.getData().add(new XYChart.Data("7",9));
        set1.getData().add(new XYChart.Data("8",30));
        set1.getData().add(new XYChart.Data("9",40));
        set1.getData().add(new XYChart.Data("10",54));
        set1.getData().add(new XYChart.Data("11",78));
        set1.getData().add(new XYChart.Data("12",25));
        parcMois.getData().addAll(set1);

        //les statistic de combient de place vide ou oucupée dans notre parking
        Parking parking = new Parking(1,"A-A-A-A",100);
        try {
            int placeEmpty = parking.getPlacePark() - getPlaceOccupéAvecReservation();
            placeVide.setText(String.valueOf(placeEmpty));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            carIn.setText(String.valueOf(getPlaceOccupéAvecReservation()));
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