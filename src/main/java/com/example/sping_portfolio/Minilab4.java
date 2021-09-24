package com.example.sping_portfolio;

import java.util.Scanner;

public class Minilab4 {
    public static void main(String[] args) {
        boolean x = true;
        while (x) {
            Scanner s = new Scanner(System.in);
            System.out.println("Welcome to Fibonacci! How many numbers of the sequence would you like?");
            String fib = s.nextLine();
            int fnum = Integer.parseInt(fib);
            long num1 = 0, num2 = 1, num3;

            for (int i = 0; i < fnum; i++) {
                System.out.print(num1 + " ");
                num3 = num1 + num2;
                num1 = num2;
                num2 = num3;
            }
            System.out.println("\nThe " + (fnum + 1) + "th number of the sequence is " + num1);
        }
    }
}
