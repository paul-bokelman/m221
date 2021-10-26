package com.example.sping_portfolio.controllers.asciiart;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class ASCIIArt {
    public static final String GRAYSCALE_CHARS = "@#BW8gMN6&9RQqE0d$DbpmOa5AH2GZeKPS3X4U%kwohFVyzIsCu{xfn}tJTi17c=jYL?l[]v<>+|)r(/\\*_!;^~\":,-'.`";
    public static final double[] GRAYSCALE_VALUES = new double[]{0.0D, 0.07863D, 0.08205D, 0.1316D, 0.1453D, 0.147D, 0.1504D, 0.1641D, 0.1761D, 0.1761D, 0.1778D, 0.2017D, 0.2154D, 0.2274D, 0.2274D, 0.2291D, 0.2427D, 0.2598D, 0.2615D, 0.2684D, 0.2752D, 0.2769D, 0.2889D, 0.2923D, 0.294D, 0.2974D, 0.3026D, 0.3077D, 0.3077D, 0.3094D, 0.3162D, 0.3197D, 0.3333D, 0.3333D, 0.3385D, 0.3538D, 0.3607D, 0.3795D, 0.3846D, 0.4017D, 0.4034D, 0.4068D, 0.4291D, 0.4325D, 0.4444D, 0.4598D, 0.4632D, 0.4667D, 0.4752D, 0.4855D, 0.5077D, 0.5128D, 0.5128D, 0.5128D, 0.5179D, 0.5214D, 0.5231D, 0.535D, 0.535D, 0.5368D, 0.5385D, 0.5436D, 0.5624D, 0.5624D, 0.5624D, 0.5641D, 0.5778D, 0.5829D, 0.5846D, 0.5863D, 0.5863D, 0.5915D, 0.6017D, 0.6068D, 0.641D, 0.6581D, 0.6889D, 0.694D, 0.6974D, 0.7333D, 0.7333D, 0.7402D, 0.7675D, 0.7744D, 0.7863D, 0.8068D, 0.8342D, 0.8427D, 0.8598D, 0.894D, 0.947D, 0.959D, 0.9675D, 1.0D};
    public static final String[] GRAYSCALE_LIST = new String[]{"@", "#", "B", "W", "8", "g", "M", "N", "6", "&", "9", "R", "Q", "q", "E", "0", "d", "$", "D", "b", "p", "m", "O", "a", "5", "A", "H", "2", "G", "Z", "e", "K", "P", "S", "3", "X", "4", "U", "%", "k", "w", "o", "h", "F", "V", "y", "z", "I", "s", "C", "u", "{", "x", "f", "n", "}", "t", "J", "T", "i", "1", "7", "c", "=", "j", "Y", "L", "?", "l", "[", "]", "v", "<", ">", "+", "|", ")", "r", "(", "/", "/", "*", "_", "!", ";", "^", "~", "/", ":", ",", "-", "'", ".", "`"};

    public ASCIIArt() {
    }

    public static double getBrightness(Color c) {
        double br = 0.3D * ((double)c.getRed() / 255.0D) + 0.59D * ((double)c.getGreen() / 255.0D) + 0.11D * ((double)c.getBlue() / 255.0D);
        int idx = 0;
        double a = Math.abs(GRAYSCALE_VALUES[0] - br);

        for(int i = 0; i < GRAYSCALE_VALUES.length - 1; ++i) {
            double brval = Math.abs(GRAYSCALE_VALUES[i] - br);
            if (brval < a) {
                idx = i;
                a = brval;
            }
        }

        String ascii = GRAYSCALE_LIST[idx];
        System.out.print(ascii);
        return br;
    }

    public static double[][] getGrayscaleArray(Picture picture) {
        int rows = picture.height();
        int cols = picture.width();
        double[][] img = new double[rows][cols];

        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < cols; ++j) {
                img[i][j] = getBrightness(picture.get(j, i));
            }

            System.out.println("");
        }

        return img;
    }

    public byte[] Grayscale() {
        try {
            BufferedImage img = ImageIO.read(new URL("https://assets.epicurious.com/photos/54b0226d766062b20344580a/4:3/w_775,h_581,c_limit/51160200_glazed-doughnuts_1x1.jpg"));

            for(int x = 0; x < img.getWidth(); ++x) {
                for(int y = 0; y < img.getHeight(); ++y) {
                    int rgb = img.getRGB(x, y);
                    int r = rgb >> 16 & 255;
                    int g = rgb >> 8 & 255;
                    int b = rgb & 255;
                    float rr = (float)Math.pow((double)r / 255.0D, 2.2D);
                    float gg = (float)Math.pow((double)g / 255.0D, 2.2D);
                    float bb = (float)Math.pow((double)b / 255.0D, 2.2D);
                    float lum = (float)(0.2126D * (double)rr + 0.7152D * (double)gg + 0.0722D * (double)bb);
                    int grayLevel = (int)(255.0D * Math.pow((double)lum, 0.45454545454545453D));
                    int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel;
                    img.setRGB(x, y, gray);
                }
            }
        } catch (IOException var14) {
            var14.printStackTrace();
        }

        return null;
    }

    byte[] pixelgrayscale(byte[] pixelsIn) {
        byte[] newPixelByte = new byte[pixelsIn.length];

        for(int i = 0; i < pixelsIn.length; i += 4) {
            float val = 0.0F;

            for(int y = 1; y < 4; ++y) {
                val = (float)((double)val + (double)(pixelsIn[i + y] & 255) / 3.0D);
            }

            newPixelByte[i] = pixelsIn[i];
            newPixelByte[i + 1] = (byte)((int)val);
            newPixelByte[i + 2] = (byte)((int)val);
            newPixelByte[i + 3] = (byte)((int)val);
        }

        return newPixelByte;
    }

    byte[] blockImg(byte[] imgBlock) {
        byte[] newimgBlock = new byte[imgBlock.length];

        for(int i = 0; i < imgBlock.length; i += 4) {
            float val = 0.0F;

            for(int y = 1; y < 4; ++y) {
                val = (float)((double)val + (double)(imgBlock[i + y] & 255) / 3.0D);
            }

            newimgBlock[i] = imgBlock[i];
            newimgBlock[i + 1] = (byte)((int)val);
            newimgBlock[i + 2] = (byte)((int)val);
            newimgBlock[i + 3] = (byte)((int)val);
        }

        return newimgBlock;
    }

    public static void main(String[] args) {
        String str1 = "https://media-exp1.licdn.com/dms/image/C5603AQHX99eI6ZCt8g/profile-displayphoto-shrink_400_400/0/1526055499066?e=1640217600&v=beta&t=o9H9eqSwzH101zS9x1JCK7Ju8jxV6VmpsxA6Own-7zg";
        String str2 = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/474.png";
        String str3 = "";

        Picture picture = new Picture(str1);

        /*String input = "";
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Which picture would you like to ASCII-ify today? (1/2/3/c): ");
            input = s.nextLine();
            input = input.substring(0, 1);
            System.out.println(input);
            if (input == "1") {
                picture = new Picture(str1);
                break;
            }
            if (input == "2") {
                picture = new Picture(str2);
                break;
            }
            if (input == "3") {
                picture = new Picture(str3);
                break;
            }
            if (input == "custom") {
                String url = s.nextLine();
                    try {
                        picture = new Picture(url);
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("Please input a valid url!");
                    }
                break;
            }
            System.out.println(input);
        }*/

        try {
            PrintStream originalOut = System.out;
            PrintStream fileOut = new PrintStream(".\\src\\main\\java\\com\\example\\sping_portfolio\\controllers\\asciiart\\out.txt");
            System.setOut(fileOut);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        double[][] image = getGrayscaleArray(picture);
    }
}
