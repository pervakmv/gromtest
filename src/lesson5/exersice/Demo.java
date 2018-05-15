package lesson5.exersice;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        ArrayPractice arrayPractice = new ArrayPractice();
        ArrayPractice arrayPractice2 = null;

        arrayPractice.aPrint();

        int[] b = arrayPractice.getA();

        System.out.println("~~~~~~~~~~~~~~~~~");
        System.out.print("B = ");
        System.out.println(Arrays.toString(b));

        for (int i = 0; i < b.length; i++) {
            b[i] = i;
        }

        System.out.println("Після перезапису масиву");
        System.out.print("A= ");
        arrayPractice.aPrint();
        System.out.print("B= ");
        System.out.println(Arrays.toString(b));

        if (arrayPractice2 != null)
            arrayPractice2.aPrint();

        arrayPractice2 = new ArrayPractice();

        if (arrayPractice2 != null)
            arrayPractice2.aPrint();

    }


}
