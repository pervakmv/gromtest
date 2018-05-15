package lesson10.HomeWork;

import java.util.Date;

public class FurnitureOrder extends Order {
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    public String getFurnitureCode() {
        return furnitureCode;
    }


    boolean conditionOfValidation() {
        String[] validCity = {"Киев", "Львов"};
        String[] validGender = {"Мужской", "Женский"};
        String[] forbiddenName = {"Тест"};
        double minPrice = 500;
        if (foundStringInArray(getCustomerOwned().getGender(), validGender)
                && foundStringInArray(getCustomerOwned().getCity(), validCity)
                && getBasePrice() >= minPrice
                && foundStringInArray(getCustomerOwned().getName(), forbiddenName)==false) {
            return true;
        }
        return false;
    }

    @Override
    public void validateOrder() {
        String[] validCity = {"Киев", "Львов"};
        String[] validGender = {"Мужской", "Женский"};
        String[] forbiddenName = {"Тест"};
        Date curDate = new Date();
        double minPrice = 500;
        if (foundStringInArray(getCustomerOwned().getGender(), validGender)
                && foundStringInArray(getShipFromCity(), validCity)
                && getBasePrice() >= minPrice
                && !foundStringInArray(getCustomerOwned().getName(), forbiddenName)) {

            setDateConfirmed(curDate);
        }

    }

    @Override
    public void calculatePrice() {


        double res = (double) getBasePrice();

        res += res * (double) marginForDelivery() / 100;

        res -= res * (double) discount() / 100;

        setTotalPrice(res);

    }


    int marginForDelivery() {
        int res = 5;
        if (getBasePrice() >= 5000) {
            res = 2;
        }

        return res;
    }

    int discount() {
        return 0;
    }
}
