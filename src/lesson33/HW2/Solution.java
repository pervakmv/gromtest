package lesson33.HW2;

import org.apache.commons.io.IOUtils;

import javax.sound.midi.Soundbank;
import java.io.*;

public class Solution {


    public String enterPathByConsole() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please, enter file path to read");
        String path = new String();
        try {
            path = br.readLine();
        } catch (IOException e) {
            System.out.println("Read file path abrot");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }
        return path;
    }


    public void readFile(String path) {

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
            System.out.println("Can't read file by path:  " + path);
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }

    }

    public void readFileByConsolePath() {
        readFile(enterPathByConsole());
    }

}
