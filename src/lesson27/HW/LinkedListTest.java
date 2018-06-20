package lesson27.HW;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Order> linkedList = useList();

        System.out.println(Arrays.deepToString(linkedList.toArray()));
    }

    public static LinkedList<Order> useList(){

        LinkedList<Order> linkedList = new LinkedList<>();

        linkedList.add(new Order(2323, 1300, "dolar", "Car", "Auto"));

        linkedList.add(0, new Order(2324, 1230, "dolar", "Controller", "Techinprom"));

        linkedList.add(new Order(2326, 800, "dolar", "Kangoo", "Metro"));
        linkedList.add(0, new Order(2327, 674, "dolar", "PLC", "Mob"));

        System.out.println(" before " + Arrays.deepToString(linkedList.toArray()));

        linkedList.remove(0);
        linkedList.remove(new Order(2324, 1230, "dolar", "Controller", "Techinprom"));

        LinkedList<Order> linkedListAddAllExample = new LinkedList<>();
        linkedListAddAllExample.add(new Order(100, 23, "dolar", "pan", "Ruanda"));
        linkedListAddAllExample.clear();
        linkedListAddAllExample.add(new Order( 102, 244, "dolar", "pencil", "table"));
        linkedListAddAllExample.add(new Order( 103, 285, "dolar", "flower", "commomil"));
        linkedListAddAllExample.add(new Order( 104, 455, "dolar", "equipment", "freqInvertor"));
        linkedListAddAllExample.add(new Order( 105, 540, "dolar", "maps", "shop"));
        linkedList.addAll(0, linkedListAddAllExample);

        linkedList.set(0,new Order(100, 100, "dolar", "pan", "Ruanda"));
        System.out.println(linkedList.contains(new Order(100, 10, "dolar", "pan", "Ruanda")));

        linkedList.subList(0, 4);


        return linkedList;


    }
}
