package lesson5;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int postalArray[] = {2, -10, 3, 65, 3, 45, -123, 234, 34};
        int someThingArray[] = {6949, 34, 67548, -5, 34, 34, 68, 432, 567, 3};


        System.out.println("~~~~~~~~Вихідні масиви ~~~~~~~~~~~");
        System.out.println(Arrays.toString(postalArray));
        System.out.println(Arrays.toString(someThingArray));

        System.out.println("~~~~~~~~Сортуємо по зростанню величини ~~~~~~~~~~~");
        System.out.println(Arrays.toString(HomeWorkExercise.sortAscending(postalArray)));
        System.out.println(Arrays.toString(HomeWorkExercise.sortAscending(someThingArray)));
        System.out.println("~~~~~~~~Сортуємо по спаданню величини ~~~~~~~~~~~");
        System.out.println(Arrays.toString(HomeWorkExercise.sortDescending(postalArray)));
        System.out.println(Arrays.toString(HomeWorkExercise.sortDescending(someThingArray)));
        System.out.println("~~~~~~~~~Кількість унікальних елементів масиву~~~~~~~~~~");
        System.out.println(HomeWorkExercise.uniqueCount(postalArray));
        System.out.println(HomeWorkExercise.uniqueCount(someThingArray));
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 112000, -54, 0};

        System.out.println(Arrays.toString(HomeWorkExercise2.findClientsByBalance(names, balances, -100)));
        System.out.println(Arrays.toString(HomeWorkExercise2.findClientsWithNegativeBalance(names, balances)));


        HomeWorkExercise2.depositMoney(names, balances, "Ann", 2000);
        System.out.println(Arrays.toString(balances));

        System.out.println(HomeWorkExercise2.withdraw(names, balances, "Irina", 1000));


    }
}
