package lesson36.service;

import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.repository.RoomRepository;
import lesson36.repository.UserRepository;

import java.util.ArrayList;

public class RoomService {


    private RoomRepository roomRepository = new RoomRepository("c:/Temp/room.txt", 100, 7);


    public Room addRoom(Room room) throws Exception {
        //check logon
        System.out.println(UserRepository.logenedUser.getUserName());
        if (!UserRepository.logonWasSuccesful())
            throw new Exception("addRoom: You need login");


        if (!UserRepository.logenedUserHasAdminPermit())
            throw new Exception("addRoom: User has not enough permits");


        //check business logic
        if (!room.canBeAdd())
            throw new Exception("addRoom: The entered room data can't be add");
        //if logic is ok

        return roomRepository.addRoom(room);
    }

    public Room deleteRoom(long roomId) throws Exception {

        if (!UserRepository.logonWasSuccesful())
            throw new Exception("addRoom: You need login");


        if (!UserRepository.logenedUserHasAdminPermit())
            throw new Exception("addRoom: User has not enough permits");

        return roomRepository.deleteRoom(roomId);
    }

    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        if (!UserRepository.logonWasSuccesful())
            throw new Exception("addRoom: You need login");

        roomRepository.bookRoom(roomId, userId, hotelId);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        if (!UserRepository.logonWasSuccesful())
            throw new Exception("addRoom: You need login");

        roomRepository.cancelReservation(roomId, userId);
    }

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        if (!UserRepository.logonWasSuccesful())
            throw new Exception("addRoom: You need login");
        return roomRepository.findRooms(filter);
    }
}
