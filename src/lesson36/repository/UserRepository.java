package lesson36.repository;



import lesson36.model.User;
import lesson36.model.UserType;

import java.util.*;

public class UserRepository extends Repository<User> {

    public static User logenedUser = new User();


    //считывание данных обработка данных - считывание файла
    //обработка данных - маппинг данных


  //  public UserRepository() {
   // }

    public UserRepository(String pathToFile, int idKoef, int numberElementInLine) {
        super(pathToFile, idKoef, numberElementInLine);
    }

    public static User getLogenedUser() {
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

        return addToRepository(user);
    }


    public User findUserByName(User user) throws Exception {
        if (user == null) return null;
        ArrayList<User> users = userMapping();
        for (User object : users) {
            if (object!=null && object.getUserName().equals(user.getUserName())) {
                return user;
            }
        }
        return null;
    }



    public User findUserById(long id) throws Exception {

        return findEntityById(id);
    }


    public void setLogenedUser(User logenedUser) {
        this.logenedUser = logenedUser;
    }



    public void validateFile() throws Exception {
        validateFileRead();
    }



    public User lineToMap(String line) {
        line = line.replaceAll("\t", "");

        String[] array = line.split(",");
        return new User(Long.parseLong(array[0]), array[1], array[2], array[3], UserType.valueOf(array[4]));
    }


    public ArrayList<User> userMapping() throws Exception {

        return mapping();
    }

    public void login(String userName, String password) throws Exception {
        ArrayList<User> users = userMapping();

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
