package lesson36.demo;

import lesson36.Utils.Utils;
import lesson36.controller.RoomController;
import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.model.User;
import lesson36.repository.RoomRepository;
import lesson36.repository.UserRepository;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.Date;

public class DemoRoom {
    public static void main(String[] args) throws Exception{
        Room room = new Room();
        UserRepository userRepository = new UserRepository();
    //    RoomRepository roomRepository = new RoomRepository();
        RoomController roomController = new RoomController();


        String name = Utils.readKeyboardWithScannerString("User: ");

        String password = Utils.readKeyboardWithScannerString("password: ");
         userRepository.login(name,password);

//        Date dateAvailable = new Date((2018-1900), (10-1), 23);
//        System.out.println( roomController.findRooms(new Filter(2, 110, true, true, dateAvailable, "Ukraine", "Fastiv")));



//       System.out.println(" Функция bookRoom(long roomId, long userId, long hotelId)");
//        roomController.bookRoom(Utils.readKeyboardWithScannerLong("roomId: "),
//                               Utils.readKeyboardWithScannerLong("userId: "),
//                                Utils.readKeyboardWithScannerLong("hotelId:"));

       // roomController.cancelReservation(Utils.readKeyboardWithScannerLong(" roomId: "),
        //                                 Utils.readKeyboardWithScannerLong("userId :"));

        //System.out.println(roomCo);


//        System.out.println(userRepository.getLogenedUser().toString());
//

//        Room rm = new Room().enterDataByKeyboard();
//        room = roomController.addRoom(rm);
//
//        System.out.println(room);
//
//        userRepository.logout();
//        Utils.GetScores();


         Long idRoomWhoseDelete = Utils.readKeyboardWithScannerLong("Input Ident") ;
        roomController.deleteRoom(idRoomWhoseDelete);

        userRepository.logout();

        Utils.GetScores();
    }



}
