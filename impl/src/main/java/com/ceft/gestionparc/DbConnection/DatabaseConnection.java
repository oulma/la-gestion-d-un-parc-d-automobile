package com.ceft.gestionparc.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    //#######################################################################"
    /* pour entrer a la base de donner aller au https://freedb.tech/phpmyadmin
      username : freedbtech_mahdiatmani / password : Doha1599               */
    //#######################################################################"
    public Connection connectionDuBd() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection databaseLink = DriverManager.getConnection("jdbc:mysql://localhost/parcdb","root","");
        return databaseLink;
    }
}
