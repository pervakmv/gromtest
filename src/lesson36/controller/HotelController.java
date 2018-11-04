package lesson36.controller;

import lesson36.model.Hotel;
import lesson36.service.HotelService;

import java.util.ArrayList;
import java.util.Set;


public class HotelController {

    private HotelService hotelService = new HotelService();

    public Hotel addHotel(Hotel hotel) throws Exception{
        return hotelService.addHotel(hotel);
    }

    public Hotel deleteHotel(long hotelId) throws Exception{
        return hotelService.deleteHotel(hotelId);
    }

    public ArrayList<Hotel> findHotelByName(String name) throws Exception{
        return hotelService.findHotelByName(name);
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception{
        return hotelService.findHotelByCity(city);
    }
}
