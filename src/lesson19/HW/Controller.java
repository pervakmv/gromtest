package lesson19.HW;

public class Controller {

    public void put(Storage storage, File file) throws Exception {

        //зчитуємо масив файлів з репозиторію +
        //перевіряємо чи в репозиторії немає уже такого файлу +
        //перевіряємо чи вистачить місця в сховищі +
        //шукаю вільне місце в масиві щоб записати туди наш фал +

        if (storage != null && file != null) {
            File files[] = storage.getFiles();
            //Перевіряємо чи відповідає файл критеріям репозиторію +
            if (!CheckFile(storage, file)) {
                throw new Exception("put: file is not valid");
            }
            if ((storage.storageSizeCur() + file.getSize()) > storage.getStorageSize()) {
                throw new Exception("put: not enough memory");
            }


            if (!findFile(storage, file)) {
                int index = 0;
                boolean putSuccses = false;
                for (File element : files) {

                    if (element == null) {
                        files[index] = file;
                        putSuccses = true;
                        break;
                    }
                    index++;

                }
                if (putSuccses == false)
                    throw new Exception("put: no free place");
            } else {
                throw new Exception("put: file allready exist");
                //System.out.println("file allready exist");
            }
        } else
            System.out.println("null object");
    }

    private File findFileById(Storage storage, long id) {
        if (storage == null &&
                id < 0)
            return null;

        File files[] = storage.getFiles();

        for (File element : files) {
            if (element != null && element.getId() == id)
                return element;
        }
        return null;
    }


    public void delete(Storage storage, File file) throws Exception {
        //виявляємо чи є такий елемент в сховищі+
        //визначаємо індекс +
        if (storage == null
                || file == null) {
            System.out.println("storage or file is null");

        } else {

            int index = indexOfFile(storage, file);

            File[] files = storage.getFiles();

            if (index > -1) {

                files[index] = null;
            } else {

                throw new Exception("no file here");
            }
        }
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        //Первірка об'єктів на null
        //Перевіряємо формат +
        //Перевіряємо чи вмістяться нові файли в цільове сховище+
        //переносимо файли за допомогою функцій delete and put+
        if (storageFrom == null
                || storageTo == null
                || storageFrom.getFiles() == null) {
            System.out.println("null object");
        } else {
            String[] destStorageSupportedFormats = storageTo.getFormatsSupported();
            String[] sourcStorageSupportedFormats = storageFrom.getFormatsSupported();
            boolean flagFormatsOk = true;
            for (String element : sourcStorageSupportedFormats) {
                if (element != null) {
                    if (!supportedFormatValid(destStorageSupportedFormats, element)) {
                        flagFormatsOk = false;
                        throw new Exception("new storage doesn't support this formats");

                    }
                }
            }

            if ((storageTo.storageSizeCur() + storageFrom.storageSizeCur()) > storageTo.getStorageSize())
                throw new Exception("size of files is to big");

            File[] storageFromFiles = storageFrom.getFiles();

            for (File transferFile : storageFromFiles) {
                if (transferFile == null)
                    continue;
                try {
                    put(storageTo, transferFile);
                    delete(storageFrom, transferFile);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) {
        if (storageFrom == null ||
                storageTo == null) {
            System.out.println("transferFile: null object");
        } else {
            File file = findFileById(storageFrom, id);
            if(file!=null){
                try{
                    put(storageTo, file);
                    delete(storageFrom, file);
                }catch(Exception e){
                    System.out.println("put:"+e.getMessage());
                }
            }

        }
    }


    private int indexOfFile(Storage storage, File file) {

        if (storage == null)
            return -1;
        if (file == null)
            return -1;
        //зчитуємо масив файлів +
        File[] files = storage.getFiles();
        int index = 0;
        for (File element : files) {

            if (element != null && element.equals(file)) {
                return index;
            }
            index++;
        }
        return -1;
    }


    private boolean findFile(Storage storage, File file) {
        if (storage == null)
            return false;
        File files[] = storage.getFiles();
        for (File element : files) {
            if (element != null && file.equals(element))
                return true;
        }
        return false;
    }


    private boolean CheckFile(Storage storage, File file) throws Exception {
        //перевіряємо чи файл відповідає усім критеріям
        //Довжина імені не може бути більша за 10 +
        //Перевіряємо чи допустимий формат файлу +
        int maxNameLonFiles = 10;
        String filesName = file.getName();
        if (filesName.length() > 10) {
            throw new Exception("file's name is to long");
        }

        if (supportedFormatValid(storage.getFormatsSupported(), file.getFormat())) {
            return true;
        } else {
            throw new Exception("files format is  not valid");
        }
    }

    private boolean supportedFormatValid(String[] supportedFormats, String format) {
        if (supportedFormats == null)
            return false;

        for (String element : supportedFormats) {
            if (element != null && element.equalsIgnoreCase(format))
                return true;
        }
        return false;
    }

}


