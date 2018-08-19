package lesson34.HW2;

import java.io.*;

public class Solution {


    public void transferFileContent(String fileFromPath, String fileToPath) throws Exception {
        try {
            validate(fileFromPath, fileToPath);
            writeToFile(fileToPath, readFromFile(fileFromPath), true);
            writeToFile(fileFromPath, new StringBuffer(), false);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void transferSentences(String fileFromPath, String fileToPath, String word) {

        StringBuffer stringBufferFromSourceFile = readFromFile(fileFromPath);
        StringBuffer writeBufferToFile = new StringBuffer();
        int startIndex = 0;
        int endIndex = 0;

        for (; ; ) {
            endIndex = stringBufferFromSourceFile.indexOf(".", startIndex);
            if (endIndex <= 0)
                break;
            String subString = stringBufferFromSourceFile.substring(startIndex, endIndex + 1);
            if (sentenceContainsWord(subString, word) && subString.length() > 10) {
                stringBufferFromSourceFile.delete(startIndex, endIndex + 1);
                writeBufferToFile.append(subString);
            } else {
                startIndex = endIndex + 1;
            }
        }

        writeToFile(fileToPath, writeBufferToFile, false);
        writeToFile(fileFromPath, stringBufferFromSourceFile, false);

//        System.out.println("те що переносимо " + writeBufferToFile.toString());
//        System.out.println("те що залишилось " + stringBufferFromSourceFile.toString());


    }

    private boolean sentenceContainsWord(String sentence, String word) {
        String[] array = sentence.split(" ");
        for (String str : array) {
            if (str.equals(word))
                return true;
        }
        return false;
    }

    private StringBuffer readFromFile(String path) {
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                // line += "\n";
                res.append("\n");
                res.append(line);

            }
            //res.replace(res.length() - 1, res.length(), "");
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + "failed");
        }
        return res;
    }

    private void writeToFile(String path, StringBuffer contentToWrite, boolean append) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, append))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.out.println("Can't write to file");
        }
    }

    private void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " does not exist");
        }
        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " does not exist");
        }

        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + " does not have permissions to read");
        }

        if (!fileFrom.canWrite()) {
            throw new Exception("File " + fileFrom + " file can not be changed");
        }

        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileTo + " does not have prmissions to write");
        }
    }
}



