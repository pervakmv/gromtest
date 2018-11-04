package lesson36.repository;

import lesson36.Utils.Common;
import lesson36.Utils.Utils;
import lesson36.Utils.ValidateType;
import lesson36.model.Hotel;

import lesson36.model.Room;
import lesson36.model.User;

import java.io.*;
import java.util.*;


public class HotelRepository extends Repository<Hotel>{

    private User logenedUser;


    public HotelRepository(User logenedUser) {
        this.logenedUser = logenedUser;
    }

    public HotelRepository(String pathToFile, int idKoef, int numberElementInLine, User logenedUser) {
        super(pathToFile, idKoef, numberElementInLine);
        this.logenedUser = logenedUser;
    }

//    public HotelRepository() {
//    }
    //считывание данных обработка данных - считывание файла
    //обработка данных - маппинг данных



    public Hotel lineToMap(String line) throws Exception {
        line = line.replaceAll("\t", "");
        String[] array = line.split(",");
        return new Hotel(Long.parseLong(array[0]), array[1], array[2], array[3], array[4]);
    }



    public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        ArrayList<Hotel> hotels = mapping();
        ArrayList<Hotel> resHotels = new ArrayList<>();

        for (Hotel element : hotels) {
            if (element.getName().equals(name))
                resHotels.add(element);
        }
        return resHotels;
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        ArrayList<Hotel> hotels = mapping();

        ArrayList<Hotel> resHotels = new ArrayList<>();
        for (Hotel element : hotels) {

            if (element.getCity().equals(city)) {
                resHotels.add(element);

            }

        }
        return resHotels;
    }


    public Hotel deleteHotel(long hotelId) throws Exception {
        return deleteEntity(hotelId);
    }

    public Hotel findHotelById(long hotelId) throws Exception{
        return findEntityById(hotelId);
    }

    public Hotel addHotel(Hotel hotel) throws Exception{
        return super.addToRepository(hotel);
    }



    public Hotel deleteEntity(long hotelId) throws Exception {
        ArrayList<Hotel> hotels = mapping();
        RoomRepository roomRepository = new RoomRepository("c:/Temp/room.txt", 100, 7);
        ArrayList<Room> rooms = roomRepository.mapping(); //При удалении отеля нужно удалять и комнаты этого отеля
        System.out.println(rooms.toString());
        Hotel hotel = findEntityById(hotelId);
        if (hotel == null)
            throw new Exception("Hotel id:" + hotelId + " is not exist");

        Iterator<Room> iterator = rooms.iterator();
        while (iterator.hasNext()) {
            Room element = iterator.next();
            if (element.getHotel().getId() == hotelId) {
                iterator.remove();
            }
        }
        roomRepository.writeToFile(rooms);
        hotels.remove(hotel);
        writeToFile(hotels);

        return hotel;
    }




}
