package lesson5.exersice;

import java.util.Arrays;

public class ArrayPractice {
    private int[] a = {3, 5, 3, 2, 6, 7, 8};


    public ArrayPractice() {
        this.a = a;
    }

    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public void aPrint() {
        System.out.println(Arrays.toString(this.a));
    }


    public int maxElement(int[] array) {
        int max = array[0];
        int i = 0;
        for (int element : array) {
            if (element > array[i]) {
                max = element;
                i++;
            }
        }
        return max;
    }
}
