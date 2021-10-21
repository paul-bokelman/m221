package com.example.sping_portfolio.controllers.asciiart;

public class Drawing {
    public Drawing() {
    }

    public static void showPic(int[][] r, int[][] g, int[][] b) {
        int height = r.length;
        int width = r[0].length;
        Picture pic = new Picture(width, height);

        for(int row = 0; row < height; ++row) {
            for(int col = 0; col < width; ++col) {
                int rgb = r[row][col] << 16 | g[row][col] << 8 | b[row][col];
                pic.setRGB(col, row, rgb);
            }
        }

        pic.show();
    }

    public static void videoExample() {
        int[][] r = new int[400][500];
        int[][] g = new int[400][500];
        int[][] b = new int[400][500];

        int index;
        int value;
        for(index = 20; index < 100; ++index) {
            for(value = 50; value < 80; ++value) {
                r[index][value] = 255;
            }
        }

        for(index = 50; index < 80; ++index) {
            for(value = 20; value < 100; ++value) {
                b[index][value] = 255;
            }
        }

        for(index = 0; index < r.length && index < r[0].length; ++index) {
            value = index;
            if (index > 255) {
                value = 255;
            }

            r[index][index] = value;
            g[index][index] = value;
            b[index][index] = value;
        }

        showPic(r, g, b);
    }

    public static void drawCircle(int[][] r, int[][] g, int[][] b, double cx, double cy, double radius) {
        for(int i = 0; i < r.length; ++i) {
            for(int j = 0; j < r[i].length; ++j) {
                double x = (double)j;
                double y = (double)i;
                double distSqr = Math.pow(x - cx, 2.0D) + Math.pow(y - cy, 2.0D);
                if (distSqr <= radius * radius) {
                    r[i][j] = 255;
                    b[i][j] = 255;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] r = new int[400][500];
        int[][] g = new int[400][500];
        int[][] b = new int[400][500];
        drawCircle(r, g, b, 300.0D, 100.0D, 50.0D);
        drawCircle(r, g, b, 100.0D, 200.0D, 20.0D);
        drawCircle(r, g, b, 300.0D, 300.0D, 100.0D);
        showPic(r, g, b);
    }
}
