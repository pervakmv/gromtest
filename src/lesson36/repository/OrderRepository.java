package lesson36.repository;

import lesson36.Utils.Common;
import lesson36.Utils.Utils;

import lesson36.Utils.ValidateType;
import lesson36.model.Hotel;
import lesson36.model.Order;
import lesson36.model.Room;

import java.io.*;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class OrderRepository {
    private final String pathToFile = "c:/temp/Order.txt";
    private final int IdKoef = 100000;
    private final int numberElementInLine = 6;

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

    public Order findOrderByRoomId(long id) throws Exception {
        for (Order object : mapping()) {
            if (object.getRoom() != null) {
                if (id == object.getRoom().getId()) {
                    return object;
                }
            }
        }
        return null;
    }


    private void writeToFile(Set<Order> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToFile, false))) {
            for (Order element : list) {
                bufferedWriter.append(element.toString() + '\n');
            }

        } catch (IOException e) {
            System.out.println("writeToFile: Can't write to file by path: " + pathToFile);
        }

    }

    public void validateFile() throws Exception {
        Utils.validateFile(pathToFile, ValidateType.Read);
    }

    public void validateFormatFile() throws Exception {
        Utils.validateFormatFile(pathToFile, numberElementInLine);
    }


    public Order lineToOrder(String line) throws Exception {
        line = line.replaceAll("\t", "");
        String[] array = line.split(",");
        UserRepository userRepository = new UserRepository();
        RoomRepository roomRepository = new RoomRepository();

        return new Order(Long.parseLong(array[0]), userRepository.findUserById(Long.parseLong(array[1])),
                roomRepository.findRoomById(Long.parseLong(array[2])), Utils.dateMapping(array[3]), Utils.dateMapping(array[4]), Double.parseDouble(array[5]));
    }


    public Set<Order> mapping() throws Exception {
        validateFile();
        validateFormatFile();
        Set<Order> res = new TreeSet<>();
        StringBuffer stringBuffer = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            long lineNumber = 0;

            while ((line = br.readLine()) != null) {


                res.add(lineToOrder(line));

            }
        } catch (Exception e) {
            System.out.println("File " + pathToFile + " was not read");

        }

        return res;
    }

    private boolean dateOfOrdersIsSame(Order orderA, Order orderB) {
        boolean res = false;


        if (orderA.getDateFrom().equals(orderB.getDateFrom()))
            res = true;
        if (orderA.getDateFrom().after(orderB.getDateFrom()) &&
                (orderA.getDateFrom().before(orderB.getDateTo()))
                || orderA.getDateFrom().equals(orderB.getDateTo()))
            res = true;

        return res;
    }

    public Order addOrder(Order order) throws Exception {

        Utils.validateFile(pathToFile, ValidateType.ReadWrite);
        System.out.println(order.toString());

        //Проверяю заказ на предмет накладок в заказах комнат
        Order orderByRoomId = findOrderByRoomId(order.getRoom().getId());
        if (orderByRoomId != null) {

            if (dateOfOrdersIsSame(order, orderByRoomId))
                throw new Exception("The room can't be booking");
        }

        //Генерирем ID
        long id = 0;
        do
            id = Math.round((Math.random()) * IdKoef);
        while (findOrderById(id) != null);
        order.setId(id);
        Common.addObjectToFile(order, pathToFile);
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
