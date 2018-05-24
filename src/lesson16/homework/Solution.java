package lesson16.homework;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        String string1 = new String("For example in Sect 6.13, for For  well Well well well for for 6.13  6.13 6.13 6.13 6.13 for Well well Well");
        String string2 = new String("Cпорт лото 89978676 ");
        String string3 = new String("  2323");
        String string4 = new String("");
        String string5 = null;

        System.out.println(" Підрахунок слів за домопогою методу countWords");
        System.out.println(countWords(string1));
        System.out.println(countWords(string2));
        System.out.println(countWords(string3));
        System.out.println(countWords(string4));
        System.out.println(countWords(string5));

        System.out.println(" Підрахунок слів за допомогою методу countWordsRev2");
        System.out.println(countWordsRev2(string1));
        System.out.println(countWordsRev2(string2));
        System.out.println(countWordsRev2(string3));
        System.out.println(countWordsRev2(string4));
        System.out.println(countWordsRev2(string5));

        System.out.println(" Визначення найдовшого слова в стрічці");

        System.out.println(maxWord(string1));
        System.out.println(maxWord(string2));
        System.out.println(maxWord(string3));
        System.out.println(maxWord(string4));
        System.out.println(maxWord(string5));

        System.out.println(" Визначення найкоротшого слова в стрічці");

        System.out.println(minWord(string1));
        System.out.println(minWord(string2));
        System.out.println(minWord(string3));
        System.out.println(minWord(string4));
        System.out.println(minWord(string5));

        System.out.println("Виводимо слово, що найбільше разів повторюються варіант 1");
        System.out.println(mostCountedWordsRev1(string1));

        System.out.println("Виводимо слово, що найбільше разів повторюються варіант 2");
        System.out.println(mostCountedWords(string1));
        System.out.println(mostCountedWords(string2));
        System.out.println(mostCountedWords(string3));
        System.out.println(mostCountedWords(string4));
        System.out.println(mostCountedWords(string5));

        System.out.println("Перевіряємо просту валідацію інтернет адреси");

        String internetAddress = new String("http://WWW.UKR.net");
        String internetAddress2 = new String("http://a.net");
        String internetAddress3 = new String("");
        System.out.println(validate(internetAddress));
        System.out.println(validate(string1));
        System.out.println(validate(string2));
        System.out.println(validate(string3));
        System.out.println(validate(string4));
        System.out.println(validate(string5));

    }

    public static boolean validate(String address) {
        if (address == null
                || address.isEmpty())
            return false;
        if (address.length() < 12)
            return false;
        String addressLowerCase = address.toLowerCase();

        String[] validDomen = {".com", ".org", ".net"};
        String[] validPrefix = {"http://", "https://"};

        String domen = (addressLowerCase.substring(address.length() - 4));
        if (!stringInvocedInArray(domen, validDomen))
            return false;
        char sChar = 's';
        String prefix;
        String addressBody;
        if (address.charAt(5) == sChar) {
            prefix = (addressLowerCase.substring(0, 8));
        } else
            prefix = (addressLowerCase.substring(0, 7));

        if (!stringInvocedInArray(prefix, validPrefix))
            return false;

        addressBody = addressLowerCase.replaceFirst(prefix, "");

        addressBody = addressBody.replaceFirst(domen, "");
        addressBody = addressBody.replaceFirst("www.", "");

        if (!stringConsistsOfLetters(addressBody))
            return false;

        return true;
    }

    private static boolean stringInvocedInArray(String input, String[] array) {
        for (String element : array) {
            if (element.equalsIgnoreCase(input)) {
                return true;
            }

        }
        return false;
    }

    public static String mostCountedWordsRev1(String input) {
        if (input == null)
            return null;
        String[] subStrings = input.split(" ");
        int index = 0;
        int maxDuplicateElementIndex = -1;
        int counter = 1;
        int counterPreviousValue = 0;
        for (index = 0; index < subStrings.length; index++) {
            counter = 1;
            for (int j = index + 1; j < subStrings.length; j++) {
                if (stringConsistsOfLetters(subStrings[index]) &&
                        subStrings[index].equals(subStrings[j])) {
                    counter++;
                }

            }//for

            if (counter > 1) {
                if (counter > counterPreviousValue) {
                    maxDuplicateElementIndex = index;
                    counterPreviousValue = counter;
                }
            }
        }
        return maxDuplicateElementIndex > 0 ? subStrings[maxDuplicateElementIndex] : null;
    }


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
                if (stringConsistsOfLetters(element)) count++;

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

    public static String maxWord(String input) {
        if (input == null)
            return null;
        if (input.isEmpty())
            return null;
        String[] subStrings = input.split(" ");

        int len = 0;
        int indexOfElement = 0;
        String resString = null;
        for (String element : subStrings) {
            if ((element.length() > len || len == 0) && stringConsistsOfLetters(element) && !element.isEmpty()) {
                len = element.length();
                resString = subStrings[indexOfElement];
            }
            indexOfElement++;
        }
        return resString;
    }

    public static String minWord(String input) {

        if (input == null)
            return null;
        if (input.isEmpty())
            return null;

        String[] subStrings = input.split(" ");
        int len = 0;
        int indexOfElement = 0;

        String resString = null;
        for (String element : subStrings) {
            if ((element.length() < len || len == 0) && stringConsistsOfLetters(element) && !element.isEmpty()) {
                len = element.length();

                resString = subStrings[indexOfElement];
            }
            indexOfElement++;
        }
        return resString;
    }


    public static int countWordsRev2(String input) {
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


    private static boolean checkForCharIsLetter(char symbol) {
        Character character = symbol;
        return character.isLetter(symbol);
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

    //count replaces
    private static int[] countDuplicates(String input, String[] words) {

        String[] strings = input.split(" ");

        int[] res = new int[words.length];
        for (String string : strings) {
            for (int i = 0; i < words.length; i++) {
                if (string.equals(words[i]))
                    res[i]++;
            }
        }

        return res;
    }

}