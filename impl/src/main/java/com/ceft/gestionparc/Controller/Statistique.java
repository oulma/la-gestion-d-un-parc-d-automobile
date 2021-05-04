package com.ceft.gestionparc.Controller;

        import com.ceft.gestionparc.DbConnection.DatabaseConnection;
        import com.ceft.gestionparc.Model.Parking;
        import javafx.beans.Observable;
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
    @FXML private Button greenButton, redButton, yellowButton;
    @FXML private Label totalPlace2,placeVide,carIn,totalPlace1;
    @FXML private ImageView inout2,inout1;
    @FXML private PieChart piechar;
    @FXML private ImageView barreTop;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File barreTopFile = new File("_img/VOITURE1.png");
        Image barreTopImage = new Image(barreTopFile.toURI().toString());
        barreTop.setImage(barreTopImage);


        ObservableList<PieChart.Data> pieC = FXCollections.observableArrayList(
          new PieChart.Data("Place Vide",50),
          new PieChart.Data("Place Réserver",10),
          new PieChart.Data("Place Full",40)
        );
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
        //had lcode les images li kaynin wst l'interface statistique
        File inoutFile = new File("_img/inout.png");
        Image inoutImage = new Image(inoutFile.toURI().toString());
        inout1.setImage(inoutImage);
        inout2.setImage(inoutImage);
        //les statistic de combient de place vide ou oucupée dans notre parking
        Parking parking = new Parking(1,"A-A-A-A",101);
        totalPlace1.setText(String.valueOf(parking.getPlacePark()));
        totalPlace2.setText(String.valueOf(parking.getPlacePark()));

        try {
            int placeEmpty = parking.getPlacePark() - getPlaceOccupé();
            placeVide.setText(String.valueOf(placeEmpty));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            carIn.setText(String.valueOf(getPlaceOccupé()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static int  getPlaceOccupé() throws SQLException, ClassNotFoundException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectionDuBd();
        String countHowManyCarInPark = "SELECT COUNT(*) FROM voiture";
        Statement statement = connectDB.createStatement();
        ResultSet rs = statement.executeQuery(countHowManyCarInPark);
        int placeOccupé = rs.getInt(1);
        return placeOccupé;  }


    @FXML private LineChart<?, ?> parcMois;

    @FXML private CategoryAxis Z;

    @FXML private NumberAxis Y;


    public void redButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) redButton.getScene().getWindow();
        stage.close();
    }
    public void yellowButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) greenButton.getScene().getWindow();
        stage.sizeToScene();
    }
    public void greenButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) yellowButton.getScene().getWindow();
        stage.toBack();

    }

}