package lesson36.service;

import lesson36.model.Hotel;
import lesson36.repository.HotelRepository;
import lesson36.repository.UserRepository;

import java.util.ArrayList;
import java.util.Set;

public class HotelService {
    private HotelRepository hotelRepository = new HotelRepository("c:/Temp/hotel.txt", 1000, 5, null);


    public Hotel addHotel(Hotel hotel) throws Exception {
        //check login

        if (!UserRepository.logonWasSuccesful())
            throw new Exception("addRoom: You need login");


        if (!UserRepository.logenedUserHasAdminPermit())
            throw new Exception("addRoom: User has not enough permits");

        //if hotel is exist in repo
        if(!hotelRepository.findHotelByName(hotel.getName()).isEmpty() &&
                !hotelRepository.findHotelByCity(hotel.getCity()).isEmpty())
            throw new Exception("Hotel with name " + hotel.getName() + " is already exist" + " in the City : " + hotel.getCity());

        //check business logic
        if (!hotel.canBeAdd())
            throw new Exception("The entered hotel data can't be add");

        //if logic is ok
        return hotelRepository.addHotel(hotel);
    }

    public Hotel deleteHotel(long hotelId) throws Exception {

        if (!UserRepository.logonWasSuccesful())
            throw new Exception("addRoom: You need login");


        if (!UserRepository.logenedUserHasAdminPermit())
            throw new Exception("addRoom: User has not enough permits");


        return hotelRepository.deleteHotel(hotelId);
    }

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {

        if (!UserRepository.logonWasSuccesful())
            throw new Exception("addRoom: You need login");

        return hotelRepository.findHotelByName(name);
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {

        if (!UserRepository.logenedUserHasAdminPermit())
            throw new Exception("addRoom: User has not enough permits");
        return hotelRepository.findHotelByCity(city);
    }


}
