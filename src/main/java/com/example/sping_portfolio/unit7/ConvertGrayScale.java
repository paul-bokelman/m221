package com.example.sping_portfolio.unit7;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ConvertGrayScale {
    public static void main(String... args) {
        String name = "yeongjoong";
        try {
            File input = new File (String.format("src/main/resources/static/images/grayscale/gen/%s.png", name));
            BufferedImage image = ImageIO.read(input);
            BufferedImage result = new BufferedImage(
                    image.getWidth(),
                    image.getHeight(),
                    BufferedImage.TYPE_INT_RGB);

            Graphics2D graphic = result.createGraphics();
            graphic.drawImage(image, 0, 0, Color.WHITE, null);
            for (int i = 0; i < result.getHeight(); i++) {
                for (int j = 0; j < result.getWidth(); j++) {
                    Color c = new Color(result.getRGB(j, i));
                    int red = (int) (c.getRed() * 0.299);
                    int green = (int) (c.getGreen() * 0.587);
                    int blue = (int) (c.getBlue() * 0.114);
                    Color newColor = new Color(
                            red + green + blue,
                            red + green + blue,
                            red + green + blue);
                    result.setRGB(j, i, newColor.getRGB());
                }
            }
            File output = new File(String.format("src/main/resources/static/images/grayscale/res/%s.png", name));
            ImageIO.write(result, "png", output);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
