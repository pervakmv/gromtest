package Eratosfen;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Eratosfen eratosfen = new Eratosfen(100000);
        eratosfen.fillSieve();


//        System.out.println(Arrays.toString(eratosfen.getPrimes()));
//
//        eratosfen.printSieve(40);
//        ArrayList<Integer> list = new ArrayList<>();
//
//        list = eratosfen.toArrayList();
//        System.out.println(list);
        System.out.println(" Ответ : ");
        System.out.println(eratosfen.findMaxPalindrom().toString());



    }
}
