package com.ceft.gestionparc;

import com.ceft.gestionparc.App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
        Scene scene=new Scene(root);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();

        //com/ceft/gestionparc/controller/java
        //com/ceft/gestionparc/Authentification.fxml
    }


    public static void main(String[] args) {
        launch(args);
    }

}