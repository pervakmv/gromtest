package lesson2;

public class SumAndDivision {
    public static void main(String[] args) {
        int a = 1;
        int sum = 0;

        while (a <= 1000) {
            sum += a;
            a++;
        }
        int wholePart = sum / 1234;
        int fraction = sum % 1234;
        boolean fractionGreater = fraction > wholePart;
        System.out.println(fractionGreater);
    }
}
