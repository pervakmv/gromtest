package lesson27.HW2;

import java.util.Arrays;
import java.util.LinkedList;

public class Demo {
    public static void main(String[] args) {


        LinkedList<User> linkedListUsers = new LinkedList<>();

             User[] users = new User[10];

        linkedListUsers.add(new User(100, "Nikolay", "InProcess"));
        linkedListUsers.add(new User(111, "Sviatoslav", "InControl"));//
        linkedListUsers.add(new User(130, "Kucherenko", "Learn"));
        linkedListUsers.add(new User(120, "Saygo", "InProcess"));
        linkedListUsers.add(new User(143, "Oleksiy", "Teacher"));
        linkedListUsers.add(new User(435, "Katia", "Fine"));

        UserRepository userRepository = new UserRepository(linkedListUsers);


        System.out.println(Arrays.toString(userRepository.getUserNames()));
        System.out.println(Arrays.toString(userRepository.getUserIds()));
        System.out.println(Arrays.toString(userRepository.getUserNames()));

        System.out.println(userRepository.getUserNameById(120));

        System.out.println(userRepository.getUserNameById(436));

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

