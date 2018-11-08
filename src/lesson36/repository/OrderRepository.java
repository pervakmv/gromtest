package lesson36.repository;

import lesson36.Utils.Common;
import lesson36.Utils.Utils;

import lesson36.Utils.ValidateType;
import lesson36.model.Hotel;
import lesson36.model.Order;
import lesson36.model.Room;

import java.io.*;

import java.util.*;

public class OrderRepository extends Repository<Order> {


    public OrderRepository(String pathToFile, int idKoef, int numberElementInLine) {
        super(pathToFile, idKoef, numberElementInLine);
    }

    // public OrderRepository() {
    //}
    //считывание данных обьработка данных - считывание файла
    //обьработака данных - маппинг данных

    public Order findOrderById(long id) throws Exception {
        return findEntityById(id);
    }

    public ArrayList<Order> findOrdersByRoomId(long id) throws Exception {
        ArrayList<Order> orders = new ArrayList<>();
        for (Order object : mapping()) {
            if (object.getRoom() != null) {
                if (id == object.getRoom().getId()) {
                    orders.add(object);
                }
            }
        }
        return orders;
    }


    public Order lineToMap(String line) throws Exception {
        line = line.replaceAll("\t", "");
        String[] array = line.split(",");
        UserRepository userRepository = new UserRepository(Utils.pathByUserFile, Utils.koefByUserId, Utils.numberElementInLineUser);
        RoomRepository roomRepository = new RoomRepository(Utils.pathByRoomFile, Utils.koefByHotelId, Utils.numberElementInLineRoom);

        return new Order(Long.parseLong(array[0]), userRepository.findUserById(Long.parseLong(array[1])),
                roomRepository.findRoomById(Long.parseLong(array[2])), Utils.dateMapping(array[3]), Utils.dateMapping(array[4]), Double.parseDouble(array[5]));
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

        return addToRepository(order);
    }


    public Order deleteOrder(long OrderId) throws Exception {

        return deleteEntity(OrderId);
    }

    public void deleteOrders(ArrayList<Order> orders) throws Exception {
        for (Order order : mapping()) {
            deleteOrder(order.getId());
        }
    }
}
