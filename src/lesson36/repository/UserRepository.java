package lesson36.repository;

import lesson36.model.User;
import lesson36.model.UserType;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class UserRepository {
    private final String pathToFile = "c:/temp/User.txt";
    private final int usersIdKoef = 1000;

    //считывание данных обработка данных - считывание файла
    //обработка данных - маппинг данных

    public User registerUser(User user) throws Exception {
        //save user to db (files)
        Set<User> users = userMapping();
        if (users.contains(user))
            throw new Exception("User already exist");

        //Генерирем ID
        long id = 0;
        do
            id =  Math.round((Math.random())* usersIdKoef);
        while (findUserById(id, users) != null);
        user.setId(id);

        users.add(user);

        userWrite(users);

        return user;
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


    private void userWrite(Set<User> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToFile, false))) {
            for (User element : list) {
                bufferedWriter.append(element.toFileFormat() + '\n');
            }

        } catch (IOException e) {
            System.out.println("Can't write to file by path: " + pathToFile);
        }
    }


    public Set<User> userMapping() throws Exception {
        Set<User> res = new TreeSet<>();
        StringBuffer stringBuffer = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            long lineNumber = 0;

            while ((line = br.readLine()) != null) {

                line = line.replaceAll("\t", ""); //Убираем табуляции


                String[] array = line.split(",");
                if (array.length != 5)
                    throw new Exception("Error in data file: " + pathToFile + " line number: " + lineNumber);


                User user = new User(Long.parseLong(array[0]), array[1], array[2], array[3], UserType.valueOf(array[4]));
                res.add(user);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + pathToFile + "does not exist");

        } catch (IOException e) {
            System.out.println("Readin form file " + pathToFile + "failed");
        } catch (IllegalArgumentException e) {
            System.out.println("User type is incorrect");
        }

        return res;
    }

}
