package lesson31.HW;

import lesson31.HW.exception.BadRequestException;

import java.util.*;

public class Solution {

    public static Map<String, Integer> countSymbols(String text) throws Exception {
        if (text.isEmpty())
            throw new BadRequestException("Text is empty ");
        Map<String, Integer> resMap = new HashMap<>();
        for (Character ch : text.toCharArray()) {
            Integer value = resMap.putIfAbsent(ch.toString(), 1);
            if (value != null)
                resMap.put(ch.toString(), ++value);
        }
        return resMap;
    }

    public static Map<String, Integer> words(String text) throws Exception {
        if (text.isEmpty())
            throw new BadRequestException("String is empty ");

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


//    private static int charCount(char ch, String text) {
//        char[] charArray = text.toCharArray();
//        int count = 0;
//        for (char element : charArray) {
//            if (ch == element)
//                count++;
//        }
//        return count;
//
//    }


}
