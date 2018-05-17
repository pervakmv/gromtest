package lesson10.HomeWork;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }


    boolean conditionOfValidation() {
        String[] validCity = {"Киев", "Одесса", "Днепр", "Харьков"};
        String[] validGender = {"Женский"};
        double minPrice = 100;
        if (foundStringInArray(getCustomerOwned().getGender(), validGender)
                && foundStringInArray(getShipFromCity(), validCity)
                && foundStringInArray(getShipToCity(), validCity)
                && getBasePrice() >= minPrice) {

            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ElectronicsOrder{" +
                "guaranteeMonths=" + guaranteeMonths +
                '}';
    }

    @Override
    public void calculatePrice() {


        double res = (double) getBasePrice();

        res += res * (double) marginForDelivery() / 100;

        res -= res * (double) discount() / 100;

        setTotalPrice(res);
    }

    @Override
    public void validateOrder() {
        String[] validCity = {"Киев", "Одесса", "Днепр", "Харьков"};
        String[] validGender = {"Женский"};
        double minPrice = 100;
        Date curDate = new Date();
        if (foundStringInArray(getCustomerOwned().getGender(), validGender)
                && foundStringInArray(getShipFromCity(), validCity)
                && foundStringInArray(getShipToCity(), validCity)
                && getBasePrice() >= minPrice) {

            setDateConfirmed(curDate);
        }
    }

    int marginForDelivery() {
        int res = 15;
        if (getShipToCity() == "Киев" ||
                getShipToCity() == "Одесса")
            res = 10;

        return res;
    }

    int discount() {
        if (getBasePrice() >= 1000) {
            return 5;
        }
        return 0;
    }


}
