package lesson36.repository;

import lesson36.model.Entity;

import java.io.*;
import java.util.ArrayList;

public abstract class Repository<T extends Entity> {
    private String pathToFile;
    private int IdKoef;
    private int numberElementInLine;

    public Repository() {
    }

    public Repository(String pathToFile, int idKoef, int numberElementInLine) {
        this.pathToFile = pathToFile;
        IdKoef = idKoef;
        this.numberElementInLine = numberElementInLine;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public int getIdKoef() {
        return IdKoef;
    }

    public int getNumberElementInLine() {
        return numberElementInLine;
    }


    public T findEntityById(long id) throws Exception {
        for (T object : mapping()) {
            if (id == object.getId()) {
                return object;
            }
        }
        return null;
    }

    public T addToRepository(T t) throws Exception {

        long id = 0;

        do {
            id = Math.round((Math.random()) * IdKoef);
        } while (findEntityById(id) != null);
        t.setId(id);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToFile, true))) {
            bufferedWriter.append(t.toString() + '\n');
        } catch (IOException e) {
            System.out.println("addToRepository: Can't write to file by path: " + pathToFile);
        }
        return t;
    }

    public T deleteEntity(long entityId) throws Exception{
        ArrayList<T> entitysId = mapping();
        T t = findEntityById(entityId);
        if(t == null)
            throw new Exception("Entity id: " + entityId + " is not exist");
        entitysId.remove(t);
        writeToFile(entitysId);
        return t;
    }

    public void writeToFile(ArrayList<T> list){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToFile, false))){
            for(T element : list){
                bufferedWriter.append(element.toString() + '\n');
            }
        }catch(IOException e){
            System.out.println("writeToFile: Can't write to file by path: " + pathToFile);
        }
    }

    public ArrayList<T> mapping() throws Exception {
        validateFileRead();
        validateFormatFile();
        ArrayList<T> res = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            long lineNumber = 0;

            while ((line = br.readLine()) != null) {
                line = line.replaceAll("\t", "");//Убираем табуляцию
                res.add(lineToMap(line));
            }
        } catch (Exception e) {
            System.out.println("File " + pathToFile + " was not read");
        }
        return res;
    }


    public T lineToMap(String line) throws Exception {
        return null;
    }

    public void validateFileRead() throws Exception {


        File file = new File(pathToFile);
        if (!file.exists()) {
            throw new FileNotFoundException("File " + pathToFile + " does not exist");
        }
        if (!file.canRead()) {
            throw new Exception("File " + pathToFile + " does not have permissions to read");
        }
    }

    public void validateFormatFile() throws Exception {


        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            long lineNumber = 0;

            while ((line = br.readLine()) != null) {
                line = line.replaceAll("\t", "");
                String[] array = line.split(",");
                if (array.length != numberElementInLine) {
                    throw new Exception("Error in data file: " + pathToFile + " line number: " + lineNumber);
                }
                lineNumber++;
            }
        }
    }


}
