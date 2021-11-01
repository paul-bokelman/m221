package com.example.sping_portfolio;

abstract class Car {

    String model;

    public void honk() {
        System.out.println("Car Honked");
    }

}

class Camaro extends Car {

    public void stop() { System.out.println("camaro stopped"); }

}
class Mustang extends Car {

    public void crash() { System.out.println("mustang crashed"); }

}

class RoopLab {

    public static void main(String[] args) {
        Camaro c = new Camaro();
        Mustang m = new Mustang();

        c.honk();
        c.stop();
        m.crash();
        System.out.println(c.model);
        System.out.println(m.model);

    }

}
