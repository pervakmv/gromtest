package lesson16.homework;


import java.util.Arrays;

public class SolutionRev1 {
    public static void main(String[] args) {

        String string1 = new String("From the example in Sect 6.13, you would create a variable for each data (CaseP and DiscP) for each of the stations in the plant.");
        String string2 = new String("uber 657    я люблю програмувати на Java8.0");

        int count = countWords(string1);
        System.out.println(count);
        System.out.println(countWords(string2));

        System.out.println(arrayOfStrings(string1));
        System.out.println(arrayOfStrings(string2));
    }

    public static int countWords(String input) {
        if (input == null)
            return 0;
        String[] subStrings = input.split(" ");

        int count = 0;
        for (String element : subStrings) {
            if (stringConsistsOfLetters(element))
                count++;
        }
        return count;
    }

    private static boolean checkForInvalidString(String str) {
        char[] invalidCharackter = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '\b', '\t', '\n', '\r', '\"', '\'', '\\', '"', ',', '*', '&', '`', '~', '@', '#', '$', ';', '%', '^', '?', '(', ')'};
        char[] chrAr = str.toCharArray();
        for (char element : chrAr) {
            for (char element2 : invalidCharackter) {
                if (element == element2)
                    return false;
            }
        }
        return true;
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


    private static boolean checkForInvalidChar(char symbol) {
        char[] invalidCharackter = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '\b', '\t', '\n', '\r', '\"', '\'', '\\', '"', ',', '*', '&', '`', '~', '@', '#', '$', ';', '%', '^', '?', '(', ')'};

        for (char element : invalidCharackter) {
            if (element == symbol)
                return true;
        }

        return false;
    }

    private static boolean checkForCharIsLetter(char symbol) {
        Character character = symbol;
        return character.isLetter(symbol);
    }


    public static int arrayOfStrings(String input) {
        if (input == null)
            return 0;
        char[] chrAr = input.toCharArray();
        int count = 0;
        boolean space = false;
        boolean symbol = false;
        boolean symbolOldValue = false;
        boolean invalidChar = false;
        boolean invalidChar_old = false;
        boolean decrementAllowed = false;
        for (char element : chrAr) {
            if (element == ' ') {
                symbol = false;
                space = true;
            }
            invalidChar = !checkForCharIsLetter(element);

            if (element != ' ') {
                symbol = true;
                space = false;
            }
            if (symbol != symbolOldValue) {
                if (symbol == true) {


                    if (invalidChar != true) {
                        count++;
                        decrementAllowed = true;
                    } else {
                        decrementAllowed = false;
                    }
                }
            } else {

                if (symbol == true) {
                    if (decrementAllowed == true) {
                        if (invalidChar != invalidChar_old && (invalidChar == true)) {
                            if (count > 0) {
                                count--;
                                decrementAllowed = false;

                            }

                        }
                    }
                }
            }
            symbolOldValue = symbol;
            invalidChar = invalidChar_old;
        }
        return count;
    }
}
