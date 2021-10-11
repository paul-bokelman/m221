//package com.example.sping_portfolio.unit7;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//
//
//public class WaterMark {
//    static void addImageWatermark(File watermarkImageFile, File sourceImageFile, File destImageFile) {
//
//        try {
//            BufferedImage sourceImage = ImageIO.read(sourceImageFile);
//            BufferedImage watermarkImage = ImageIO.read(watermarkImageFile);
//
//            // initializes necessary graphic properties
//            Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
//            AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
//            g2d.setComposite(alphaChannel);
//
//            // calculates the coordinate where the image is painted
//            int topLeftX = (sourceImage.getWidth() - watermarkImage.getWidth()) / 2;
//            int topLeftY = (sourceImage.getHeight() - watermarkImage.getHeight()) / 2;
//
//            // paints the image watermark
//            g2d.drawImage(watermarkImage, topLeftX, topLeftY, null);
//
//            ImageIO.write(sourceImage, "png", destImageFile);
//            g2d.dispose();
//
//            System.out.println("The image watermark is added to the image.");
//
//        } catch(
//        IOException ex)
//
//        {
//            System.err.println(ex);
//        }
//    }
//}
