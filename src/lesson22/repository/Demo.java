package lesson22.repository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

     UserRepository userRepository = new UserRepository();

     User user1 = new User(1001, "Daniil", "32434234sdsfveo");
     User user2 = new User(1002, "Andrey", "32445234sdsfveo");

     User user3 = new User(1001, "Test", "32445234sdsfveo");


     System.out.println(userRepository.save(user1).toString());
     System.out.println(userRepository.save(user2).toString());

     System.out.println(Arrays.deepToString(userRepository.getUsers()));

     userRepository.update(user3);
     System.out.println(Arrays.deepToString(userRepository.getUsers()));


     userRepository = new UserRepository();
     //Після того як масив зробии статичним
     System.out.println(Arrays.deepToString(userRepository.getUsers()));

    }
}

