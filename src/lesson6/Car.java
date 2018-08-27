package lesson6;

import javafx.css.Size;

public class Car {

    //1 field

    int price;
    int yearOfManufacturing;
    String color;
    String ownerName;
    double wieght;
    int horsePower;


    public static void main(String[] args) {

    }

    public Car(int price, int yearOfManufacturing, String ownerName) {

        this.price = price;
        this.yearOfManufacturing = yearOfManufacturing;
        this.ownerName = ownerName;
    }


    //3 class body
    void startRun() {
        System.out.println("I am running....");
    }

    void stopRun() {
        System.out.println("I am stopping....");
    }

    void changeOwner(String newOwnerName) {
        ownerName = newOwnerName;
    }

    //4 inner class
    private class Test {

    }


}
