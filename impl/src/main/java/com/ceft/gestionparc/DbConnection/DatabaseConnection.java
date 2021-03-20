package com.ceft.gestionparc.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    public Connection connectionDuBd() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection databaseLink = DriverManager.getConnection("jdbc:mysql://localhost/parc","root","");
        return databaseLink;
    }
}
