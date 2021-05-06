package com.ceft.gestionparc.Model;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.opencv.opencv_core.IplImage;
 import  org.bytedeco.ffmpeg.global.avutil;
import org.bytedeco.ffmpeg.avcodec.*;
import org.bytedeco.ffmpeg.avutil.*;

import java.awt.image.BufferedImage;


public class camera implements Runnable {

    //FrameGrabber grabber ;
    FFmpegFrameGrabber grabber;

    IplImage resize;
    static IplImage grabimage;
    String dosyaYolu,format,
            plakaString="",yeni="";
    BufferedImage VideoGiris;
    double frameRate=0.0;
    OpenCVFrameConverter.ToIplImage converterIPL = new OpenCVFrameConverter.ToIplImage();
    Java2DFrameConverter convertToBuffer = new Java2DFrameConverter();
    OpenCVFrameConverter.ToMat convertToMat =  new OpenCVFrameConverter.ToMat();
    private Boolean stop = false;


    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public static IplImage getGrabimage() {
        return grabimage;
    }

    public void  setGrabimage(IplImage grabimage) {
        this.grabimage = grabimage;
    }

    public IplImage getResize() {
        return resize;
    }

    public void setResize(IplImage resize) {
        this.resize = resize;
    }


    public String getDosyaYolu() {
        return dosyaYolu;
    }

    public void setDosyaYolu(String dosyaYolu) {
        this.dosyaYolu = dosyaYolu;
    }


    public void run(){

        while(!stop){

            //grabber= new FFmpegFrameGrabber("rtsp://192.168.1.10:554/user=admin&password=&channel=1&stream=0.sdp?");
            grabber = new FFmpegFrameGrabber("_img/plaka4.mp4");
            //grabber.setFormat("h264");
            //grabber.setPixelFormat(avutil.AV_PIX_FMT_YUV422P);
            //grabber.setVideoOption("preset", "veryfast");
            //grabber.setVideoBitrate(2305);
            //	grabber.setFormat("mp4");
            //	grabber.setFormat(getFormat());
            //grabber.setVideoCodec(avcodec.AV_CODEC_ID_MPEG4);
            //grabber.setVideoCodec(avcodec.AV_CODEC_ID_MP4ALS);
            //
            //grabber.setImageWidth(800);
            //grabber.setImageHeight(600);

            // grabber.setPixelFormat(3);
            //grabber.setAudioChannels(0);
            // grabber.setFrameRate(30);
            //grabber.setVideoCodec(5);
            //grabber.setFormat("gdigrab"); //ekran kaydedici
            //grabber.restart();
            try{
                grabber.start();
                // VideoGiris=convertBufferedImage.convert(converterToIpl.convert(grabimage));
                frameRate = grabber.getFrameRate();
                //System.out.println(frameRate);


            }catch(FrameGrabber.Exception e){
                e.printStackTrace();

            }

            try {
                grabimage=converterIPL.convertToIplImage(grabber.grabFrame());
                resize = IplImage.create(680, 480, grabimage.depth(),grabimage.nChannels());
                while (grabber.grab()!=null) {
                    //cvResize(grabimage, resize);
                    //AnaPencere.videoGirisLabel.setIcon(new ImageIcon(convertToBuffer.convert(converterIPL.convert(resize))));
                    //grabber.setFrameNumber(counter);
                    Thread.sleep((long) Math.round(frameRate));


                    //System.out.println(grabber.getFrameNumber());
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
    public Boolean getStop() {
        return stop;
    }

    public void setStop(Boolean stop) {
        this.stop = stop;
    }
}
