package Eratosfen;

public class Utils {

    public static String reversString (String strInput){
        char[] charArray = strInput.toCharArray();
        char[] reversCharArray = new char[charArray.length];
        String resString = new String();
        int index = charArray.length;

        for(char element : charArray){
            reversCharArray[--index]= element;
        }
        for(char element : reversCharArray){
            resString = resString + Character.toString(element);
        }

        return resString;
    }

    public static boolean integerIsPolindrom(Integer input){
        String inputString = input.toString();
        if(inputString.equals(Utils.reversString(inputString)))
            return true;
        return false;
    }

    public static boolean longIsPolindrom(Long input){
        String inputString = input.toString();
        if(inputString.equals(Utils.reversString(inputString)))
            return true;
        return false;
    }
}
