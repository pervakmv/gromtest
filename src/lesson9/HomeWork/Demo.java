package lesson9.HomeWork;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {


        User[] users = new User[10];

        //       User[] users = null;

       users[0] = new User(100, "Nikolay", "InProcess");
        users[1] = new User(111, "Sviatoslav", "InControl");//
       users[2] = new User(130, "Kucherenko", "Learn");
        users[3] = new User(120, "Saygo", "InProcess");
        users[4] = new User(143, "Oleksiy", "Teacher");
        users[5] = new User(435, "Katia", "Fine");

        UserRepository userRepository = new UserRepository(users);

        if (users != null) System.out.println(users[1].getName());

        System.out.println(Arrays.toString(userRepository.getUserIds()));
        System.out.println(Arrays.toString(userRepository.getUserNames()));

        System.out.println(userRepository.getUserNameById(120));

        System.out.println(userRepository.getUserNameById(435));

      //  Обкатка функцій з третього завдання
        System.out.println("---- Відпрацьовуємо методи з третього уроку -------");
        userRepository.getUserByName("Katia").printDataOfUser();
        userRepository.getUserByName("Kucherenko").printDataOfUser();

        userRepository.getUserById(100).printDataOfUser();
        userRepository.getUserBySessionId("Fine").printDataOfUser();
        //Четверте завдання
        System.out.println("---- Відпрацьовуємо методи з четвертого уроку -------");
        User newUser = new User(554, "Yulia", "Girl");
          userRepository.save(newUser);
        System.out.println(Arrays.toString(userRepository.getUserIds()));
        System.out.println(Arrays.toString(userRepository.getUserNames()));
        System.out.println("---- Відпрацьовуємо метод update -------");
        User newOleksiy  = new User(143, "Aleksey", "Buer");
        userRepository.update(newOleksiy);
        System.out.println(Arrays.toString(userRepository.getUserIds()));
        System.out.println(Arrays.toString(userRepository.getUserNames()));
        System.out.println("---- Видалення елементу -------");
        userRepository.delete(554);
        System.out.println(Arrays.toString(userRepository.getUserIds()));
        System.out.println(Arrays.toString(userRepository.getUserNames()));


    }
}

