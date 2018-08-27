package lesson33.HW;

import java.io.IOException;

public class Demo {

    public static void main(String[] args) {
        Solution solution = new Solution();

        try {

            solution.writeToFileFromConsole("C:/Temp/test.txt");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
}
