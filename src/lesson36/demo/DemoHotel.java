package lesson36.demo;

import lesson36.controller.HotelController;
import lesson36.controller.UserController;
import lesson36.model.Hotel;
import lesson36.model.User;
import lesson36.repository.HotelRepository;
import lesson36.repository.UserRepository;

import java.util.Scanner;

public class DemoHotel {
    public static void main(String[] args) throws Exception {
        Hotel hotel = new Hotel();
        HotelController hotelController = new HotelController();
        HotelRepository userRepository = new HotelRepository();
        //System.out.println(user.enterDataByKeyboard().toString());

        // System.out.println(hotelController.addHotel(new Hotel().enterDataByKeyboard()).toString());

        System.out.println(hotelController.deleteHotel(readKeyboardWithScannerLong("Id:= ")));

    }


    private static long readKeyboardWithScannerLong(String prefStr) {
        Scanner scanner = new Scanner(System.in);

        //usinscanner


        System.out.println(prefStr);

        String str = scanner.nextLine();

        scanner.close();
        return Long.valueOf(str);

    }


}
