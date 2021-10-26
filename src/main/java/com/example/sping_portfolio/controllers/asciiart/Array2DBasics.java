package com.example.sping_portfolio.controllers.asciiart;

public class Array2DBasics {
    public Array2DBasics() {
    }

    public static void printArray(double[][] x, boolean showCommas) {
        for(int i = 0; i < x.length; ++i) {
            for(int j = 0; j < x[i].length; ++j) {
                System.out.print(x[i][j]);
                if (showCommas && j < x[i].length - 1) {
                    System.out.print(",");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.print("\n");
        }

    }

    public static void main(String[] args) {
        double[][] x = new double[20][15];

        int index;
        int j;
        for(index = 0; index < 5; ++index) {
            for(j = 0; j < 6; ++j) {
                x[index][j] = 1.0D;
            }
        }

        for(index = 15; index < 20; ++index) {
            for(j = 10; j < 15; ++j) {
                x[index][j] = 2.0D;
            }
        }

        for(index = 0; index < x.length && index < x[index].length; ++index) {
            x[index][index] = 7.0D;
        }

        printArray(x, false);
    }
}
