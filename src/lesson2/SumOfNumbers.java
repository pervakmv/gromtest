package lesson2;

public class SumOfNumbers {
    public static void main(String[] args) {
        int a=0;
        long sum=0;
        while(a<=10000000){
            sum += a;
            a++;
        }
        System.out.println(sum);
        System.out.println(a);
    }
}
