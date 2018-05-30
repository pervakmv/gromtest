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
}
