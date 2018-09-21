package lesson36.controller;

import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.repository.UserRepository;
import lesson36.service.RoomService;

import java.util.ArrayList;

public class RoomController {

    private RoomService roomService = new RoomService();


    public Room addRoom(Room room) throws Exception {
        return roomService.addRoom(room);
    }

    public Room deleteRoom(long roomId) throws Exception {
        return roomService.deleteRoom(roomId);
    }

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        roomService.bookRoom(roomId, userId, hotelId);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        roomService.cancelReservation(roomId, userId);
    }

    public ArrayList<Room> findRooms(Filter filter) throws Exception{
        return roomService.findRooms(filter);
    }
}
