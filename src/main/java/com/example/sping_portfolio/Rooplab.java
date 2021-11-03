package com.example.sping_portfolio;

abstract class Car {

    String model;

    public void honk() {
        System.out.println(model + " Honked");
    }
    public void crash() { System.out.println(model + " crashed"); }
    public void stop() { System.out.println(model + " stopped"); }

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


}
class Mustang extends Car {

    public Mustang() {
        super.model = "Mustang";
    }


}

class RoopLab {

    public static void main(String[] args) {
        Camaro c = new Camaro();
        Mustang m = new Mustang();
        Camaro c2 = new Camaro("1973 ");

        c.honk();
        c.stop();
        m.honk();
        m.crash();
        System.out.print(c2.getYear());
        System.out.println(c.model);
        System.out.println(m.model);


    }

}
