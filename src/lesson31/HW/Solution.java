package lesson31.HW;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    public static Map<String, Integer> countSymbols(String text) {
        if (text.isEmpty())
            return null;
        char[] chText = text.toCharArray();
        Map<String, Integer> resMap = new LinkedHashMap<>();
        for (char ch : chText) {
            resMap.put(Character.toString(ch), charCount(ch, text));
        }
        return resMap;
    }

    public static Map<String, Integer> words(String text){
        if (text.isEmpty())
            return null;


        Map<String, Integer> resMap = new LinkedHashMap<>();

        String[] splitText = text.split(" ");

        for (String str : splitText) {
            if ((str.length() < 3) ||
                    (!stringConsistsOfLetters(str)))
                continue;

            Integer temp = resMap.get(str);
            if (temp == null) {
                resMap.put(str, 1);
            } else {
                temp++;
                resMap.replace(str, temp);
            }
        }


        return resMap;
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

    private static boolean stringConsistsOfLettersAndDigits(String str) {
        if (str == null
                || str.isEmpty())
            return false;
        char[] chrAr = str.toCharArray();

        Character character = chrAr[0];

        for (char element : chrAr) {

            if (!character.isLetter(element) && !character.isDigit(element))
                return false;
        }
        return true;
    }

    private static int charCount(char ch, String text) {
        char[] charArray = text.toCharArray();
        int count = 0;
        for (char element : charArray) {
            if (ch == element)
                count++;
        }
        return count;
    }


}
