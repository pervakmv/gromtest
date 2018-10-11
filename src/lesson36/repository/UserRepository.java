package lesson36.repository;


import lesson36.Utils.Common;
import lesson36.Utils.Utils;
import lesson36.Utils.ValidateType;
import lesson36.model.User;
import lesson36.model.UserType;


import java.io.*;
import java.util.*;

public class UserRepository {

    public static User logenedUser = new User();

    private final String pathToFile = "c:/temp/User.txt";
    private final int usersIdKoef = 1000;
    private final int numberElementInLine = 5;

    //считывание данных обработка данных - считывание файла
    //обработка данных - маппинг данных


    public User getLogenedUser() {
        return logenedUser;
    }


    public static boolean logonWasSuccesful() {
        if (logenedUser.getUserName() != null)
            return true;
        return false;
    }

    public static boolean logenedUserHasAdminPermit() {
        if (logenedUser == null) return false;
        if (logenedUser.getUserType() == UserType.ADMIN)
            return true;
        return false;
    }


    public User registerUser(User user) throws Exception {
        //save user to db (files)
        //Set<User> users = userMapping();
        //Генерирем ID
        long id = 0;
        do {
            id = Math.round(Math.random() * usersIdKoef);
        }
        while (findUserById(id) != null || id == 0);
        user.setId(id);
        Common.addObjectToFile(user, pathToFile);
        return user;
    }


    public User findUserByName(User user) throws Exception {
        if (user == null) return null;
        Set<User> users = userMapping();
        for (User object : users) {
            if (object.getUserName().equals(user.getUserName())) {
                return user;
            }
        }
        return null;
    }

    public User findUserById(long id, Collection<User> users) {
        if (users == null)
            return null;

        for (User user : users) {
            if (id == user.getId()) {
                return user;
            }
        }
        return null;
    }

    public User findUserById(long id) throws Exception {

        return findUserById(id, userMapping());
    }


    public void setLogenedUser(User logenedUser) {
        this.logenedUser = logenedUser;
    }

    private void userWrite(Set<User> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToFile, false))) {
            for (User element : list) {
                bufferedWriter.append(element.toString() + '\n');
            }

        } catch (IOException e) {
            System.out.println("Can't write to file by path: " + pathToFile);
        }
    }

    public void validateFile() throws Exception {
        Utils.validateFile(pathToFile, ValidateType.Read);
    }

    public void validateFormatFile() throws Exception {
        Utils.validateFormatFile(pathToFile, numberElementInLine);
    }

    public User lineToUser(String line) {
        line = line.replaceAll("\t", "");

        String[] array = line.split(",");
        return new User(Long.parseLong(array[0]), array[1], array[2], array[3], UserType.valueOf(array[4]));
    }


    public Set<User> userMapping() throws Exception {
        Set<User> res = new TreeSet<>();
        StringBuffer stringBuffer = new StringBuffer();

        validateFile();
        validateFormatFile();
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("\t", ""); //Убираем табуляции
                res.add(lineToUser(line));
            }
        } catch (Exception e) {
            System.out.println("File " + pathToFile + "was not read");

        }
        return res;
    }

    public void login(String userName, String password) throws Exception {
        Set<User> users = userMapping();

        for (User element : users) {

            if (element.getUserName().equals(userName) &&
                    element.getPassword().equals(password)) {
                logenedUser = element;
                break;
            }
        }
        if (logenedUser.getUserName() != null) {
            System.out.println("Login user " + logenedUser.getUserName() + " are succses");
        } else {
            throw new Exception("Login: User is not exist");
        }
    }

    public void logout() throws Exception {
        logenedUser = null;
    }


}
