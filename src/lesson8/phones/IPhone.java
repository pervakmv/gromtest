package lesson8.phones;

public class IPhone extends Phone {
    int price;
    double weight;
    String countryProduced;

    boolean fingerPrint;

    public IPhone(int price, double weight, String countryProduced, boolean fingerPrint) {
        super(price, weight, countryProduced);
        System.out.println("IPhone constructo was invoked...");
        this.fingerPrint = fingerPrint;
    }


    void deleteIPhoneFromDb(){
        System.out.println("deleteIPhoneFromDB invoked...");

    }
}
