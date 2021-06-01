package com.ceft.gestionparc.Controller;

import com.ceft.gestionparc.DbConnection.DatabaseConnection;
import com.ceft.gestionparc.Model.liste_noire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListeNoireTable implements Initializable {
    DashboardController dh = new DashboardController();
    @FXML private Button redButton, yellowButton, greenButton;
    @FXML private ImageView blocked, statistics, camera, User, reservation, archive, Mont, Add,search;
    @FXML private Label Email;
    @FXML private Button Annuler,ajouterbtn;
    @FXML private Button statistique;
    @FXML private Button AjouterUtilisateur;
    @FXML private TableView<liste_noire> table;
    @FXML private TableColumn<liste_noire,String>MatriculeCol;
    @FXML private TableColumn<liste_noire,String>MarqueCol;
    @FXML private TableColumn<liste_noire,String>EtatCol;
    @FXML private TextField Search;
    @FXML private TextField MatriculeFld;
    @FXML private TextField MarqueFld;
    @FXML private ComboBox EtatFld;

    ObservableList<liste_noire> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fill();

        SearchAction();




        //remplir la combobox
        EtatFld.getItems().add("Violations de la circulation");
        EtatFld.getItems().add("Volé");
        EtatFld.getItems().add("Échapper sans payer les frais");

        File searchFile = new File("_img/_search.png");
        Image searchImage = new Image(searchFile.toURI().toString());
        search.setImage(searchImage);

        File blockedFile = new File("_img/blocked.png");
        Image blockedImage = new Image(blockedFile.toURI().toString());
        blocked.setImage(blockedImage);

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

        File archiveFile = new File("_img/_archive.png");
        Image archiveImage = new Image(archiveFile.toURI().toString());
        archive.setImage(archiveImage);

        File MontantFile = new File("_img/save-money.png");
        Image MontantImage = new Image(MontantFile.toURI().toString());
        Mont.setImage(MontantImage);

        File AddFile = new File("_img/admin.png");
        Image AddImage = new Image(AddFile.toURI().toString());
        Add.setImage(AddImage);

        AjouterMember ajouterMember = new AjouterMember();
        try {
            Email.setText(ajouterMember.afficherEmail());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }

    public void redButtonOnAction() {
        Stage stage = (Stage) redButton.getScene().getWindow();
        stage.close();
    }

    public void yellowButtonOnAction() {
        Stage stage = (Stage) yellowButton.getScene().getWindow();
        stage.sizeToScene();
    }

    public void greenButtonOnAction() {
        Stage stage = (Stage) greenButton.getScene().getWindow();
        stage.toBack();
    }

    @FXML void Satistiques() { dh.showStatistique(); }

    @FXML public void showAjouterMemberListNoir() { dh.showAjouterMember(); }

    @FXML public void Montant(ActionEvent actionEvent) { dh.showMontant(); }

    @FXML public void CameraEtListe() { dh.showCameraliste(); }

    @FXML public void Reservation() { dh.showReservation(); }

    @FXML public void Archive() {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("/Archive.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();

    } catch (Exception e) {
        e.printStackTrace();
        e.getCause();
    }}

    String query = null;
    Connection connection = null;
    ResultSet rs = null;
    PreparedStatement pst;
    private boolean update;

    //methode rafraîchir la table
    public void refreshTableAction() throws ClassNotFoundException {
        observableList.clear();
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.connectionDuBd();
            String query = "SELECT * FROM `liste noir`";
            pst = connectDB.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                observableList.add(new liste_noire(
                        rs.getString("Matricule"),
                        rs.getString("Marque"),
                        rs.getString("Etat")));
                table.setItems(observableList);
            }
            pst.close();
            rs.close();
            SearchAction();
           // fill();
        } catch (SQLException ex) {
            Logger.getLogger(liste_noire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //bouton ajouter à la base de données
    public void ajouter() {
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.connectionDuBd();
            String matricule=MatriculeFld.getText();
            String marque=MarqueFld.getText();
            SingleSelectionModel etat= EtatFld.getSelectionModel();
            Statement statement=connectDB.createStatement();
            if(matricule.isEmpty()||marque.isEmpty()||etat.isEmpty()){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Remplir tous les champs");
                alert.showAndWait();
                Stage stage = (Stage) ajouterbtn.getScene().getWindow();
                stage.toFront();
                return;
        }else{
                int status=statement.executeUpdate("INSERT INTO `liste noir`(`matricule`, `marque`, `etat`) VALUES ('"+matricule+"','"+marque+"','"+EtatFld.getValue()+"')");
                if(status>0)
                {
                    JOptionPane.showMessageDialog(null,"Ajout avec succes");
                    clean();
                    refreshTableAction();
                }
                else{ JOptionPane.showMessageDialog(null,"erreur");
                }
            }
    } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

//effacer les field Text
    @FXML private void clean() {
        MatriculeFld.setText(null);
        MarqueFld.setText(null);
        EtatFld.setValue(null);
    }

    ///Method pour remplir le tableview de la base de donnes
    public void  fill() {
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.connectionDuBd();
            ResultSet rs = connectDB.createStatement().executeQuery("SELECT * FROM `liste noir` ");
            while(rs.next())
            {
                observableList.add(new liste_noire(rs.getString("matricule"),rs.getString("marque"),rs.getString("etat")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        MatriculeCol.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        MarqueCol.setCellValueFactory(new PropertyValueFactory<>("marque"));
        EtatCol.setCellValueFactory(new PropertyValueFactory<>("etat"));
        table.setItems(observableList);
    }

    ////Bouton Supprimer
    private liste_noire liste_noire;
   @FXML public void Supprimer() {
        int action = JOptionPane.showConfirmDialog(null, "Confirmer votre suppession?");
        if (action == 0) {
            try {
                liste_noire liste = table.getSelectionModel().getSelectedItem();
                if (liste != null) {
                    DatabaseConnection connectNow = new DatabaseConnection();
                    Connection connectDB = connectNow.connectionDuBd();
                    Statement statement = connectDB.createStatement();
                    statement.executeUpdate("DELETE FROM `liste noir` WHERE matricule='"+liste.getMatricule()+"'");
                    refreshTableAction();
                }
                else {JOptionPane.showMessageDialog(null,"Selectionne element que vouler supprimer");}
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public void SearchAction()  {
            // Enveloppez la ObservableList dans une FilteredList (affichez initialement toutes les données).
            FilteredList<liste_noire> filteredData = new FilteredList<>(observableList, b -> true);
            // 2. Définissez le prédicat du filtre chaque fois que le filtre change.
            Search.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(liste_noire -> {
                    // Si le texte du filtre est vide, affichez tout la listes.
                    if (newValue == null || newValue.isEmpty()) {
                        return true; }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (liste_noire.getMatricule().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                        return true;
                    } else if (liste_noire.getMarque().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    }
                    else if (String.valueOf(liste_noire.getEtat()).indexOf(lowerCaseFilter)!=-1)
                        return true;
                    else
                        return false; // Does not match.
                }); });
            SortedList<liste_noire> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(table.comparatorProperty());
            table.setItems(sortedData);
        }

    //remplir les textfield di en clique sur la table
    public void Selectionne(){
        liste_noire lt = table.getSelectionModel().getSelectedItem();
        MatriculeFld.setText(lt.getMatricule());
        MarqueFld.setText(lt.getMarque());
        EtatFld.setValue(lt.getEtat());
    }

   //Bouton modifier
    public void editAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        liste_noire lt = table.getSelectionModel().getSelectedItem();
        String Matricule=MatriculeFld.getText();
        String Marque=MarqueFld.getText();
        SingleSelectionModel Etat=EtatFld.getSelectionModel();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectionDuBd();
        Statement statement=connectDB.createStatement();
        if(Matricule.isEmpty()||Marque.isEmpty()||Etat.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Remplir tous les champs");
            alert.showAndWait();
            return;
        }
        else{
            int status=statement.executeUpdate("Update `liste noir` set matricule='"+Matricule+"',marque='"+Marque+"',etat='"+EtatFld.getValue()+"' where matricule='"+lt.getMatricule()+"'");
            if(status>0)
            {
                JOptionPane.showMessageDialog(null,"Modification avec succes ");
                //table.getItems().clear();
                //fill();
                refreshTableAction();
            }
            else{ JOptionPane.showMessageDialog(null,"erreur");
            }
        }
    }

 }
