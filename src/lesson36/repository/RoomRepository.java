package lesson36.repository;

import lesson36.Utils.Common;
import lesson36.Utils.Utils;
import lesson36.Utils.ValidateType;
import lesson36.model.*;

import java.io.*;
import java.util.*;


public class RoomRepository {

    private final String pathToFile = "c:/temp/Room.txt";
    private final int IdKoef = 100;
    private final int numberElementInLine = 7;



    //считывание данных обработка данных - считывание файла
    //обработка данных - маппинг данных

    public Room addRoom(Room room) throws Exception {
        //save user to db (files)
        //Генерирем ID
        long id = 0;
        do
            id = Math.round((Math.random()) * IdKoef);
        while (findRoomById(id) != null);
        room.setId(id);
        Utils.validateFile(pathToFile, ValidateType.Write);
        Common.addObjectToFile(room, pathToFile);

        return room;

    }

    public Room deleteRoom(long roomId) throws Exception {
        Utils.validateFile(pathToFile, ValidateType.ReadWrite);
        ArrayList<Room> rooms = mapping();
        Room room = findRoomById(roomId, rooms);
        if (room == null)
            throw new Exception("Hotel id:" + roomId + " is not exist");

        //Нужно сначала удалить все заказы этой комнаты

        OrderRepository orderRepository = new OrderRepository();
        orderRepository.deleteOrder(orderRepository.findOrderByRoomId(roomId).getId());
        rooms.remove(room);
        writeToFile(rooms);

        return room;
    }

    public Room findRoomById(long id, Collection<Room> data) throws Exception {
        if (data == null)
            return null;

        for (Room object : data) {
            if (id == object.getId()) {
                return object;
            }
        }
        return null;
    }

    public Room findRoomById(long id) throws Exception {
        return findRoomById(id, mapping());
    }


    public void writeToFile(ArrayList<Room> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToFile, false))) {
            for (Room element : list) {
                bufferedWriter.append(element.toString() + '\n');
            }

        } catch (IOException e) {
            System.out.println("Can't write to file by path: " + pathToFile);
        }
    }


    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        //проверяем наличие такого отеля
        HotelRepository hotelRepository = new HotelRepository();
        Hotel hotel = hotelRepository.findHotelById(hotelId);
        if (hotel == null)
            throw new Exception("bookRoom: There is hotel with id:" + hotelId + " is not exist");
        //проверяем наличие зарегистрированного пользователя
        UserRepository userRepository = new UserRepository();
        User user = userRepository.findUserById(userId);

        if (user == null)
            throw new Exception("bookRoom: There is user with id:" + userId + " is not exist");

        //проверяем наличие комнаты с таким ID
        Room room = findRoomById(roomId);

        //Выдаем исключение в случае отсутствия комнаты с таким ID в отеле с заданным ID
        if (room.getHotel().getId() != hotelId) {
            throw new Exception("bookRoom: Hotel " + hotel.getName() + " doesn't have room with id:" + roomId);
        }

        int amountOfDays = 2;
        Date dateFrom = new Date();
        Date dateTo = new Date();
        dateTo.setDate(dateFrom.getDate() + amountOfDays);
        double moneyPaid = (double) amountOfDays * room.getPrice();
        Order order = new Order(user, room, dateFrom, dateTo, moneyPaid);
        OrderRepository orderRepository = new OrderRepository();
        orderRepository.addOrder(order);

    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        OrderRepository orderRepository = new OrderRepository();
        Set<Order> orders = orderRepository.mapping();
        boolean thereIsSuchAnElement = false;

        for (Order element : orders) {
            if (element.getRoom().getId() == roomId &&
                    element.getUser().getId() == userId) {

                orderRepository.deleteOrder(element.getId());
                thereIsSuchAnElement = true;
                break;
            }
        }
        if (thereIsSuchAnElement == false) {
            throw new Exception("This order is missing");
        }

    }

    public void validateFile() throws Exception {
        Utils.validateFile(pathToFile, ValidateType.Read);
    }

    public void validateFormatFile() throws Exception {
        Utils.validateFormatFile(pathToFile, numberElementInLine);
    }

    public Room lineToRoom(String line) throws Exception {
        line = line.replaceAll("\t", "");
        String[] array = line.split(",");


        int numberOfGuests = Integer.parseInt(array[1]);
        Double price = Double.parseDouble(array[2]);
        boolean breakfastIncluded = false;
        if (array[3].equals("true"))
            breakfastIncluded = true;
        boolean petsAllowed = false;
        if (array[4].equals("true"))
            petsAllowed = true;

        Date date = Utils.dateMapping(array[5]);
        HotelRepository hotelRepository = new HotelRepository();
        Hotel hotel = hotelRepository.findHotelById(Long.parseLong(array[6]));
        if (hotel == null)
            throw new Exception("Hotel with id: " + array[6] + " was not find in repository");

        return new Room(Long.parseLong(array[0]), numberOfGuests, price, breakfastIncluded, petsAllowed, date, hotel);


    }


    public ArrayList<Room> mapping() throws Exception {
        ArrayList<Room> res = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            validateFile();
            validateFormatFile();
            String line;

            while ((line = br.readLine()) != null) {
                res.add(lineToRoom(line));
            }
        } catch (Exception e) {
            System.out.println("File " + pathToFile + "was not read");

        }
        return res;
    }


    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        ArrayList<Room> res = new ArrayList<>();

        ArrayList<Room> rooms = mapping();

        for (Room rm : rooms) {

            if (rm.equalsByFilter(filter)) {
                res.add(rm);
            }
        }

        return res;
    }

}
