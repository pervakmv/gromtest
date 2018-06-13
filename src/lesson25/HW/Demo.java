package lesson25.HW;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {

        GeneralDAO<Car> carGeneralDAO = new GeneralDAO<>();

        Car car1 = new Car(101, "ZAZ", "red", "Hatchback", 5000);
        Car car2 = new Car(102, "Datcha", "grey", "Wagon", 9300);
        Car car3 = new Car(103, "Audi", "blue", "Sedan", 13300);

        Car car4 = new Car(104, "VolksWagen", "dark blue", "Sedan", 6300);
        Car car5 = new Car(105, "Renault", "white", "Wagon", 9700);
        Car car6 = new Car(106, "Geely", "green", "Sedan", 4000);

        Car car7 = new Car(107, "Peugeot", "red", "Hatchback", 7340);
        Car car8 = new Car(108, "Opel", "white", "Wagon", 9700);
        Car car9 = new Car(109, "Fiat", "green", "Sedan", 4000);

        Car car10 = new Car(110, "Citroen", "white", "Wagon", 9700);
        Car car11 = new Car(111, "Honda", "green", "Sedan", 4000);


        System.out.println(" - - - - - - - ");
        System.out.println(carGeneralDAO.save(car1).toString());
        System.out.println(carGeneralDAO.save(car2).toString());
        System.out.println(carGeneralDAO.save(car3).toString());
        System.out.println(carGeneralDAO.save(car4).toString());
        System.out.println(carGeneralDAO.save(car5).toString());
        System.out.println(carGeneralDAO.save(car6).toString());
        System.out.println(carGeneralDAO.save(car7).toString());
        System.out.println(carGeneralDAO.save(car8).toString());
        System.out.println(carGeneralDAO.save(car9).toString());
        System.out.println(carGeneralDAO.save(car10).toString());
       // System.out.println(carGeneralDAO.save(car11).toString());
        System.out.println(" - - - - - - - ");
        System.out.println(Arrays.deepToString(carGeneralDAO.getAll()));

        GeneralDAO<Man> manGeneralDAO = new GeneralDAO<>();
        Man man1 = new Man(200, "Nikolay", "Pervak", Gender.MAN, 40, MaritailStatus.MARRIED);
        Man man2 = new Man(201, "Lubov", "Batrak", Gender.WOMEN, 38, MaritailStatus.MARRIED);
        Man man3 = new Man(202, "Sergey", "Balovnev", Gender.MAN, 28, MaritailStatus.MARRIED);
        System.out.println(manGeneralDAO.save(man1).toString());
        System.out.println(manGeneralDAO.save(man2).toString());
        System.out.println(manGeneralDAO.save(man3).toString());
        System.out.println(" - - - - - - - ");
        System.out.println(Arrays.deepToString(manGeneralDAO.getAll()));




        GeneralDAO<Smartphon> smartphoneGeneralDAO = new GeneralDAO<>();
        Smartphon smartphone1 = new Smartphon(400, "iphone", "6", "IOS", 4.3f, 250);
        Smartphon smartphone2 = new Smartphon(401, "Xiomy", "Readmy Note 4", "Android", 5.0f, 180);


        System.out.println(smartphoneGeneralDAO.save(smartphone1).toString());
        System.out.println(smartphoneGeneralDAO.save(smartphone2).toString());

        System.out.println(" - - - - - - - ");
        System.out.println(Arrays.deepToString(smartphoneGeneralDAO.getAll()));

    }


}
