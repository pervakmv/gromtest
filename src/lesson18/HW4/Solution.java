package lesson18.HW4;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        String exampleString = "16 17 18 19 20 21a 22";
        String exampleString2 = "16 17d 18 19a 20 21a 22";

        System.out.println(Arrays.toString(findNumbersWithTryCatch(exampleString)));

        System.out.println(Arrays.toString(findNumbers(exampleString)));
        System.out.println(Arrays.toString(findNumbers(exampleString2)));
    }

    public static int[] findNumbers(String text) {
        if (text == null ||
                text.isEmpty())
            return null;
        String[] array = text.split(" ");
        int[] res = new int[array.length];

        int index = 0;
        for (String element : array) {
            if (digitOrNot(element))
                res[index] = Integer.parseInt(element);
            else {
                res[index] = 0;
                System.out.println("not a number");
            }
            index++;
        }
        return res;
    }

    private static boolean digitOrNot(String string) {
        char[] charAr = string.toCharArray();
        for (char element : charAr) {
            if (!Character.isDigit(element)) {
                return false;
            }
        }
        return true;
    }

    public static int[] findNumbersWithTryCatch(String text) {
        String[] array = text.split(" ");
        int[] res = new int[array.length];


        int index = 0;
        for (String element : array) {
            try {
                res[index] = Integer.parseInt(element);
            } catch (Exception e) {
                System.out.println("not a number");
                res[index] = -1;
            }
            index++;
        }
        return res;
    }
}
