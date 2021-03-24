package com.ceft.gestionparc;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

       AuthentificationController aut= new AuthentificationController();
       aut.showAuthentification();
    }

    public static void main(String[] args) { launch(args); }

}