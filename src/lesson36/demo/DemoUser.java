package lesson36.demo;

import lesson36.controller.UserController;
import lesson36.model.User;
import lesson36.repository.UserRepository;
import lesson36.service.UserService;

public class DemoUser {
    public static void main(String[] args) throws Exception{
        User user = new User();
        UserController userController = new UserController();
        UserRepository userRepository = new UserRepository();
        //System.out.println(user.enterDataByKeyboard().toString());

            System.out.println(userController.registerUser(new User().enterDataByKeyboard()).toString());

    }

}
