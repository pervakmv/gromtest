package Eratosfen;

import java.util.ArrayList;
import java.util.Arrays;

public class Eratosfen {
    private boolean[] primes;

    public Eratosfen(int n) {
        primes = new boolean[n + 1];
    }

    public Eratosfen() {
    }

    public Eratosfen(boolean[] primes) {
        this.primes = primes;
    }

    public boolean[] getPrimes() {
        return primes;
    }

    public void fillSieve() {
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i < primes.length; ++i) {
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; ++j) {
                    primes[i * j] = false;
                }
            }
        }
    }

    public ArrayList<Integer> toArrayList() {
        ArrayList<Integer> resList = new ArrayList<>();

        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                if (i / 10000 > 0 && i / 100000 == 0) {

                        resList.add((Integer) i);
                }
            }
        }
        return resList;
    }


    public Element findMaxPalindrom() {
        Element resElement = new Element();
        ArrayList<Integer> fiveDigitPrimesArrayList = toArrayList();
        System.out.println("size = " + fiveDigitPrimesArrayList.size());
        boolean firstElement = true;

        for (int i = 0; i < fiveDigitPrimesArrayList.size(); i++) {
            Integer first = fiveDigitPrimesArrayList.get(i);
            for (int j = i + 1; j < fiveDigitPrimesArrayList.size(); j++) {
                Integer second = fiveDigitPrimesArrayList.get(j);
                long value = first * second;
                if (Utils.longIsPolindrom(value)) {
                    if (firstElement == true || value > resElement.getProdact()) {
                        resElement.setFirstNumber(first);
                        resElement.setSecondNumber(second);
                        resElement.setProdact(value);
                        firstElement = false;

                        System.out.println(resElement.toString());

                    }
                }
            }
        }

        return resElement;
    }

    public void printSieve(int columsNumber) {
        int colums = 0;
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {

                    System.out.print(i + " ");
                    colums++;
                    if (colums >= columsNumber) {
                        System.out.println();
                        colums = 0;
                    }
                }

        }
        System.out.println();
    }

}

