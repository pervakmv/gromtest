package lesson34;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile {
    public static void main(String[] args) throws InterruptedException {
        readFile("C:/Temp/test.txt");

        writeFile("C:/Temp/test.txt", "Java Core");

    }

    public static void readFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e){
            System.err.println("Reading from file " + path + "failed");
        }

    }


    public static void writeFile(String path, String content) throws InterruptedException {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append("\n");
            bufferedWriter.append(content);
        } catch (IOException e) {
            System.out.println("Can't write to file");
        }
    }

}


