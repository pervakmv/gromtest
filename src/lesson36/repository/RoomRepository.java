package lesson36.repository;

import lesson36.model.Hotel;

import java.io.*;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class RoomRepository {

    private final String pathToFile = "c:/temp/Room.txt";
    private final int IdKoef = 100;
    private final int numberOfField = 7;

    //считывание данных обработка данных - считывание файла
    //обработка данных - маппинг данных

    public Hotel addHotel(Hotel hotel) throws Exception {
        //save user to db (files)
        Set<Hotel> hotels = mapping();
        if (hotels.contains(hotel))
            throw new Exception("Hotel already exist");

        //Генерирем ID
        long id = 0;
        do
            id = Math.round((Math.random()) * IdKoef);
        while (findHotelById(id, hotels) != null);
        hotel.setId(id);

        hotels.add(hotel);

        writeToFile(hotels);

        return hotel;

    }

    public Hotel deleteHotel(long hotelId) throws Exception {
        Set<Hotel> hotels = mapping();
        Hotel hotel = findHotelById(hotelId, hotels);
        if (hotel == null)
            throw new Exception("Hotel id:" + hotelId + " is not exist");
        hotels.remove(hotel);
        writeToFile(hotels);

        return hotel;
    }

    private Hotel findHotelById(long id, Collection<Hotel> data) {
        if (data == null)
            return null;

        for (Hotel object : data) {
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
            System.out.println("Can't write to file by path: " + pathToFile);
        }
    }


    public Set<Hotel> mapping() throws Exception {
        Set<Hotel> res = new TreeSet<>();
        StringBuffer stringBuffer = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            long lineNumber = 0;

            while ((line = br.readLine()) != null) {

                line = line.replaceAll("\t", ""); //Убираем табуляции


                String[] array = line.split(",");
                if (array.length != numberOfField)
                    throw new Exception("Error in data file: " + pathToFile + " line number: " + lineNumber);


                Hotel hotel = new Hotel(Long.parseLong(array[0]), array[1], array[2], array[3]);
                res.add(hotel);
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


}
