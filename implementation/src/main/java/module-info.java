module com.ceft {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ceft.gestionparc to javafx.fxml;
}