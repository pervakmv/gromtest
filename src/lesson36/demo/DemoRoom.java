package lesson36.demo;

import lesson36.Utils.Utils;
import lesson36.controller.RoomController;

import lesson36.model.Filter;
import lesson36.model.Room;

import lesson36.repository.RoomRepository;
import lesson36.repository.UserRepository;

import java.util.Date;


public class DemoRoom {
    public static void main(String[] args) throws Exception{
        Room room = new Room();
        UserRepository userRepository = new UserRepository(Utils.pathByUserFile, Utils.koefByUserId, Utils.numberElementInLineUser);
    //    RoomRepository roomRepository = new RoomRepository();
        RoomController roomController = new RoomController();


        String name = Utils.readKeyboardWithScannerString("User: ");

        String password = Utils.readKeyboardWithScannerString("password: ");
         userRepository.login(name,password);

//        Date dateAvailable = new Date((2018-1900), (11-1), 8);
//       System.out.println( roomController.findRooms(new Filter(1, 146, true, true, dateAvailable, "Ukraine", "Fastiv")));



//       System.out.println(" Функция bookRoom(long roomId, long userId, long hotelId)");
//        roomController.bookRoom(Utils.readKeyboardWithScannerLong("roomId: "),
//                               Utils.readKeyboardWithScannerLong("userId: "),
//                                Utils.readKeyboardWithScannerLong("hotelId:"));

        roomController.cancelReservation(Utils.readKeyboardWithScannerLong(" roomId: "),
                                         Utils.readKeyboardWithScannerLong("userId :"));



//        Room rm = new Room().enterDataByKeyboard();
//        room = roomController.addRoom(rm);



       // System.out.println(room);




//         Long idRoomWhoseDelete = Utils.readKeyboardWithScannerLong("Input Room ident: ") ;
//        roomController.deleteRoom(idRoomWhoseDelete);

        userRepository.logout();

        Utils.GetScores();
    }



}
