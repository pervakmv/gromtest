package lesson29.HW;

import java.util.Arrays;
import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Order> hashSet1 =  new HashSet<>();
        hashSet1 = useHashSet();

        System.out.println(hashSet1);

        System.out.println("size = " + hashSet1.size());

        System.out.println(Arrays.deepToString(hashSet1.toArray()));


    }


    public static HashSet<Order> useHashSet(){
        Order order1 = new Order(12, 114, "dolar", "Bambambam", "Metro");
        Order order2 = new Order(13, 134, "dolar", "Lambda", "Tramp");
        Order order3 = new Order(14, 234, "dolar", "Lexus", "Green");
        Order order4 = new Order(15, 235, "dolar", "Lexus", "Blue");

        Order order21 = new Order(12, 114, "dolar", "Bambambam", "Metro");
        Order order22 = new Order(13, 134, "dolar", "Lambda", "Tramp");
        Order order23 = new Order(14, 234, "dolar", "Lexus", "Green");
        Order order24 = new Order(15, 235, "dolar", "Lexus", "Blue");

        HashSet<Order> hashSet = new HashSet<>();
        hashSet.add(order3);
        hashSet.add(order2);
        hashSet.add(order1);
        hashSet.add(order4);
        System.out.println(hashSet);

        HashSet<Order> hashSet2 = new HashSet<>();
        hashSet2.add(order21);
        hashSet2.add(order22);
        hashSet2.add(order23);
        hashSet2.add(order24);

        hashSet.remove(order1);


        hashSet.retainAll(hashSet2);


        return hashSet;

    }
}
