package com.example.sping_portfolio.paullabs;
import java.util.Scanner;

public class Loops {
    
    // Single loop
    public static void sumOfInput (int num) {
        // Initialize sum to 0
        // For the range of 1 to num set value of sum to sum + i
        // Print sum and initial value on new line
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        System.out.println("The sum of the numbers from 1 to " + num + " is " + sum);
    }

    // Double loop
    public static void multiplicationTable (int num) {
        // For num times (num is the number of times the loop will run)
        // For each loop over the range of num
        // Multiply initial loop current number (i) by nested loop current number (j)
        // Print the result until range of num is met then print new line
        // Repeat until num range is met
        for(int i = 1; i <= num; i++) {
			for(int j = 1; j <= num; j++) {
                System.out.print((i*j)+" ");
			}
			System.out.println("");
		}
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = input.nextInt();
        sumOfInput(num);
        System.out.println("");
        multiplicationTable(num);
        input.close();
    }

}
