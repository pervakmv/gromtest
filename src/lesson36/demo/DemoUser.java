package lesson36.demo;


import lesson36.Utils.Utils;
import lesson36.controller.UserController;
import lesson36.model.User;
import lesson36.repository.UserRepository;


public class DemoUser {
    public static void main(String[] args) throws Exception{
        User user = new User();
        UserController userController = new UserController();
       // System.out.println(userController.registerUser(user.enterDataByKeyboard()));
        UserRepository userRepository = new UserRepository(Utils.pathByUserFile, Utils.koefByUserId, Utils.numberElementInLineUser);
       // System.out.println(user.enterDataByKeyboard().toString());

        System.out.println(userRepository.findUserById(Utils.readKeyboardWithScannerLong("ID:= ")));
         //  System.out.println(userController.registerUser(new User().enterDataByKeyboard()).toString());

        //System.out.println(userRepository.mapping());


        Utils.GetScores();

    }

}
