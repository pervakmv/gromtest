package lesson31.HW;



import java.util.*;

public class Solution {

    public static Map<String, Integer> countSymbols(String text){

        Map<String, Integer> resMap = new LinkedHashMap<>();
        for (Character ch : text.toCharArray()) {
            Integer value = (resMap.get(ch.toString())!= null) ? resMap.put(ch.toString(), resMap.get(ch.toString())+1) : resMap.put(ch.toString(),1);
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

            Integer temp = resMap.get(str)==null ? resMap.put(str,1) : resMap.replace(str,resMap.get(str)+1);
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
