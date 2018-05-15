package lesson10.HomeWork;


import java.util.Date;

public abstract class Order {
    private String itemName;
    private Date dateCreated = new Date();
    private Date dateConfirmed;
    private Date dateShipped;
    private String shipFromCity;
    private String shipToCity;
    private int basePrice;
    private double totalPrice;
    private Customer customerOwned;

    public Order(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned) {
        this.itemName = itemName;
        this.dateCreated = dateCreated;
        this.shipFromCity = shipFromCity;
        this.shipToCity = shipToCity;
        this.basePrice = basePrice;
        this.customerOwned = customerOwned;
    }

    public abstract void validateOrder();

    public abstract void calculatePrice();


    public String getItemName() {
        return itemName;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getShipFromCity() {
        return shipFromCity;
    }

    public String getShipToCity() {
        return shipToCity;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public Customer getCustomerOwned() {
        return customerOwned;
    }

    public Date getDateConfirmed() {

        return dateConfirmed;
    }

    public void setDateConfirmed(Date dateConfirmed) {
        this.dateConfirmed = dateConfirmed;
    }

    public Date getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(Date dateShipped) {
        this.dateShipped = dateShipped;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void confirmShipping() {
        Date curDate = new Date();
        if (dateShipped == null) {

            dateShipped = curDate;

        }
    }

    public void printData() {
        System.out.println("Customer Name " + getCustomerOwned().getName());

        System.out.print("Data created: ");
        printDate(getDateCreated());

        System.out.print("Data confirm: ");
        printDate(getDateConfirmed());

        System.out.print("Data shipping: ");
        printDate(getDateShipped());

        System.out.println("Base price:" + getBasePrice() + "Total price" + getTotalPrice());

    }

    public void printDate(Date date) {
        if (date != null)
            System.out.println(" " + date.getDate() + "." + date.getMonth() + "." + date.getYear());
    }

    public boolean foundStringInArray(String string, String[] strings) {
        for (String element : strings) {
            if (element == string) {
                return true;
            }
        }
        return false;
    }


}
