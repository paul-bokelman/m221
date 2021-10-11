package com.example.sping_portfolio.samlabs;

public class Factorial {

    public static int factorial_recursion(int n) {
        if(n==0) return 1;
        return n*factorial_recursion(n-1);
    }

    public static int factorial_loop(int n) {
        int var = 1;
        for(int i=n;i>0;i--){
            var = var * i;
        }
        return var;
    }

    public static void main(String[] args) {
        System.out.println(Factorial.factorial_loop(5));
        System.out.println(Factorial.factorial_recursion(5));

    }
}
