package com.ceft.gestionparc.Controller;
import com.ceft.gestionparc.DbConnection.DatabaseConnection;
import com.ceft.gestionparc.Model.Reservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class ReservationController implements Initializable {
    @FXML
    private ImageView Reservation,AjouterCompte,statistic,Camera,archive,ListeNoire,paiment,rechercher;
    @FXML
    private Label setEmail,confirmierReservation;
    @FXML
    private TableView<com.ceft.gestionparc.Model.Reservation> Table;

    @FXML
    private TableColumn<com.ceft.gestionparc.Model.Reservation, String> col_ID;

    @FXML
    private TableColumn<com.ceft.gestionparc.Model.Reservation, String> col_nom;

    @FXML
    private TableColumn<com.ceft.gestionparc.Model.Reservation, String> col_cin;

    @FXML
    private TableColumn<com.ceft.gestionparc.Model.Reservation, String> col_matricule;

    @FXML
    private TableColumn<com.ceft.gestionparc.Model.Reservation, String> col_da_ent;

    @FXML
    private TableColumn<com.ceft.gestionparc.Model.Reservation, String> col_dat_sor;


    ObservableList<Reservation> Oblist= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Fill();
        Rechercher();
        File ReservationFile = new File("_img/reservation.png");
        Image ReservationImage = new Image(ReservationFile.toURI().toString());
        Reservation.setImage(ReservationImage);
        File rechercherFile = new File("_img/_search.png");
        Image rechercherImage = new Image(rechercherFile.toURI().toString());
        rechercher.setImage(rechercherImage);

        File AjouterCompteFile = new File("_img/new-user.png");
        Image AjouterCompteImage = new Image(AjouterCompteFile.toURI().toString());
        AjouterCompte.setImage(AjouterCompteImage);

        File statisticFile = new File("_img/statistics.png");
        Image statisticImage = new Image(statisticFile.toURI().toString());
        statistic.setImage(statisticImage);

        File CameraFile = new File("_img/_camera.png");
        Image CameraImage = new Image(CameraFile.toURI().toString());
        Camera.setImage(CameraImage);

        File archiveFile = new File("_img/_archive.png");
        Image archiveImage = new Image(archiveFile.toURI().toString());
        archive.setImage(archiveImage);

        File ListeNoireFile = new File("_img/blocked.png");
        Image ListeNoireImage = new Image(ListeNoireFile.toURI().toString());
        ListeNoire.setImage(ListeNoireImage);

        File paimentFile = new File("_img/save-money.png");
        Image paimentImage = new Image(paimentFile.toURI().toString());
        paiment.setImage(paimentImage);


       //return l'email au haut de la interface
        AjouterMember aj = new AjouterMember();
        try {
            setEmail.setText(aj.afficherEmail());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button XButtonInReservation,squareButtonInReservation,downButtonInReservation;
    public void downButtonInReservationOnAction(){
        Stage stage = (Stage) downButtonInReservation.getScene().getWindow();
        stage.toBack();
    }
    public void XButtonInReservationOnAction(){

        Stage stage = (Stage) XButtonInReservation.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button ajouterMombreRS;
    public void ajouterMombreRSonAction() {
        DashboardController dh = new DashboardController();
        dh.showAjouterMember();
        Stage stage = (Stage)  ajouterMombreRS.getScene().getWindow();
        stage.close();
    }
    //######################################################
    //# l'ajoute d'une reservation
    //######################################################
    @FXML private TextField NomPrenomFld,cinFld,matriculeFld;
    @FXML private DatePicker dateEntée,dateDeSortie;
    @FXML private Button ajouterReservation;
    public void ajouterReservationOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
            try {
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.connectionDuBd();
                String NometPrenomAjt=NomPrenomFld.getText();
                String cinAjt=cinFld.getText();
                String martAjt=matriculeFld.getText();
                LocalDate dateEntrAjt=dateEntée.getValue();
                LocalDate dateSorAjt=dateDeSortie.getValue();
                Statement statement=connectDB.createStatement();



                if(NometPrenomAjt.isEmpty()||cinAjt.isEmpty()||martAjt.isEmpty()||dateEntée.getEditor().getText().isEmpty()||dateDeSortie.getEditor().getText().isEmpty()){
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Remplir tous les champs");
                    alert.showAndWait();
                    Stage stage = (Stage) ajouterReservation.getScene().getWindow();
                    stage.toFront();
                    return;
                }else if (dateEntrAjt.isAfter(dateSorAjt)){
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("la date d'entrée doit être inférieure à celle de sortie");
                    alert.showAndWait();
                    Stage stage = (Stage) ajouterReservation.getScene().getWindow();
                    stage.toFront();
                    return;
                }else{
                    int status=statement.executeUpdate("INSERT INTO réservation (nom, CIN, Matricule, `date d'entrée`, `date de sortie`)   VALUES  ( '"+NomPrenomFld.getText()+" ','"+cinFld.getText()+"','"+martAjt+"','"+dateEntée.getValue()+"', '"+dateDeSortie.getValue()+"')");
                    if(status>0)
                    {
                        JOptionPane.showMessageDialog(null,"Ajout avec succes");
                        refreshTableAction();
                        clean();

                    }
                    else{ JOptionPane.showMessageDialog(null,"erreur");
                    }
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }

    @FXML private Button StatistiqueRS;
    public void statistiqueRSonAction() {
        DashboardController dh = new DashboardController();
        dh.showStatistique();
        Stage stage = (Stage)  StatistiqueRS.getScene().getWindow();
        stage.close();
    }

    @FXML private Button CameraRS;
    public void cameraRSonAction() {
        DashboardController dh = new DashboardController();
        dh.showCameraliste();
        Stage stage = (Stage)  CameraRS.getScene().getWindow();
        stage.close();
    }

    @FXML private Button ArchiveRS;
    public void ArchiveRSonAction() {
        DashboardController dh = new DashboardController();
        dh.showMontant();
        Stage stage = (Stage)  ArchiveRS.getScene().getWindow();
        stage.close();
    }

    @FXML private Button listenoireRS;
    public void listenoireonAction() {
        DashboardController dh = new DashboardController();
        dh.showListeNoire();
        Stage stage = (Stage)  listenoireRS.getScene().getWindow();
        stage.close();
    }

    @FXML private Button montantRS;
    public void MontantonAction(ActionEvent actionEvent) {
        DashboardController dh = new DashboardController();
        dh.showMontant();
        Stage stage = (Stage)  montantRS.getScene().getWindow();
        stage.close();
    }

    @FXML private TextField  RecherRS ;
    public void Rechercher() {
        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Reservation> filteredData = new FilteredList<>(Oblist, b -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        RecherRS.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(liste_noire -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true; }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                if (liste_noire.getMatricule().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches first name.
                } else if (liste_noire.getIdR().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }     else if (liste_noire.getNomR().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;// Filter matches last name.
                }
                else if (String.valueOf(liste_noire.getMatricule()).indexOf(lowerCaseFilter)!=-1)
                    return true;

                else
                    return false; // Does not match.
            }); });
        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Reservation> sortedData = new SortedList<>(filteredData);
        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(Table.comparatorProperty());
        // 5. Add sorted (and filtered) data to the table.
        Table.setItems(sortedData);
    }

    private Reservation RS;
    @FXML public void SUPPRIMERAction() {
           int action = JOptionPane.showConfirmDialog(null, "Confirmer votre suppession?");
                try {
                    Reservation liste = Table.getSelectionModel().getSelectedItem();
                    if (liste != null) {
                        DatabaseConnection connectNow = new DatabaseConnection();
                        Connection connectDB = connectNow.connectionDuBd();
                        Statement statement = connectDB.createStatement();

                        statement.executeUpdate("DELETE FROM `réservation` WHERE id='"+liste.getIdR()+"'");
                      //  Table.getItems().clear();
                        Fill();
                        refreshTableAction();
                        clean();
                    }
                    else {JOptionPane.showMessageDialog(null,"Selectionne element que vouler supprimer");
                         }
                } catch (Exception e1) {
                    e1.printStackTrace();
                } }

    String query = null;
    Connection connection = null;
    ResultSet rs = null;
    PreparedStatement pst;
    private boolean update;

    public void refreshTableAction() throws ClassNotFoundException {
        Oblist.clear();
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.connectionDuBd();
            String query = "SELECT * FROM `réservation`";
            pst = connectDB.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Oblist.add(new Reservation(
                        rs.getString("id"),
                        rs.getString("nom"),
                        rs.getString("CIN"),
                        rs.getString("Matricule"),
                        rs.getString("date d'entrée"),
                        rs.getString("date de sortie")));
                Table.setItems(Oblist);
            }
            pst.close();
            rs.close();
            Rechercher();

        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        } }

    public void Fill() {
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.connectionDuBd();
            ResultSet rs =connectDB.createStatement().executeQuery("SELECT * FROM réservation");
            while (rs.next()){

                Oblist.add(new Reservation(rs.getString("id"),rs.getString("nom"),rs.getString("CIN"),rs.getString("Matricule"),rs.getString("date d'entrée"),rs.getString("date de sortie")));
            }
        } catch (SQLException | ClassNotFoundException exception) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE,null,exception);
        }
        col_ID.setCellValueFactory(new PropertyValueFactory<>("idR"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("CIN"));
        col_cin.setCellValueFactory(new PropertyValueFactory<>("nomR"));
        col_matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        col_da_ent.setCellValueFactory(new PropertyValueFactory<>("dateEntre"));
        col_dat_sor.setCellValueFactory(new PropertyValueFactory<>("dateSortie"));
        Table.setItems(Oblist);
    }
    @FXML private void clean() {
        NomPrenomFld.setText(null);
        cinFld.setText(null);
        matriculeFld.setText(null);
        dateDeSortie.setValue(null);
        dateEntée.setValue(null);
        dateDeSortie.setValue(null);
    }
    public void Selectionne()
    {
        Reservation    student = Table.getSelectionModel().getSelectedItem();
        NomPrenomFld.setText(student.getNomR());
        cinFld.setText(student.getCIN());
        matriculeFld.setText(student.getMatricule());
        dateDeSortie.setValue(LocalDate.parse(student.getDateEntre()));
        dateEntée.setValue(LocalDate.parse(student.getDateSortie()));
        dateDeSortie.setValue(LocalDate.parse(student.getDateSortie()));
    }

    public void modifierOnaction(ActionEvent event) throws SQLException, ClassNotFoundException {
        Reservation    student = Table.getSelectionModel().getSelectedItem();
        String noM=NomPrenomFld.getText();
        String ciN=cinFld.getText();
        String matricule =matriculeFld.getText();
        LocalDate dateEntrée=dateEntée.getValue();
        LocalDate datesortie=dateDeSortie.getValue();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectionDuBd();
        Statement statement = connectDB.createStatement();
        if(noM.isEmpty()||ciN.isEmpty()||matricule.isEmpty()||dateEntée.getEditor().getText().isEmpty()||dateDeSortie.getEditor().getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Remplir tous les champs");
            alert.showAndWait();
            return;

        }else if (dateEntrée.isAfter(datesortie)){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("la date d'entrée doit être inférieure à celle de sortie");
            alert.showAndWait();
            Stage stage = (Stage) ajouterReservation.getScene().getWindow();
            stage.toFront();
            return;
        }

        else{

            int status=statement.executeUpdate("UPDATE `réservation` SET  `nom` = '"+noM+"', `CIN` = '"+ciN+"', `Matricule` = '"+matricule+"', `date d'entrée` = '"+dateEntrée+"', `date de sortie` = '"+datesortie+"' WHERE `réservation`.`id`="+student.getIdR());
            if(status>0)
            {
                JOptionPane.showMessageDialog(null,"Modification avec succes avec succes");
                Fill();
            }
            else{ JOptionPane.showMessageDialog(null,"erreur");
            }
        }
        refreshTableAction();
        clean();
    }
            }










