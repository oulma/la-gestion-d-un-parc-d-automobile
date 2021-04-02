module com.ceft.gestionparc.Controller {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens com.ceft.gestionparc.Controller to javafx.fxml;
    exports com.ceft.gestionparc.Controller;
}