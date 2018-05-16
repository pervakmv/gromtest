
package lesson7;

//import lesson6.Order;

import java.util.Date;

public class Demo {

    public static void main(String[] args) {

        Order order = createOrder();
        System.out.print(order.dateCreated.getDate());
        System.out.print(".");
        System.out.print(order.dateCreated.getMonth());
        System.out.print(".");
        System.out.println(order.dateCreated.getYear());
        System.out.println(order.city);

        Order order2 = createOrderAndCallMethods();
        System.out.println(order2.city);
    }

    public static Order createOrder() {
        Date curDate = new Date(2018, 04, 30);

        return new Order(100, curDate, false, null, "Dnepr", "Ukraine", "Buy");

    }

    public static Order createOrderAndCallMethods() {
        Date curDate = new Date(2018, 04, 30);
        Order orderObject = new Order(100, curDate, true, curDate, "Kiev", "Ukraine", "SomeValue");
        orderObject.confirmOrder();
        boolean isValidate = orderObject.isValidType();
        System.out.println(isValidate);


        return orderObject;
    }
}
