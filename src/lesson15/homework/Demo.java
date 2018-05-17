package lesson15.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~~~ створюємо репозиторій і заповнюємо його користувачами ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        UserRepository userRepository = new UserRepository(createUsers());
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        System.out.println("");
        System.out.println(" Добавляємо користувача ");
        User addedUser = new User(200, "Katya", "1212");
        System.out.println(userRepository.save(addedUser).toString());
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        System.out.println(" Добавляємо існуючого користувача ");
        User sameUser = new User(100, "Nikolay", "56");
        System.out.println(userRepository.save(sameUser));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        System.out.println(" Добавляємо null ");
        User nullUser = null;
        System.out.println(userRepository.save(nullUser));
        System.out.println(" ");

        System.out.println(" Виконуємо Update ");
        User updatedUser = userRepository.update(new User(101, "Dmitro", "205"));
        if(updatedUser!=null)
            System.out.println(updatedUser.toString());
        else
            System.out.println(updatedUser);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        System.out.println(" Виконуємо update неіснуючому користувачу");
        System.out.println(userRepository.update(new User(99, "Dmitro", "205")));
        System.out.println(" Виконуємо update null користувачу");
        System.out.println(userRepository.update(nullUser));
        System.out.println(" ");
        System.out.println("Тестуємо delete");
        userRepository.delete(107);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        System.out.println(" Тестуємо з неіснуючим id");
        userRepository.delete(157);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        System.out.println(" userFindById ");
        System.out.println(userRepository.userFindById(103).toString());
        System.out.println(" Неіснуючий ID ");
        System.out.println((userRepository.userFindById(160)));




    }

    public static User[] createUsers() {
        User[] users = new User[10];
        String[] names = {"Nikolay", "Dima", "Pasha", "Ivan", "Sergey", "Sasha", "Maxim", "Slava"};
        String[] sessionId = {"56", "204", "102", "342", "142", "298", "111", "705"};
        User userElement = new User(102, "FirstElement", "FirstSession");

        for (int i = 0; i < 10; i++) {
            if (i < names.length
                    && (i < sessionId.length)) {
                users[i] = new User(100 + i, names[i], sessionId[i]);

            } else {
                users[i] = null;
            }
        }
        return users;
    }
}
