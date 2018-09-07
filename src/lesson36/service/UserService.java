package lesson36.service;

import lesson36.model.User;
import lesson36.repository.UserRepository;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public User registerUser(User user) throws Exception {
        //check business logic (не должны быть пустые поля, Юзеру должно быть больше 18 лет

        if(!user.canBeRegistred())
            throw new Exception("The entered data can't be written");
        //if logic is ok
        return userRepository.registerUser(user);


    }
}
