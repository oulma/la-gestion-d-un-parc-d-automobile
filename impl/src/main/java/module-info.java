module com.ceft.gestionparc.Controller {
    requires javafx.controls;
    requires java.sql;
    requires mysql.connector.java;
    requires javafx.base;
    requires java.desktop;
    requires javafx.graphics;
    requires javafx.fxml;
    exports com.ceft.gestionparc.Model;
    opens com.ceft.gestionparc.Model to javafx.graphics;
    opens com.ceft.gestionparc.Controller to javafx.fxml;

    exports com.ceft.gestionparc.Controller;
}