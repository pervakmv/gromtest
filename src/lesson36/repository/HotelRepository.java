package lesson36.repository;

import lesson36.Utils.Common;
import lesson36.Utils.Utils;
import lesson36.Utils.ValidateType;
import lesson36.model.Hotel;
import lesson36.model.Order;
import lesson36.model.Room;
import lesson36.model.User;

import java.io.*;
import java.util.*;


public class HotelRepository {

    private final String pathToFile = "c:/temp/Hotel.txt";
    private final int IdKoef = 10000;
    private final int numberElementInLine = 5;
    private User logenedUser;

    public HotelRepository(User logenedUser) {
        this.logenedUser = logenedUser;
    }

    public HotelRepository() {
    }
    //считывание данных обработка данных - считывание файла
    //обработка данных - маппинг данных

    public Hotel addHotel(Hotel hotel) throws Exception {
        //save user to db (files)

        //Генерирем ID
        long id = 0;
        do
            id = Math.round((Math.random()) * IdKoef);
        while (findHotelById(id) != null);
        hotel.setId(id);
        Common.addObjectToFile(hotel, pathToFile);
        return hotel;

    }

    public Hotel deleteHotel(long hotelId) throws Exception {
        Set<Hotel> hotels = mapping();
        RoomRepository roomRepository = new RoomRepository();
        ArrayList<Room> rooms = roomRepository.mapping(); //При удалении отеля нужно удалять и комнаты этого отеля
        System.out.println(rooms.toString());
        Hotel hotel = findHotelById(hotelId, hotels);
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

    public Hotel findHotelById(long id, Collection<Hotel> data) {
        if (data == null)
            return null;

        for (Hotel object : data) {
            if (id == object.getId()) {
                return object;
            }
        }
        return null;
    }

    public Hotel findHotelById(long id) throws Exception {

        for (Hotel object : mapping()) {
            if (id == object.getId()) {
                return object;
            }
        }
        return null;
    }


    private void writeToFile(Set<Hotel> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToFile, false))) {
            for (Hotel element : list) {
                bufferedWriter.append(element.toFileFormat() + '\n');
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


    public Hotel lineToOrder(String line) throws Exception {
        line = line.replaceAll("\t", "");
        String[] array = line.split(",");
        return new Hotel(Long.parseLong(array[0]), array[1], array[2], array[3], array[4]);
    }


    public Set<Hotel> mapping() throws Exception {
        validateFile();
        validateFormatFile();
        Set<Hotel> res = new TreeSet<>();
        StringBuffer stringBuffer = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            long lineNumber = 0;

            while ((line = br.readLine()) != null) {

                line = line.replaceAll("\t", ""); //Убираем табуляции
                res.add(lineToOrder(line));

            }
        } catch (Exception e) {
            System.out.println("File " + pathToFile + " was not read");
        }

        return res;
    }

    public Set<Hotel> findHotelByName(String name) throws Exception {
        Set<Hotel> hotels = mapping();
        Set<Hotel> resHotels = new TreeSet<>();

        for (Hotel element : hotels) {
            if (element.getName().equals(name))
                resHotels.add(element);
        }
        return resHotels;
    }

    public Set<Hotel> findHotelByCity(String city) throws Exception {
        Set<Hotel> hotels = mapping();

        Set<Hotel> resHotels = new TreeSet<>();
        for (Hotel element : hotels) {

            if (element.getCity().equals(city)) {
                resHotels.add(element);

            }

        }
        return resHotels;
    }

}
