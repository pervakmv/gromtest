package lesson10.HomeWork;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        Date curDate = new Date(2018, 05, 05);

        Customer customerNikolay = new Customer("Николай", "Киев", "Мужской");
        Customer customerLubov = new Customer("Любовь", "Киев", "Женский");

        Customer customerYulia = new Customer("Юля", "Львов", "Женский");
        Customer customerPavel = new Customer("Саша", "Киев", "Мужской");



        ElectronicsOrder electronicsOrder1 = new ElectronicsOrder("Дрель", curDate, "Киев", "Харьков", 150, customerNikolay, 6);
        ElectronicsOrder electronicsOrder2 = new ElectronicsOrder("Фен", curDate, "Киев", "Днепр", 1250, customerLubov, 6);

        FurnitureOrder furnitureOrder1 = new FurnitureOrder("Змаок", curDate, "Киев", "Львов", 6000, customerYulia, "122");
        FurnitureOrder furnitureOrder2 = new FurnitureOrder("Ручка", curDate, "Киев", "Бровары", 600, customerPavel,  "122");




        electronicsOrder1.validateOrder();
        electronicsOrder1.calculatePrice();
        electronicsOrder1.confirmShipping();
        electronicsOrder1.printData();

        electronicsOrder2.validateOrder();
        electronicsOrder2.calculatePrice();
        electronicsOrder2.confirmShipping();
        electronicsOrder2.printData();

        furnitureOrder1.validateOrder();
        furnitureOrder1.calculatePrice();
        furnitureOrder1.confirmShipping();
        furnitureOrder1.printData();

        furnitureOrder2.validateOrder();
        furnitureOrder2.calculatePrice();
        furnitureOrder2.confirmShipping();
        furnitureOrder2.printData();




    }
}
