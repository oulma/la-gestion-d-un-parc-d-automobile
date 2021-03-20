module com.ceft.gestionparc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens com.ceft.gestionparc to javafx.fxml;
    exports com.ceft.gestionparc;
}