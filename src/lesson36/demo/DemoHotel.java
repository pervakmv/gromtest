package lesson36.demo;

import lesson36.Utils.Utils;
import lesson36.controller.HotelController;
import lesson36.controller.UserController;
import lesson36.model.Hotel;
import lesson36.model.User;
import lesson36.repository.HotelRepository;
import lesson36.repository.UserRepository;

import java.util.Scanner;

import static lesson36.Utils.Utils.readKeyboardWithScannerLong;

public class DemoHotel {
    public static void main(String[] args) throws Exception {
        Hotel hotel = new Hotel();
        HotelController hotelController = new HotelController();
        UserRepository userRepository = new UserRepository();
        //System.out.println(user.enterDataByKeyboard().toString());

        String name = Utils.readKeyboardWithScannerString("User: ");
        String password = Utils.readKeyboardWithScannerString("password: ");

        userRepository.login(name, password);

         //System.out.println(hotelController.addHotel(new Hotel().enterDataByKeyboard()).toString());

      //System.out.println(hotelController.deleteHotel(readKeyboardWithScannerLong("Id:= ")));


        //System.out.println(hotelController.findHotelByName(Utils.readKeyboardWithScannerString("Name :")).toString());

         //System.out.println(hotelController.findHotelByCity(Utils.readKeyboardWithScannerString("City :")).toString());
    }


}
