package com.example.sping_portfolio.unit7;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;


//class for grayscale

    public class GrayScale {
        private static BufferedImage image;
        private static int width;
        private static int height;

//        String prefix = "";
//        static String[] arr = {"images/ishaan.jpg", "images/justinli.jpg", "images/lucapinto.jpg", "images/mort.jpg", "images/paulbok.jpg", "images/rohankos.jpg", "images/roop.jpg", "images/rynamog.jpg", "images/sammahj.jpg", "images/yeongjoong.jpg"};

        public static void GrayScale(File input, String outputName) {

            try {
                image = ImageIO.read(input);
                width = image.getWidth();
                height = image.getHeight();

                for (int i = 0; i < height; i++) {

                    for (int j = 0; j < width; j++) {

                        Color c = new Color(image.getRGB(j, i));
                        int red = (int) (c.getRed() * 0.299);
                        int green = (int) (c.getGreen() * 0.587);
                        int blue = (int) (c.getBlue() * 0.114);
                        Color newColor = new Color(red + green + blue,

                                red + green + blue, red + green + blue);

                        image.setRGB(j, i, newColor.getRGB());
                    }
                }

                File output = new File(outputName);
                ImageIO.write(image, "jpg", output);

            } catch (Exception e) {
                System.out.println("error with grayscale!");
                System.out.println(e);
            }
        }
    }
