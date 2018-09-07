package lesson33.HW;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {

    public static String textFromConsole() {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String resString = new String();
        String inputLine = new String();

        try {
            for (; ; ) {
                inputLine = br.readLine();

                if (inputLine.equals("wr"))
                    break;

                resString = resString + inputLine + "\n";
            }
        } catch (IOException e) {
            System.err.println("Readin from keyboard failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);

        }

        return resString;
    }

    public static void writeToFileFromConsole(String path) throws FileNotFoundException{

        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        File file = new File(path);

        if (!file.exists()) {
            throw new FileNotFoundException("File does not exist");
        }


        try {
            writer = new FileWriter(path, true);

            bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.append("\n");
            bufferedWriter.append(textFromConsole());
        } catch (IOException e) {
            System.err.println("Can't write to file");
            return;
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);

        }
    }

}
