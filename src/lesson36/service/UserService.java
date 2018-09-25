package lesson36.service;

import lesson36.model.User;
import lesson36.repository.UserRepository;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public User registerUser(User user) throws Exception {


        //check business logic (не должны быть пустые поля, Юзеру должно быть больше 18 лет

        if(!user.canBeRegistred())
            throw new Exception("The entered data can't be written");

        //if user is exist in base
        if(userRepository.findUserByName(user)!= null)
            throw new Exception("User with name " + user.getUserName() + " is already exist");
        //if logic is ok
        return userRepository.registerUser(user);


    }

    public void login(String userName, String password) throws Exception{
        userRepository.login(userName, password);
    }

    public void logout() throws Exception{
        userRepository.logout();
    }
}
