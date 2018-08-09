package lesson33.HW;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {



    public String textFromConsole() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String resString = new String();
        String inputLine = new String();

        try {
            for (; ; ) {
                inputLine = br.readLine();

                if (inputLine.equals("wr"))
                    break;

                resString =  resString  + inputLine + "\n";
            }
        } catch (IOException e) {
            System.err.println("Readin from keyboard failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }

        return resString;
    }


    public static void writeFile(String path, String content)  {

        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        FileReader reader;
        boolean fileDoesNotExist = false;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            fileDoesNotExist = true;
            System.err.println("File does not exist");
        }


        if (fileDoesNotExist == false) {

            try {
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

    public void writeToFileFromConsole(String path){
        writeFile(path, textFromConsole());
    }

}
