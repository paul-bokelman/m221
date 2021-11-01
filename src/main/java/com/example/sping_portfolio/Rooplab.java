package com.example.sping_portfolio;

abstract class Car {

    String model;

    public void honk() {
        System.out.println(model + " Honked");
    }

}

class Camaro extends Car {

    private String year;

    public Camaro() {
        super.model = "Camaro";
    }

    public Camaro(String year) {
        super.model = "Camaro";
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void stop() {
        System.out.println("camaro stopped");
    }

}
class Mustang extends Car {

    public Mustang() {
        super.model = "Mustang";
    }

    public void crash() { System.out.println("mustang crashed"); }


}

class RoopLab {

    public static void main(String[] args) {
        Camaro c = new Camaro();
        Mustang m = new Mustang();
        Camaro c2 = new Camaro("1972");

        c.honk();
        c.stop();
        m.honk();
        m.crash();
        System.out.println(c.model);
        System.out.println(c2.getYear());
        System.out.println(m.model);


    }

}
