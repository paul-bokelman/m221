package com.example.sping_portfolio;

abstract class Dog {

    String breed;

    public void bark() {
        System.out.println("Bark!");
    }

}

class Chihuahua extends Dog {

    public void poop() {
        System.out.println("Dog Pooped");
    }

}

public class SamLab {

    public static void main(String[] args) {
        Chihuahua c = new Chihuahua();

        c.bark();
        c.poop();
        System.out.println(c.breed);

    }

}
