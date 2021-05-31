package com.ceft.gestionparc.Controller;

import javafx.application.Application;
import javafx.stage.Stage;
import org.opencv.core.Core;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

       AuthentificationController aut= new AuthentificationController();
       aut.showAuthentification();
    }

    public static void main(String[] args) {
        System.loadLibrary( "opencv_java452" );

        launch(args);
    }

}