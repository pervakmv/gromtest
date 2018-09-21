package lesson36.repository;

import lesson36.model.*;

import java.io.*;
import java.util.*;


public class RoomRepository {

    private final String pathToFile = "c:/temp/Room.txt";
    private final int IdKoef = 100;
    private final int numberOfField = 7;


    //  public RoomRepository() {
    // }


    //считывание данных обработка данных - считывание файла
    //обработка данных - маппинг данных

    public Room addRoom(Room room) throws Exception {
        //save user to db (files)
        ArrayList<Room> rooms = mapping();
        // if (rooms.contains(room))
        //     throw new Exception("Room already exist");

        //Генерирем ID
        long id = 0;
        do
            id = Math.round((Math.random()) * IdKoef);
        while (findRoomById(id, rooms) != null);
        room.setId(id);
        rooms.add(room);
        writeToFile(rooms);
        return room;

    }

    public Room deleteRoom(long roomId) throws Exception {
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
        throw new Exception("findRoomById: room with Id " + id + " is not exist");
    }

    public Room findRoomById(long id) throws Exception {
        return findRoomById(id, mapping());
    }


    public void writeToFile(ArrayList<Room> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToFile, false))) {
            for (Room element : list) {
                bufferedWriter.append(element.toFileFormat() + '\n');
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


    public ArrayList<Room> mapping() throws Exception {
        ArrayList<Room> res = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            long lineNumber = 0;
            HotelRepository hotelRepository = new HotelRepository();
            while ((line = br.readLine()) != null) {

                line = line.replaceAll("\t", ""); //Убираем табуляции


                String[] array = line.split(",");
                if (array.length != numberOfField)
                    throw new Exception("Error in data file: " + pathToFile + " line number: " + lineNumber);


                int numberOfGuests = Integer.parseInt(array[1]);
                Double price = Double.parseDouble(array[2]);
                boolean breakfastIncluded = false;
                if (array[3].equals("true"))
                    breakfastIncluded = true;
                boolean petsAllowed = false;
                if (array[4].equals("true"))
                    petsAllowed = true;

                String[] dateString = array[5].split("-");

                Date date = new Date();
                date.setDate(Integer.parseInt(dateString[0]));
                date.setMonth(Integer.parseInt(dateString[1]) - 1);
                date.setYear(Integer.parseInt(dateString[2]) - 1900);


                Hotel hotel = hotelRepository.findHotelById(Long.parseLong(array[6]));

                Room room = new Room(Long.parseLong(array[0]), numberOfGuests, price, breakfastIncluded, petsAllowed, date, hotel);
                res.add(room);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + pathToFile + "does not exist");

        } catch (IOException e) {
            System.out.println("Readin form file " + pathToFile + "failed");
        }
//        } catch (IllegalArgumentException e) {
//            System.out.println("RoomRepository: IllegalArgumentException");
//        }

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
