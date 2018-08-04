package lesson32.HW;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {


    public int readNumbers() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        int numberOfattempts = 3;
        String[] inString;
        do {
            numberOfattempts--;
            inString = br.readLine().split(" ");
            if (!stringValidator(inString) && numberOfattempts > 0)
                System.out.println("Your numbers are wrong. You have " + numberOfattempts + " attempts to try again");
        } while (!stringValidator(inString) && numberOfattempts > 0);

        int sum = 0;
        if (!stringValidator(inString))
            System.out.println("Your numbers are wrong. Number f attempts exceeded");
        else {
            for (String str : inString) {
                sum += Integer.parseInt(str);
            }
        }

        br.close();
        reader.close();
        return sum;

    }

    public boolean stringValidator(String[] strArray) {


        int index = 0;


        for (String str : strArray) {
            if (!stringIsDigit(str) || str.isEmpty()){
                return false;
            }

            if (Integer.parseInt(str) > 100){
                return false;
            }

            index++;
        }
        if (index != 10){
            return false;
        }


        return true;
    }

    public boolean stringIsDigit(String str) {
        char[] chars = str.toCharArray();

        for (char element : chars) {
            if (!Character.isDigit(element))
                return false;
        }
        return true;
    }


}
