package com.ceft.gestionparc.Controller;

import com.ceft.gestionparc.DbConnection.DatabaseConnection;
import com.ceft.gestionparc.Model.Voiture;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Archive implements Initializable {

    //-------------------les variable du tablaux-------------------------
    @FXML private TableView<Voiture> archiveTableView;
    @FXML private TableColumn<Voiture, Integer> idCol;
    @FXML private TableColumn<Voiture, String> matriculeCol;
    @FXML private TableColumn<Voiture, String> nomCol;
    @FXML private TableColumn<Voiture, String> dateCol;
    //----------------------------------------------------------------------


    @FXML private ImageView blocked;
    @FXML private ImageView User;
    @FXML private ImageView Mont,archive;
    @FXML private Button Reservation;
    @FXML private Button listnoir;
    @FXML private Button Montant;
    @FXML private Button CameraEtListe;
    @FXML private Button AjouterMember;
    @FXML private ImageView serchicon,refrechButton,statistics,Add,camera,reservation;
    @FXML private Label setEmail;
    @FXML private Button redButton,yellowButton,greenButton,Satistiques;
    @FXML private  ComboBox rehercheBox;
    @FXML private  TextField  researchFleid;
    @FXML private ImageView back1,back2;
    //------------------------------------------------------------------------------------//

    //-------------------------les variable du voiture------------------------------------//
    public int ID;
    public String Matricule;
    public String Nom;
    public String Datee;
    //------------------------------------------------------------------------------------//

    DashboardController dh = new DashboardController();


    public void initialize(URL url, ResourceBundle resourceBundle) {

//-------------------------image show-----------------------------------//
        File backFile = new File("_img/backsize2.png");
        Image backImage = new Image(backFile.toURI().toString()); //
        back1.setImage(backImage);
        back2.setImage(backImage);


        File blockedFile = new File("_img/_archive.png");
        Image blockedImage = new Image(blockedFile.toURI().toString()); //
        blocked.setImage(blockedImage);

        File serchiconFile = new File("_img/_search.png");
        Image serchiconImage = new Image(serchiconFile.toURI().toString());
        serchicon.setImage(serchiconImage);

        File refrechButtonFile = new File("_img/_refresh.png");
        Image refrechButtonImage = new Image(refrechButtonFile.toURI().toString());
        refrechButton.setImage(refrechButtonImage);

        File statisticsFile = new File("_img/statistics.png");
        Image statisticsImage = new Image(statisticsFile.toURI().toString());
        statistics.setImage(statisticsImage);

        File UserFile = new File("_img/new-user.png");
        Image UserImage = new Image(UserFile.toURI().toString());
        User.setImage(UserImage);

        File reservationFile = new File("_img/reservation.png");
        Image reservationImage = new Image(reservationFile.toURI().toString());
        reservation.setImage(reservationImage);

        File cameraFile = new File("_img/_camera.png");
        Image cameraImage = new Image(cameraFile.toURI().toString());
        camera.setImage(cameraImage);

        File archiveFile = new File("_img/blocked.png");
        Image archiveImage = new Image(archiveFile.toURI().toString());
        archive.setImage(archiveImage);

        File MontantFile = new File("_img/save-money.png");
        Image MontantImage = new Image(MontantFile.toURI().toString());
        Mont.setImage(MontantImage);

        File AddFile = new File("_img/admin.png");
        Image AddImage = new Image(AddFile.toURI().toString());
        Add.setImage(AddImage);
//--------------------------------------------------------------------------------//

//----------------------afficher l'email de chaque utilisateur---------------------//
        AjouterMember ajouterMember=new AjouterMember();
        try {
            setEmail.setText(ajouterMember.afficherEmail());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

//--------------------------------------------------------------------------------//

//----------------------Afficher les donner dans le tableaux--------------------------------//

        idCol.setCellValueFactory(cellData -> cellData.getValue().getIdVProperty1().asObject());
    matriculeCol.setCellValueFactory(cellData -> cellData.getValue().getMatriculeProperty1());
    nomCol.setCellValueFactory(cellData -> cellData.getValue().nomPropertyProperty());
    // dateCol.setCellValueFactory(cellData -> cellData.getValue().dateEntrerProperty1());
        try {
            ObservableList<Voiture> VoiList1 = Voiture.getArchive();
            populateTable(VoiList1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("the SQL LINE 112 NOT WORKING ! ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    //---------------------------------------------------------------------------------------------------//
            ObservableList<String> listPourChoix = FXCollections.observableArrayList("Id",
                                "Matricule","Nom","Date D'Entrer");
            rehercheBox.setItems(listPourChoix);



    }


    //se methode remplire le tablaux
    private void populateTable(ObservableList<Voiture> voiList1) {
        archiveTableView.setItems(voiList1);
    }

    //se methode refreché le tableau a partire d'une button dans l'interface
    public void refrechOnClick() throws SQLException, ClassNotFoundException {
        refrechButton.setRotate(80);
        ObservableList<Voiture> VoiList1 = Voiture.getArchive();
        populateTable(VoiList1);
    }
    //se methode a responsable pour la recherche dans le tableau
    @FXML private Button RechercherButton;
    @FXML private Label erreur;
    public void RechercherButtonOnAction() throws SQLException, ClassNotFoundException {
        if(rehercheBox.getSelectionModel().isEmpty())
            erreur.setText("Choisissez ce que vous voulez rechercher");
        if(rehercheBox.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("id")){
            erreur.setText("");
            ID=Integer.parseInt(researchFleid.getText());
            ObservableList<Voiture> VoiList1 = Voiture.getArchiveFromCherche(ID);
            populateTable(VoiList1);
        }else if(rehercheBox.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Matricule")){
            erreur.setText("");
            Matricule=researchFleid.getText();
            ObservableList<Voiture> VoiList1 = Voiture.getArchiveFromCherche1(Matricule);
            populateTable(VoiList1);
        }else if(rehercheBox.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Nom")){
            erreur.setText("");
            Nom=researchFleid.getText();
            ObservableList<Voiture> VoiList1 = Voiture.getArchiveFromCherche2(Nom);
            populateTable(VoiList1);
        } else if(rehercheBox.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Date D'Entrer")) {
            erreur.setText("");
            Datee = researchFleid.getText();
            ObservableList<Voiture> VoiList1 = Voiture.getArchiveFromCherche3(Datee);
            populateTable(VoiList1);

        }
    }
    //---------------------le trois button de annuler de minimize et maximize ------------------------//

    public void redButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) redButton.getScene().getWindow();
        stage.close();
    }

    public void greenButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) greenButton.getScene().getWindow();
        stage.toBack();
    }
    public void yellowButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) yellowButton.getScene().getWindow();
        stage.toBack();
    }
    //--------------------------------------------------------------------------------------------//

    @FXML Button Dashboard;
    public void showDashboardArchive(ActionEvent actionEvent) {
        dh.goToDashboard();
        Stage stage = (Stage) Dashboard.getScene().getWindow();
        stage.close();
    }


    public void showReservationArchive(ActionEvent actionEvent) {
        dh.showReservation();
        Stage stage = (Stage) Reservation.getScene().getWindow();
        stage.close();

    }

    public void showListNoirArchive(ActionEvent actionEvent) {
        dh.showListeNoire();
        Stage stage = (Stage) listnoir.getScene().getWindow();
        stage.close();

    }

    public void showMontantArchive(ActionEvent actionEvent) {
    dh.showMontant();
        Stage stage = (Stage) Montant.getScene().getWindow();
        stage.close();
    }

    public void showCameraEtListeArchive(ActionEvent actionEvent) {
    dh.showCameraliste();
        Stage stage = (Stage) CameraEtListe.getScene().getWindow();
        stage.close();
    }

    public void showAjouterMemberArchive(ActionEvent actionEvent) {
    dh.showAjouterMember();
        Stage stage = (Stage) AjouterMember.getScene().getWindow();
        stage.close();
    }

    public void showSatistiquesArchive(ActionEvent actionEvent) {
    dh.showStatistique();
        Stage stage = (Stage) Satistiques.getScene().getWindow();
        stage.close();
    }
    //se méthode Afficher un exemple pour saisir la date et le message de erreur
    @FXML
    private Label dtFormatEx;
    public void rehercheBoxOnAction() {
        if(rehercheBox.getSelectionModel().isEmpty())
            erreur.setText("Choisissez ce que vous voulez rechercher");
        else{
            erreur.setText("");
        }
        if(rehercheBox.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Date D'Entrer"))
        dtFormatEx.setText("Ex : 2000-09-22");
        else{
            dtFormatEx.setText("");
        }
    }

    //la methode de suppression des archives
    public void deletButtonOnAction() throws SQLException, ClassNotFoundException {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectionDuBd();

        String SqlgetArchive = "DELETE FROM voiture WHERE id = "+archiveTableView.getSelectionModel().getSelectedItem().getIdVProperty();
        Statement st = connectDB.createStatement();
        st.executeUpdate(SqlgetArchive);
        refrechOnClick();

    }

}

