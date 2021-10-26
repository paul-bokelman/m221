package com.example.sping_portfolio.paullabs;
import java.util.Scanner;

public class Recursion {
    
    // Recursive method
    public static String reverseStringRecursion (String txt) {
        // Take param string of txt
        // Check if string is empty, if so return empty string
        // If string is not empty, return string with last character removed and recursively call method until string is empty
        if (txt.length() == 0) {
            System.out.println("\u001B[32m" + "rsr complete" + "\u001B[0m");
            System.out.println("");
            return "complete";
        }
        System.out.println(txt.substring(1));
        return txt.charAt(txt.length() - 1) + reverseStringRecursion(txt.substring(0, txt.length() - 1));
    }

    public static String reverseStringLoop (String txt) {
        // Take param string of txt
        // Loop over range of length of string and print line of string with last character removed
        // Return complete message when range is met
        for(int i = 1; i < txt.length(); i++) {
            System.out.println(txt.substring(i));
        }
        System.out.println("");
        System.out.println("\u001B[32m" + "rsl complete" + "\u001B[0m");
        return "complete";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String txt = input.nextLine();
        System.out.println("");
        System.out.println("\u001B[33m" + "Reverse String recursion" + "\u001B[0m");
        reverseStringRecursion(txt);
        System.out.println("\u001B[33m" + "Reverse String loop" + "\u001B[0m");
        reverseStringLoop(txt);
        input.close();
    }

}
