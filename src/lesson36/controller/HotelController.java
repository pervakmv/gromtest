package lesson36.controller;

import lesson36.model.Hotel;
import lesson36.service.HotelService;


public class HotelController {

    private HotelService hotelService = new HotelService();

    public Hotel addHotel(Hotel hotel) throws Exception{
        return hotelService.addHotel(hotel);
    }

    public Hotel deleteHotel(long hotelId) throws Exception{
        return hotelService.deleteHotel(hotelId);
    }
}
