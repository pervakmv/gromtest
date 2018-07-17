package lesson31.HW;

import lesson30.HWRev2.Solution;
import lesson31.HW.exception.BadRequestException;

import java.util.LinkedHashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {

        Map<String, Integer> mapSymbolsCounters = new LinkedHashMap<>();

        try {
            mapSymbolsCounters = Solution.countSymbols("computercor MMM");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(mapSymbolsCounters);

        try {
            System.out.println("empty text " + Solution.countSymbols(""));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Java core cours" + Solution.countSymbols("Java core cours"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Федорене горе" + Solution.countSymbols("Федорене горе"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("The Second Jungle Book" + Solution.countSymbols("The Second Jungle Book"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(" Testing words method");


        try {
            System.out.println("computercor_MMM " + Solution.words("computercor_MMM"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            System.out.println("empty text " + Solution.words(""));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Java core cours" + Solution.words("Java core cours"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Федорене горе" + Solution.words("Федорене горе"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("The Second Jungle Book" + Solution.words("The Second Jungle Book I like this Book"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
