package lesson30.HWRev2;

import lesson31.HW.exception.BadRequestException;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    public static Map<String, Integer> countSymbols(String text) throws Exception{
        if (text.isEmpty())
            throw new BadRequestException("Text is empty ");

        char[] chText = text.toCharArray();
        Map<String, Integer> resMap = new LinkedHashMap<>(); //При LinkedHashMap у меня сохраняеться очередность букв
        for (char ch : chText) {
            resMap.put(Character.toString(ch), charCount(ch, text));
        }
        return resMap;
    }

    public static Map<String, Integer> words(String text) throws Exception{
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
