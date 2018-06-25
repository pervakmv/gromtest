package lesson30.task1;

public class Main {
    public static void main(String[] args) {
        Bank usBank = new USBank(1222, "Ukraine", Currency.EUR, 100, 1400, 4, 444343343);
        Bank chinaBank = new ChinaBank(1223, "Ukraine", Currency.EUR, 32, 32000, 5, 1000000);
        Bank euBank = new EUBank(1223, "Ukraine", Currency.USD, 32, 32000, 5, 1000000);


        User user1 = new User(1001, "Denis", 12200, 40, "GMD", 1500, euBank);
        User user2 = new User(1002, "Nikolay", 32000, 100, "ELAS", 1800, euBank);

        User user3 = new User(1003, "Ivan", 30000, 12, "ELAS", 1000, chinaBank);
        User user4 = new User(1004, "Oleksiy", 34500, 22, "ELAS", 1400, chinaBank);

        User user5 = new User(1005, "Pavel", 100000, 120, "ELAS", 1000, usBank);
        User user6 = new User(1006, "Forsa", 34500, 22, "ELAS", 1400, usBank);


        System.out.println(user1.toString());
        BankSystem bankSystem = new UkrainianBankSystem();
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        bankSystem.withdraw(user1, 100);
        bankSystem.fund(user1, 50);
        bankSystem.paySalary(user1);
        bankSystem.transferMoney(user1, user2, 10);
        System.out.println(user1.toString());
        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        bankSystem.withdraw(user2, 200);
        bankSystem.fund(user2, 80);
        bankSystem.paySalary(user2);
        bankSystem.transferMoney(user2, user3, 15);
        System.out.println(user2.toString());
        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        bankSystem.withdraw(user3, 180);
        bankSystem.fund(user3, 70);
        bankSystem.paySalary(user3);
        bankSystem.transferMoney(user3, user4, 5);
        System.out.println(user3.toString());
        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        bankSystem.withdraw(user4, 380);
        bankSystem.fund(user4, 170);
        bankSystem.paySalary(user4);
        bankSystem.transferMoney(user4, user1, 5);
        System.out.println(user4.toString());
        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        bankSystem.withdraw(user5, 380);
        bankSystem.fund(user5, 170);
        bankSystem.paySalary(user5);
        bankSystem.transferMoney(user5, user6, 5);
        System.out.println(user5.toString());
        System.out.println("++++++++++++++++++++++++++++++++++++++++");


        bankSystem.withdraw(user6, 380);
        bankSystem.fund(user6, 170);
        bankSystem.paySalary(user6);
        bankSystem.transferMoney(user6, user1, 5);
        System.out.println(user6.toString());
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Ще раз пробуємо протестувати функцію fund");
        System.out.println(user6.toString());
        bankSystem.fund(user6, 100);
        System.out.println(user6.toString());
        System.out.println( user6.getBank().getLimitOfFunding());
        bankSystem.fund(user6, 100+ user6.getBank().getLimitOfFunding());
        System.out.println(user6.toString());
    }
}
