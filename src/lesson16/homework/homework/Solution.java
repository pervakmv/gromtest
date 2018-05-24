package lesson16.homework.homework;

import java.util.Arrays;

public class Solution {


    public static String mostCountedWords(String input) {
        if (input == null
                || input.isEmpty())
            return null;
        String[] words = input.split(" ");
        Arrays.sort(words);

        String maxWord = "";
        String word = "";
        int maxCount = 0, count = 1;

        for (String element : words) {
            if (element.equals(word)) {
               if(stringConsistsOfLetters(element)) count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    maxWord = word;
                }
                word = element;
                count = 1;
            }
        }
        if (count > maxCount) {
            maxCount = count;
            maxWord = word;
        }
        return maxWord;
    }

    public static String minWord(String input) {

        if (input == null)
            return null;
        if (input.isEmpty())
            return null;

        String[] subStrings = input.split(" ");
        int len = subStrings[0].length();
        int indexOfElement = 0;

        String resString = null;
        for (String element : subStrings) {
            if (element.length() < len && stringConsistsOfLetters(element)) {
                len = element.length();

                resString = subStrings[indexOfElement];
            }
            indexOfElement++;
        }
        return resString;
    }

    public static String maxWord(String input) {
        if (input == null)
            return null;
        if (input.isEmpty())
            return null;
        String[] subStrings = input.split(" ");
        int len = subStrings[0].length();
        int indexOfElement = 0;
        String resString = null;
        for (String element : subStrings) {
            if (element.length() > len && stringConsistsOfLetters(element)) {
                len = element.length();
                resString = subStrings[indexOfElement];
            }
            indexOfElement++;
        }
        return resString;
    }


    private static boolean stringConsistsOfLetters(String str) {
        if (str == null
                || str.isEmpty())
            return false;
        char[] chrAr = str.toCharArray();

        Character character = chrAr[0];

        for (char element : chrAr) {

            if (!character.isLetter(element))
                return false;
        }
        return true;
    }

}
