package lesson31.HW;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {

        Map<String, Integer> mapSymbolsCounters = new LinkedHashMap<>();
        mapSymbolsCounters = Solution.countSymbols("computercor MMM");
        System.out.println(mapSymbolsCounters);

        System.out.println("empty text " + Solution.countSymbols(""));

        System.out.println("Java core cours" + Solution.countSymbols("Java core cours"));

        System.out.println("Федорене горе" + Solution.countSymbols("Федорене горе"));
        System.out.println("The Second Jungle Book" + Solution.countSymbols("The Second Jungle Book"));

        System.out.println(" Testing words method");


        System.out.println("computercor_MMM " + Solution.words("computercor_MMM"));


        System.out.println("empty text " + Solution.words(""));


        System.out.println("Java core cours" + Solution.words("Java core cours"));


        System.out.println("Федорене горе" + Solution.words("Федорене горе"));


        System.out.println("The Second Jungle Book" + Solution.words("The Second Jungle Book I like this Book"));


    }


}
