package lesson26.HW;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {


    public static void main(String[] args) {
        ArrayList<Order> orderArrayList = useList();

        Order order1 = new Order(100, 1200, "dollar", "left", "Silpo");
        Order order2 = new Order(102, 3200, "evro", "right", "Fora");
        Order order3 = new Order(103, 2400, "pound", "middle", "EcoMarket");
        Order order4 = new Order(104, 8800, "krona", "behinde", "EcoMarket");

        Order order21 = new Order(200, 1200, "dollar", "left", "Silpo");
        Order order22 = new Order(202, 3200, "evro", "right", "Fora");
        Order order23 = new Order(203, 2400, "pound", "middle", "EcoMarket");
        Order order24 = new Order(204, 8800, "krona", "behinde", "EcoMarket");


        orderArrayList.add(order1);
        System.out.println(orderArrayList.toString());


        orderArrayList.remove(order1);
        System.out.println(orderArrayList.toString());

        orderArrayList.add(order2);
        orderArrayList.add(order3);
        System.out.println(orderArrayList.toString());

        orderArrayList.add(order3);
        System.out.println(orderArrayList.toString());

        orderArrayList.remove(2);
        System.out.println(orderArrayList.toString());

        ArrayList<Order> orderArrayList2  = useList();
        orderArrayList2.add(order21);

        System.out.println(orderArrayList2.toString());

        orderArrayList.addAll(orderArrayList2);

        System.out.println(orderArrayList.toString());

        System.out.println(orderArrayList.subList(1,3));

        System.out.println(orderArrayList.toString());

        orderArrayList.set(2, order22);

        System.out.println(orderArrayList.toString());

        System.out.println(orderArrayList.contains(order23));


        Object[] orderArray = orderArrayList.toArray();

        System.out.println(Arrays.deepToString(orderArray));


        orderArrayList.clear();
        System.out.println(orderArrayList.toString());




    }


    public static ArrayList<Order> useList() {
        ArrayList<Order> orderArrayList = new ArrayList<>();
        return orderArrayList;
    }

}
