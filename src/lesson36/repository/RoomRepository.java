package lesson36.repository;

import lesson36.Utils.Utils;
import lesson36.model.*;

import java.util.*;


public class RoomRepository extends Repository<Room> {

    //считывание данных обработка данных - считывание файла
    //обработка данных - маппинг данных

//    public RoomRepository() {
//    }

    public RoomRepository(String pathToFile, int idKoef, int numberElementInLine) {
        super(pathToFile, idKoef, numberElementInLine);
    }

    public Room addRoom(Room room) throws Exception {

        return super.addToRepository(room);
    }

    public Room deleteRoom(long roomId) throws Exception {
        //Нужно сначала удалить все заказы этой комнаты
        OrderRepository orderRepository = new OrderRepository(Utils.pathByOrderFile, Utils.koefByOrderId, Utils.numberElementInLineOrder);
        orderRepository.deleteOrders(orderRepository.findOrdersByRoomId(roomId));
        return super.deleteEntity(roomId);
    }


    public Room findRoomById(long id) throws Exception {
        return super.findEntityById(id);
    }

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        //проверяем наличие такого отеля
        HotelRepository hotelRepository = new HotelRepository(Utils.pathByHotelFile, Utils.koefByHotelId, Utils.numberElementInLineHotel, null);
        Hotel hotel = hotelRepository.findHotelById(hotelId);
        if (hotel == null)
            throw new Exception("bookRoom: There is hotel with id:" + hotelId + " is not exist");
        //проверяем наличие зарегистрированного пользователя
        UserRepository userRepository = new UserRepository(Utils.pathByUserFile, Utils.koefByUserId, Utils.numberElementInLineUser);
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
        OrderRepository orderRepository = new OrderRepository(Utils.pathByOrderFile, Utils.koefByOrderId, Utils.numberElementInLineOrder);
        orderRepository.addOrder(order);

    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        OrderRepository orderRepository = new OrderRepository(Utils.pathByOrderFile, Utils.koefByOrderId, Utils.numberElementInLineOrder);
        ArrayList<Order> orders = orderRepository.mapping();
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

    public Room lineToMap(String line) throws Exception {
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
        HotelRepository hotelRepository = new HotelRepository(Utils.pathByHotelFile, Utils.koefByHotelId, Utils.numberElementInLineHotel, null);
        Hotel hotel = hotelRepository.findHotelById(Long.parseLong(array[6]));
        if (hotel == null)
            throw new Exception("Hotel with id: " + array[6] + " was not find in repository");

        return new Room(Long.parseLong(array[0]), numberOfGuests, price, breakfastIncluded, petsAllowed, date, hotel);
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
