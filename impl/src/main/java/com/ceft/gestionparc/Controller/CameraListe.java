package com.ceft.gestionparc.Controller;
import com.ceft.gestionparc.DbConnection.DatabaseConnection;
import com.ceft.gestionparc.Model.Parking;
import com.ceft.gestionparc.Model.Voiture;
import com.ceft.gestionparc.utils.Utils;
import com.openalpr.jni.Alpr;
import com.openalpr.jni.AlprException;
import com.openalpr.jni.AlprPlateResult;
import com.openalpr.jni.AlprResults;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.stage.Stage;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.videoio.VideoCapture;
import javax.imageio.ImageIO;
 import org.controlsfx.control.Notifications;
public class CameraListe  implements Initializable {
    private ScheduledExecutorService timer;
    private VideoCapture capture = new VideoCapture();
    private boolean cameraActive;
    Point clickedPoint = new Point(0, 0);
    static	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static	java.util.Date date = new java.util.Date();
    static	String strDate = sdf.format(date);

 private final ObservableList<Voiture> listV= FXCollections.observableArrayList();
    @FXML
    private TableView<Voiture> table;
    private DashboardController dh =new DashboardController();
    @FXML
    private TableColumn<Voiture,Integer> ID;

    @FXML
    private TableColumn<Voiture, String> Matricule;

    @FXML
    private TableColumn<Voiture, String> DateEntree;

    @FXML
     private ImageView originalFrame;

   // @FXML
   // private MediaView mediaView;
    @FXML
    private Button cameraButton;
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    private static int id =0;
    @FXML private ImageView Cameraliste,AjouterCompte,statistic,reservation,archive,ListeNoire,paiment;
    @FXML private Button greenButton, redButton, yellowButton;
    @FXML private ImageView image_admin;
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        Parking parking = new Parking();
        parking.getVoiture().clear();
        try {
            parking.SQLajouterVoiture();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        File CameralisteFile = new File("_img/_camera.png");
        Image CameralisteImage = new Image(CameralisteFile.toURI().toString());
        Cameraliste.setImage(CameralisteImage);

        File Cameraliste1File = new File("_img/admin.png");
        Image Cameraliste1Image = new Image(Cameraliste1File.toURI().toString());
        image_admin.setImage(Cameraliste1Image);

        File AjouterCompteFile = new File("_img/new-user.png");
        Image AjouterCompteImage = new Image(AjouterCompteFile.toURI().toString());
        AjouterCompte.setImage(AjouterCompteImage);


        File statisticFile = new File("_img/statistics.png");
        Image statisticImage = new Image(statisticFile.toURI().toString());
        statistic.setImage(statisticImage);

        File reservationFile = new File("_img/reservation.png");
        Image reservationImage = new Image(reservationFile.toURI().toString());
        reservation.setImage(reservationImage);

        File archiveFile = new File("_img/_archive.png");
        Image archiveImage = new Image(archiveFile.toURI().toString());
        archive.setImage(archiveImage);

        File ListeNoireFile = new File("_img/blocked.png");
        Image ListeNoireImage = new Image(ListeNoireFile.toURI().toString());
        ListeNoire.setImage(ListeNoireImage);

        File paimentFile = new File("_img/save-money.png");
        Image paimentImage = new Image(paimentFile.toURI().toString());
        paiment.setImage(paimentImage);

        ID.setCellValueFactory(new PropertyValueFactory<>("IdV"));
        Matricule.setCellValueFactory(new PropertyValueFactory<>("Matricule"));
        DateEntree.setCellValueFactory(new PropertyValueFactory<>("DateEntrer"));

        // file = new File("_img/plaka4.mp4");
        //  media= new Media(file.toURI().toString());
        //  mediaPlayer= new MediaPlayer(media);
        // mediaView.setMediaPlayer(mediaPlayer);

    }

    public void redButtonOnAction() {
        Stage stage = (Stage) redButton.getScene().getWindow();
        stage.close();
    }
    public void yellowButtonOnAction() {
        Stage stage = (Stage) yellowButton.getScene().getWindow();
        stage.toBack();
    }
    public void greenButtonOnAction() {
        Stage stage = (Stage) greenButton.getScene().getWindow();
        //Nous devons le changer On maximiser l'ecrant
        stage.toBack();
    }

    private void ajouterVoitByDet(String m,String d) throws SQLException, ClassNotFoundException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectionDuBd();
        String addVoitureSQL = "INSERT INTO `voiture` (`matricule`, `dateEntrée`) VALUES ('"+m+"','"+d+"')";
        String deletDup = "DELETE S1 FROM voiture AS S1  \n" +
                "INNER JOIN voiture AS S2   \n" +
                "WHERE S1.id < S2.id AND S1.matricule = S2.matricule; ";

        Statement statement = connectDB.createStatement();
        statement.executeUpdate(addVoitureSQL);
        statement.executeUpdate(deletDup);

    }

    private void remplireTableview() throws SQLException, ClassNotFoundException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectionDuBd();
        String countHowManyCarInPark = "SELECT * FROM voiture";
        Statement statement = connectDB.createStatement();
        ResultSet rs = statement.executeQuery(countHowManyCarInPark);

        while (rs.next()) {
            Voiture v = new Voiture(rs.getInt("id"), rs.getString("matricule"), rs.getString("dateEntrée"));
            table.getItems().add(v);
        }

             connectNow = new DatabaseConnection();
             connectDB = connectNow.connectionDuBd();
            String checkListNoir = "SELECT * FROM `liste noir`";
             statement = connectDB.createStatement();
            ResultSet rs1 = statement.executeQuery(checkListNoir);
        while (rs.next())
        {

            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    if(true){
                        Notifications.create()
                                .title("Warning")
                                .text("Voiture Liste noire")
                                .showError();

                    }
                }
// do your GUI stuff here
            });
        }






        }


    public CameraListe() { };
    @FXML
    protected void startCamera()
    {
        // set a fixed width for the frame
       // originalFrame.setFitWidth(450);
       // originalFrame.setFitHeight(300);
        // preserve image ratio
       originalFrame.setPreserveRatio(true);

        // mouse listener
        originalFrame.setOnMouseClicked(e -> {
            System.out.println("[" + e.getX() + ", " + e.getY() + "]");
            clickedPoint.x = e.getX();
            clickedPoint.y = e.getY();
        });

        if (!this.cameraActive)
        {

            // commancer la capture de video
            String cameraVideo = "_img/plaka4.mp4";
            this.capture.open(cameraVideo);

            // is the video stream available?
            if (this.capture.isOpened())
            {
                this.cameraActive = true;

                // grab a frame every 33 ms (30 frames/sec)
                Runnable frameGrabber = new Runnable() {

                    @Override
                    public void run()
                    {
                        // effectively grab and process a single frame
                        Mat frame = grabFrame();
                        // convert and show the frame
                        Image imageToShow = Utils.mat2Image(frame);
                        updateImageView(originalFrame, imageToShow);
                    }
                };

                this.timer = Executors.newSingleThreadScheduledExecutor();
                this.timer.scheduleAtFixedRate(frameGrabber, 0, 33, TimeUnit.MILLISECONDS);

                // update the button content
                this.cameraButton.setText("Stop Camera");
               
            }
            else
            {
                // log the error
                System.err.println("Failed to open the camera connection...");
            }
        }
        else
        {
            // the camera is not active at this point
            this.cameraActive = false;
            // update again the button content
            this.cameraButton.setText("Start Camera");


            // stop the timer
            this.stopAcquisition();
        }
    }

    private Mat grabFrame()
    {
        Mat frame = new Mat();

        // check if the capture is open
        if (this.capture.isOpened())
        {
            try
            {
                // read the current frame
                this.capture.read(frame);

                // if the frame is not empty, process it
                if (!frame.empty())
                {
                    try {
                        BufferedImage img = Utils.matToBufferedImage(frame);

                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(img, "png", baos);
                        baos.flush();
                        byte[] imageInByte = baos.toByteArray();
                        baos.close();
                        System.out.println("alpr commancer le travail...");
                        Alpr alpr = new Alpr("eu", "openalpr.conf", "runtime_data");
                        // Set top N candidates returned to 20
                        alpr.setTopN(10);
                        // Set pattern to Maryland
                        alpr.setDefaultRegion("md");
                        AlprResults results = alpr.recognize(imageInByte);
                        for (AlprPlateResult result : results.getPlates()) {
                            if (result.getBestPlate().getCharacters() != null) {
                                id++;
                                //listV.add(new Voiture(id,result.getBestPlate().getCharacters(),strDate));
                               // Voiture v = new Voiture(result.getBestPlate().getCharacters(),strDate);
                             //   table.getItems().add(v);
                                // cvSaveImage("_img/" + result.getBestPlate().getCharacters() + "_.jpg", frame);
                                System.out.println("ra9m lmatricule howa :"+result.getBestPlate().getCharacters());
                                ajouterVoitByDet(result.getBestPlate().getCharacters(),strDate);
                                remplireTableview();
                                //---------------------------------------------------------//

                                //---------------------------------------------------------//
                            }
                        }
                        alpr.unload();


                    }catch(IOException | AlprException e1){
                        e1.printStackTrace();
                    }
                }
            }
            catch (Exception e)
            {
                // log the (full) error
                System.err.print("Exception in the image elaboration...");
                e.printStackTrace();
            }
        }

        return frame;
    }

    private void updateImageView(ImageView view, Image image)
    {
        Utils.onFXThread(view.imageProperty(), image);
    }

    private void stopAcquisition()
    {
        if (this.timer != null && !this.timer.isShutdown())
        {
            try
            {
                // stop the timer
                this.timer.shutdown();
                this.timer.awaitTermination(33, TimeUnit.MILLISECONDS);
            }
            catch (InterruptedException e)
            {
                // log any exception
                System.err.println("Exception in stopping the frame capture, trying to release the camera now... " + e);
            }
        }

        if (this.capture.isOpened())
        {
            // release the camera
            this.capture.release();
        }
    }


    //public void playVideio(ActionEvent actionEvent) throws AlprException, IOException {
    //    mediaPlayer.play();
       //int width = mediaPlayer.getMedia().getWidth();
       // int height = mediaPlayer.getMedia().getHeight();
       // WritableImage wim = new WritableImage(width, height);
       // MediaView mv = new MediaView();
       // mediaView.setFitWidth(width);
       // mediaView.setFitHeight(height);
      //  mediaView.setMediaPlayer(mediaPlayer);
       // mediaView.snapshot(null, wim);




//}


    //public void pauseVideio(ActionEvent actionEvent) {
      //  mediaPlayer.pause();
    //}


    @FXML
    private Button ajouterMombreRS,StatistiqueC,réservation,archivee,listenoire,montant;

    public void ajouterAnction(ActionEvent event) {
        DashboardController dh = new DashboardController();
        dh.showAjouterMember();
        Stage stage = (Stage)  ajouterMombreRS.getScene().getWindow();
        stage.close();
    }

    public void StatistiqueAnction(ActionEvent event) {
        DashboardController dh = new DashboardController();
        dh.showStatistique();
        Stage stage = (Stage)  StatistiqueC.getScene().getWindow();
        stage.close();
    }

    public void anction(ActionEvent event) {
        DashboardController dh = new DashboardController();
        dh.showReservation();
        Stage stage = (Stage)  réservation.getScene().getWindow();
        stage.close();
    }

    public void archiveAnction(ActionEvent event) {
        DashboardController dh = new DashboardController();
        dh.showArchive();
        Stage stage = (Stage)  archivee.getScene().getWindow();
        stage.close();
    }

    public void listenoireAnction(ActionEvent event) {
        DashboardController dh = new DashboardController();
        dh.showListeNoire();
        Stage stage = (Stage) listenoire .getScene().getWindow();
        stage.close();
    }

    public void montantAction(ActionEvent event) {
        DashboardController dh = new DashboardController();
        dh.showMontant();
        Stage stage = (Stage) montant .getScene().getWindow();
        stage.close();
    }


    public void dashboardOnAction(ActionEvent actionEvent) {
        DashboardController dh = new DashboardController();
        dh.goToDashboard();
    }
}
