package lesson31.HW;



import java.util.*;

public class Solution {

    public static Map<String, Integer> countSymbols(String text){

        Map<String, Integer> resMap = new LinkedHashMap<>();
        for (Character ch : text.toCharArray()) {

            resMap.put(ch.toString(), resMap.get(ch.toString())==null ? 1 : resMap.get(ch.toString())+1);
        }
        return resMap;
    }

    public static Map<String, Integer> words(String text) {

        Map<String, Integer> resMap = new LinkedHashMap<>();

        String[] splitText = text.split(" ");

        for (String str : splitText) {
            if ((str.length() < 3) ||
                    (!stringConsistsOfLetters(str)))
                continue;

           resMap.put(str, resMap.get(str) == null ? 1 : resMap.get(str)+1);
        }

        return resMap;
    }
        private static boolean stringConsistsOfLetters(String str) {
        for (Character element : str.toCharArray()) {
            if (!element.isLetter(element))
                return false;
        }
        return true;
    }




}
