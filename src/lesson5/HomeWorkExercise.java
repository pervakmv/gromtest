package lesson5;

import java.util.Arrays;

public class HomeWorkExercise {

    public static void main(String[] args) {

        int postalArray[] = {2, -10, 3, 65, 3, 45, -123, 234, 34};
        int someThingArray[] = {6949, 34, 67548, -5, 34, 34, 68, 432, 567, 3};


        System.out.println("~~~~~~~~Вихідні масиви ~~~~~~~~~~~");
        System.out.println(Arrays.toString(postalArray));
        System.out.println(Arrays.toString(someThingArray));

        System.out.println("~~~~~~~~Сортуємо по зростанню величини ~~~~~~~~~~~");
        System.out.println(Arrays.toString(sortAscending(postalArray)));
        System.out.println(Arrays.toString(sortAscending(someThingArray)));
        System.out.println("~~~~~~~~Сортуємо по спаданню величини ~~~~~~~~~~~");
        System.out.println(Arrays.toString(sortDescending(postalArray)));
        System.out.println(Arrays.toString(sortDescending(someThingArray)));
        System.out.println("~~~~~~~~~Кількість унікальних елементів масиву~~~~~~~~~~");
        System.out.println(uniqueCount(postalArray));
        System.out.println(uniqueCount(someThingArray));
    }

    public static int[] sortAscending(int[] array) {
        int resultArray[] = new int[array.length];
        resultArray = array;
        int exchangesCounter = 0;
        int index = 0;

        do {
            exchangesCounter = 0;
            index = 0;
            while (index < (resultArray.length - 1)) {

                if (resultArray[index] > resultArray[index + 1]) {
                    int tempValue = resultArray[index];
                    resultArray[index] = resultArray[index + 1];
                    resultArray[index + 1] = tempValue;
                    exchangesCounter++;
                }
                index++;
            }
        } while (exchangesCounter != 0);
        return resultArray;
    }

    public static int[] sortDescending(int[] array) {
        int resultArray[] = new int[array.length];
        resultArray = array;
        int exchangesCounter = 0;
        int index = 0;

        do {
            exchangesCounter = 0;
            index = 0;
            while (index < (resultArray.length - 1)) {

                if (resultArray[index] < resultArray[index + 1]) {
                    int tempValue = resultArray[index];
                    resultArray[index] = resultArray[index + 1];
                    resultArray[index + 1] = tempValue;
                    exchangesCounter++;
                }
                index++;
            }
        } while (exchangesCounter != 0);
        return resultArray;
    }

    //Кількість унікальних елементів масиву

    public static int uniqueCount(int[] array){
        int sortArray[] = sortAscending(array);
        int firstElement = sortArray[0];
        int res = 1;
        for(int element:sortArray){
            if(element>firstElement)
                res++;
            firstElement = element;
        }
        return res;
    }

}//class

