package lesson31.HW;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    public static Map<String, Integer> countSymbols(String text) {
        if (text.isEmpty())
            return null;
        char[] chText = text.toCharArray();
        Map<String, Integer> resMap = new LinkedHashMap<>();
        char[] chInArray = {' '};
        for (char ch : chText) {
            chInArray[0] = ch;
            String tempString = new String(chInArray);
            Integer temp = resMap.get(tempString);
            if (temp == null) {
                resMap.put(tempString, 1);
            } else {
                temp++;
                resMap.replace(tempString, temp);

            }
        }
        return resMap;
    }

    public static Map<String, Integer> words(String text) {
        if (text.isEmpty())
            return null;
        Map<String, Integer> resMap = new LinkedHashMap<>();

        String[] splitText = text.split(" ");

        for (String str : splitText) {
            if (str.length() < 3)
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

}
