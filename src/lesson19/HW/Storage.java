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


    public boolean supportedFormatValid(String format) {

        for (String element : formatsSupported) {
            if (element != null && element.equalsIgnoreCase(format))
                return true;
        }
        return false;
    }

    public boolean validFile(File file) {
        //перевіряємо формат +
        //перевіряємо розмір +
        //перевірка наявності файлу +
        if (file == null)
            return false;
        if (!supportedFormatValid(file.getFormat()))
            return false;
        if ((storageSizeCur() + file.getSize()) > storageSize)
            return false;

        return true;

    }

    public boolean validFiles(File[] f) {
        long size = 0;

        for (File element : f) {

            if (element != null) {
                if (!validFile(element))
                    return false;
                if(!fileNoAlreadyExistChecking(element))
                    return false;
                size += element.getSize();
            }
        }
        long storageSizeCur = 0;
        for (File file : files) {
            if (file != null)
                storageSizeCur += file.getSize();
        }
        if ((size + storageSizeCur) > storageSize)
            return false;


        return true;
    }

    public int indexOfFile(File file) throws Exception {
        int index = 0;
        for (File element : files) {
            if (element != null && element.equals(file))
                return index;
            index++;
        }
        throw new Exception("file is not exist in this storage");
    }

    public boolean fileNoAlreadyExistChecking(File file) {

        for (File element : files) {
            if (element != null && element.equals(file))
                return false;

        }
        return true;
    }

    public int indexOfFirstFreeCell() throws Exception {
        int index = 0;
        for (File element : files) {
            if (element == null)
                return index;
            index++;
        }
        throw new Exception("no free cells");

    }

    public File findFileById(long id) {
        if (id < 0)
            return null;


        for (File element : files) {
            if (element != null && element.getId() == id)
                return element;
        }
        return null;
    }

}
