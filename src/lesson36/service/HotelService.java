package lesson36.service;

import lesson36.model.Hotel;
import lesson36.repository.HotelRepository;

public class HotelService {
    private HotelRepository hoteRepository = new HotelRepository();

    public Hotel addHotel(Hotel hotel) throws Exception{
        //check business logic
        if(!hotel.canBeAdd())
            throw new Exception ("The enetered hotel data can't be add" );

        //if logic is ok
        return hoteRepository.addHotel(hotel);
    }

    public Hotel deleteHotel(long hotelId) throws Exception{
        return hoteRepository.deleteHotel(hotelId);
    }
}
