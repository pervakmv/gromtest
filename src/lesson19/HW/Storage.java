package lesson19.HW;

import java.util.Arrays;

public class Storage {
    private long id;
    private File[] files;
    private String[] formatsSupported;
    private String storageCountry;
    private long storageSize;

    public Storage(long id, File[] files, String[] formatsSupported, String storageCountry, long storageSize) {
        this.id = id;
        this.files = files;
        this.formatsSupported = formatsSupported;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
    }

    public Storage() {
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", files=" + (files == null ? null : Arrays.asList(files)) +
                ", formatsSupported=" + (formatsSupported == null ? null : Arrays.asList(formatsSupported)) +
                ", storageCountry='" + storageCountry + '\'' +
                ", storageSize=" + storageSize +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }

    public String[] getFormatsSupported() {
        return formatsSupported;
    }

    public void setFormatsSupported(String[] formatsSupported) {
        this.formatsSupported = formatsSupported;
    }

    public String getStorageCountry() {
        return storageCountry;
    }

    public void setStorageCountry(String storageCountry) {
        this.storageCountry = storageCountry;
    }

    public long getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(long storageSize) {
        this.storageSize = storageSize;
    }

    public long storageSizeCur() {
        //визначаємо розмір усіх файлів в сховищі +
        long res = 0;
        for (File element : files) {
            if (element != null) {
                res += element.getSize();
            }
        }
        return res;
    }


    public boolean checkFormatFile(String format) {

        for (String element : formatsSupported) {
            if (element != null && element.equalsIgnoreCase(format))
                return true;
        }
        return false;
    }

    public void checkFile(File file) throws Exception {
        //перевіряємо формат +
        //перевіряємо розмір +
        //перевірка наявності файлу +
        if ((file != null) && !checkFormatFile(file.getFormat()))
            throw new Exception("format file is not supported " + "file id: " + file.getId() + " storage id: " + id);
        if (file != null && ((storageSizeCur() + file.getSize()) > storageSize))
            throw new Exception("size of file is to big " + "file id: " + file.getId() + " storage id: " + id);
        if ((file != null) && !verifyFileNonExistence(file))
            throw new Exception("file already exist " + "file id: " + file.getId() + " storage id: " + id);
        if ((file != null) && (findFileById(file.getId()) != null))
            throw new Exception("file with same ID is already exist " + "file id: " + file.getId() + " storage id: " + id);
    }

    public void checkFiles(File[] f) throws Exception {
        long size = 0;

        for (File element : f) {

            if (element != null) {
                if (!checkFormatFile(element.getFormat()))
                    throw new Exception("format files not supported files " + "file id: " + element.getId() + " storage id: " + id);
                if (!verifyFileNonExistence(element))
                    throw new Exception("file already exist. File" + " file id: " + element.getId() + " storage id: " + id);
                size += element.getSize();
            }
        }
        long storageSizeCur = 0;
        for (File file : files) {
            if (file != null)
                storageSizeCur += file.getSize();
        }
        if ((size + storageSizeCur) > storageSize)
            throw new Exception("siz of files is to big");
    }

    public int indexOfFile(File file) throws Exception {
        int index = 0;
        for (File element : files) {
            if (element != null && element.equals(file))
                return index;
            index++;
        }
        throw new Exception("file is not exist in this storage" + "file id: " + file.getId() + "storage id: " + id);
    }

    public boolean verifyFileNonExistence(File file) {

        for (File element : files) {
            if (element != null && element.equals(file))
                return false;

        }
        return true;
    }

//    public int indexOfFirstFreeCell() throws Exception {
//        int index = 0;
//        for (File element : files) {
//            if (element == null)
//                return index;
//            index++;
//        }
//    }

    public File findFileById(long id) {
        if (id < 0)
            return null;


        for (File element : files) {
            if (element != null && element.getId() == id)
                return element;
        }
        return null;
    }

    public void putFile(File file) throws ArrayIndexOutOfBoundsException {

        if (file != null) {
            int index = 0;
            while (files[index] != null) {
                index++;
            }
            files[index] = file;

        }
    }

}
