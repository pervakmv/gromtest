package lesson8.accounts.housework;

public class Arithmetic {

    public Arithmetic() {
    }

    public boolean check(int[] array) {

        return (minElement(array) + maxElement(array)) > 100;
    }

    public int minElement(int[] array) {
        int min = array[0];

        for (int element : array) {
            if (element < min)
                min = element;

        }
        return min;
    }

    public int maxElement(int[] array) {
        int max = array[0];

        for (int element : array) {
            if (element > max)
                max = element;
        }
        return max;
    }


}
