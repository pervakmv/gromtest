package lesson33;

import org.apache.commons.io.IOUtils;

import javax.sound.midi.Soundbank;
import java.io.*;

public class ReadWriteFile {
    public static void main(String[] args) throws InterruptedException {
        readFile("C:/Temp/test.txt");

        writeFile("C:/Temp/test.txt", "Java Core");

    }

    public static void readFile(String path) {

        FileReader reader;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
            return;
        }

        BufferedReader br = new BufferedReader(reader);

        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Reading from file  " + path + "failed");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }

    }


    public static void writeFile(String path, String content)  throws InterruptedException {

        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            //TODO use other constructor

            //Thread.sleep(5000);
            writer = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.append("\n");
            bufferedWriter.append(content);
        } catch (IOException e) {
            System.err.println("Can't write to file");
            return;
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }


    }

}
