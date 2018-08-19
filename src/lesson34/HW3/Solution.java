package lesson34.HW3;

import javafx.scene.shape.Path;
import org.apache.commons.io.CopyUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Solution {

    public void copyFileContent(String fileFromPath, String fileToPath){

        try {
            Files.copy(Paths.get(fileFromPath), new FileOutputStream(fileToPath));
        }catch(FileNotFoundException e){
            System.err.println("File does not exist");
        }catch(IOException e){
            System.err.println("IO Exception " + fileFromPath + ";" + fileToPath + "failed");

        }


    }

    public void copyFileContentApacheIO(String fileFromPath, String fileToPath){

        try {
            CopyUtils.copy(new FileInputStream(fileFromPath), new FileOutputStream(fileToPath));
        }catch(IOException e){
            System.out.println("IO Exception " + fileFromPath + ";" + fileToPath + "faild");
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
