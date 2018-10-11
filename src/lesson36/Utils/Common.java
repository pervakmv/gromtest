package lesson36.Utils;

import lesson36.model.Entity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Common {

    public static <T extends Entity> void addObjectToFile(T object, String pathToFile) throws Exception {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToFile, true))) {
            bufferedWriter.append(object.toString() + '\n');
        } catch (IOException e) {
            System.out.println("addObjectToFile + Can't write to file by path: " + pathToFile);
        }
    }
}
