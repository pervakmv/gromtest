package lesson36.demo;

import lesson36.Utils.Utils;
import lesson36.controller.RoomController;
import lesson36.model.Room;
import lesson36.model.User;
import lesson36.repository.RoomRepository;
import lesson36.repository.UserRepository;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class DemoRoom {
    public static void main(String[] args) throws Exception{
        Room room = new Room();
        UserRepository userRepository = new UserRepository();
        RoomRepository roomRepository = new RoomRepository();



        String name = Utils.readKeyboardWithScannerString("User: ");

        String password = Utils.readKeyboardWithScannerString("password: ");

        //Long idRoomWhoseDelete = Utils.readKeyboardWithScannerLong("Input Ident") ;

        System.out.println(" Функция bookRoom(long roomId, long userId, long hotelId)");
        roomRepository.bookRoom(Utils.readKeyboardWithScannerLong("roomId: "),
                                Utils.readKeyboardWithScannerLong("userId: "),
                                Utils.readKeyboardWithScannerLong("hotelId:"));



        userRepository.login(name,password);
//        System.out.println(userRepository.getLogenedUser().toString());
//
//        RoomController roomController = new RoomController();
//        Room rm = new Room().enterDataByKeyboard();
//        room = roomController.addRoom(rm);
//
//        System.out.println(room);
//
//        userRepository.logout();
//        Utils.GetScores();



        //roomController.deleteRoom(idRoomWhoseDelete);



        Utils.GetScores();
    }



}
