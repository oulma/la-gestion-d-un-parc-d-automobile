package com.ceft.gestionparc;

        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.chart.*;

        import java.net.URL;
        import java.util.ResourceBundle;

public class Statistique implements Initializable {

    @FXML
    private LineChart<?, ?> parcMois;

    @FXML
    private CategoryAxis Z;

    @FXML
    private NumberAxis Y;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
    }

}