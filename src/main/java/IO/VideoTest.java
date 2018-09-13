package IO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;


import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.Java2DFrameConverter;


import javax.imageio.ImageIO;

/**
 * Java截取视频第一帧
 *
 * @author daiwei
 * @date 2018/9/13 11:28
 */
public class VideoTest {


    /**
     * 获取指定视频的帧并保存为图片至指定目录
     *
     * @param videofile 源视频文件路径
     * @param framefile 截取帧的图片存放路径
     * @throws Exception
     */
    public static void fetchFrame(String videofile, String framefile)
            throws IOException {
        long start = System.currentTimeMillis();
        File targetFile = new File(framefile);
        FFmpegFrameGrabber ff = FFmpegFrameGrabber.createDefault(videofile);
        ff.start();
        int i = 0;
        int lenght = ff.getLengthInFrames();
        Frame f = null;
        while (i < lenght) {
            f = ff.grabFrame();
            if (f.image != null) {
                break;
            }
            i++;
        }

        int owidth = f.imageWidth;
        int oheight = f.imageHeight;
        // 对截取的帧进行等比例缩放
        // 对截取的帧进行等比例缩放
        int width = 800;
        int height = (int) (((double) width / owidth) * oheight);
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
//        bi.getGraphics().drawImage(bi.getScaledInstance(width, height,  Image.SCALE_SMOOTH),
//                0, 0, null);
        ImageIO.write(bi, "jpg", targetFile);
        ff.flush();
        ff.stop();
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void main(String[] args) throws IOException {
        try {
 //           VideoTest.fetchFrame("d:/0b8b72198a57383f3bb5b6d6c22ab177.mp4", "d:/test5.jpg");
                  fetchFirstGrabberFFmpegImage("d:/0b8b72198a57383f3bb5b6d6c22ab177.mp4", "./target", "月赋情长", 10);

            //          randomGrabberFFmpegImage("d:/0b8b72198a57383f3bb5b6d6c22ab177.mp4", "./target", "月赋情长", 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过javacv对视频每隔1秒钟截取1张图片
     *
     * @param filePath
     * @param targerFilePath
     * @param targetFileName
     * @param randomSize
     * @throws Exception
     * @sees https://www.cnblogs.com/softidea/p/6102749.html
     */
    public static void randomGrabberFFmpegImage(String filePath, String targerFilePath, String targetFileName, int randomSize)
            throws Exception {
        FFmpegFrameGrabber ff = FFmpegFrameGrabber.createDefault(filePath);
        ff.start();
        int ffLength = ff.getLengthInFrames();
        List<Integer> randomGrab = random(ffLength, randomSize);
        int maxRandomGrab = randomGrab.get(randomGrab.size() - 1);
        Frame f;
        int i = 0;
        while (i < ffLength) {
            f = ff.grabImage();
            if (randomGrab.contains(i)) {
                doExecuteFrame(f, targerFilePath, targetFileName, i);
            }
            if (i >= maxRandomGrab) {
                break;
            }
            i++;
        }
        ff.stop();
    }


    /**
     * Java截取视频第一帧
     *
     * @param filePath
     * @param targerFilePath
     * @param targetFileName
     * @param randomSize
     * @throws Exception
     */
    public static void fetchFirstGrabberFFmpegImage(String filePath, String targerFilePath, String targetFileName, int randomSize)
            throws Exception {
        FFmpegFrameGrabber ff = FFmpegFrameGrabber.createDefault(filePath);
        ff.start();
        Frame f;
        int i = 0;
        f = ff.grabImage();
        doExecuteFrame(f, targerFilePath, targetFileName, i);
        ff.stop();
    }


    public static void doExecuteFrame(Frame f, String targerFilePath, String targetFileName, int index) {
        if (null == f || null == f.image) {
            return;
        }

        Java2DFrameConverter converter = new Java2DFrameConverter();

        String imageMat = "jpg";
        String FileName = targerFilePath + File.separator + targetFileName + "_" + index + "." + imageMat;
        BufferedImage bi = converter.getBufferedImage(f);
        File output = new File(FileName);
        try {
            ImageIO.write(bi, imageMat, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> random(int baseNum, int length) {

        List<Integer> list = new ArrayList<Integer>(length);
        while (list.size() < length) {
            Integer next = (int) (Math.random() * baseNum);
            if (list.contains(next)) {
                continue;
            }
            list.add(next);
        }
        //       Collections.sort(list);
        return list;
    }

}
