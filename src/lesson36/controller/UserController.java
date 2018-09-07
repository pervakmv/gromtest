package lesson36.controller;

import lesson36.service.UserService;
import lesson36.model.User;

public class UserController  {

    private UserService userService = new UserService();

   public User registerUser(User user) throws Exception{
        return userService.registerUser(user);
    }
}
