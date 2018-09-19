package lesson36.controller;

import lesson36.service.UserService;
import lesson36.model.User;

public class UserController  {

    private UserService userService = new UserService();

   public User registerUser(User user) throws Exception{
        return userService.registerUser(user);
    }

    public void login(String userName, String password) throws Exception{
        userService.login(userName, password);
    }

    public void logout() throws Exception{
        userService.logout();
    }
}
