package lesson3;

public class FindOdd {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 0; i <= 1000; i++) {
            if (i % 2 != 0) {
                System.out.println("Found");
                sum += i;
            }//if

        }//for
        if((sum*5)==5000){
            System.out.println("equal");

        }else{
            if((sum*5)>5000){
                System.out.println("Bigger");
            }
            else{
                System.out.println("Smaller");
            }//if
        }//if
    }//public static void main
}
