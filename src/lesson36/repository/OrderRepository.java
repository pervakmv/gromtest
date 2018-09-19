package lesson36.repository;

import lesson36.Utils.Utils;
import lesson36.model.Hotel;
import lesson36.model.Order;

import java.io.*;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class OrderRepository {
    private final String pathToFile = "c:/temp/Order.txt";
    private final int IdKoef = 100000;
    private final int numberOfField = 6;

    public OrderRepository() {
    }
    //считывание данных обьработка данных - считывание файла
    //обьработака данных - маппинг данных

    public Order findOrderById(long id, Collection<Order> data) {
        if (data == null)
            return null;

        for (Order object : data) {
            if (id == object.getId()) {
                return object;
            }
        }
        return null;
    }

    public Order findOrderById(long id) throws Exception {
        return findOrderById(id, mapping());
    }


    private void writeToFile(Set<Order> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToFile, false))) {
            for (Order element : list) {
                bufferedWriter.append(element.toFileFormat() + '\n');
            }

        } catch (IOException e) {
            System.out.println("writeToFile: Can't write to file by path: " + pathToFile);
        }

    }


    public Set<Order> mapping() throws Exception {
        Set<Order> res = new TreeSet<>();
        StringBuffer stringBuffer = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            long lineNumber = 0;

            while ((line = br.readLine()) != null) {

                line = line.replaceAll("\t", ""); //Убираем табуляции


                String[] array = line.split(",");
                if (array.length != numberOfField)
                    throw new Exception("Error in data file: " + pathToFile + " line number: " + lineNumber);

                UserRepository userRepository = new UserRepository();
                RoomRepository roomRepository = new RoomRepository();

                Order Order = new Order(Long.parseLong(array[0]), userRepository.findUserById(Long.parseLong(array[1])),
                        roomRepository.findRoomById(Long.parseLong(array[2])), Utils.dateMapping(array[3]), Utils.dateMapping(array[4]), Double.parseDouble(array[5]));
                res.add(Order);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + pathToFile + "does not exist");

        } catch (IOException e) {
            System.out.println("Readin form file " + pathToFile + "failed");
        } catch (IllegalArgumentException e) {
            System.out.println("User type is incorrect");
        }

        return res;
    }


    public Order addOrder(Order order) throws Exception {

        System.out.println(order.toString());
        Set<Order> orders = mapping();
        if (orders.contains(order))
            throw new Exception("addOrder: Order already exist");

        //Генерирем ID
        long id = 0;
        do
            id = Math.round((Math.random()) * IdKoef);
        while (findOrderById(id, orders) != null);
        order.setId(id);
        orders.add(order);
        writeToFile(orders);
        return order;
    }


    public Order deleteOrder(long OrderId) throws Exception {
        Set<Order> Orders = mapping();
        Order Order = findOrderById(OrderId, Orders);
        if (Order == null)
            throw new Exception("Order id:" + OrderId + " is not exist");
        Orders.remove(Order);
        writeToFile(Orders);
        return Order;
    }

}
