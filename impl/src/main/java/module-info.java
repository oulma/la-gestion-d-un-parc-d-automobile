module com.ceft.gestionparc.Controller {
    requires org.bytedeco.opencv;
    requires org.bytedeco.javacv;
    requires java.desktop;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    requires javafx.media;
    requires  org.bytedeco.javacv.platform;
    requires org.bytedeco.javacpp.windows.x86_64;
    requires org.bytedeco.openblas.windows.x86_64;
    requires org.bytedeco.opencv.windows.x86_64;
    requires org.bytedeco.ffmpeg;
    requires org.bytedeco.videoinput.windows.x86_64;
    requires org.bytedeco.leptonica.windows.x86_64;
    requires org.bytedeco.artoolkitplus.windows.x86_64;
    requires org.bytedeco.libdc1394.windows.x86_64;
    requires org.bytedeco.libfreenect.windows.x86_64;
    requires org.bytedeco.libfreenect2.windows.x86_64;
    requires org.bytedeco.librealsense.windows.x86_64;
    requires org.bytedeco.librealsense2.windows.x86_64;
    requires org.bytedeco.flandmark.windows.x86_64;
    requires org.bytedeco.flycapture.windows.x86_64;
    requires org.bytedeco.tesseract.windows.x86_64;
    requires javafx.swing;
    opens com.ceft.gestionparc.Model to javafx.graphics;
    exports com.ceft.gestionparc.Model;
    opens com.ceft.gestionparc.Controller to javafx.fxml;
    exports com.ceft.gestionparc.Controller;

}