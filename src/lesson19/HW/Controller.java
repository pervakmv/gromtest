package lesson19.HW;

public class Controller {

    public void put(Storage storage, File file) throws Exception {

        //зчитуємо масив файлів з репозиторію +
        //перевіряємо чи в репозиторії немає уже такого файлу +
        //перевіряємо чи вистачить місця в сховищі +
        //шукаю вільне місце в масиві щоб записати туди наш фал +

        if (storage == null && file == null) {
            System.out.println("null object" + "file id: " + file.getId() + " storage id: " + storage.getId());
        } else {


            File files[] = storage.getFiles();
            //Перевіряємо чи відповідає файл критеріям репозиторію +
            if (!CheckFile(storage, file)) {
                throw new Exception("put: file is not valid " + "file id: " + file.getId() + " storage id: " + storage.getId());
            }
            if ((storage.storageSizeCur() + file.getSize()) > storage.getStorageSize()) {
                throw new Exception("put: not enught memory " + "file id: " + file.getId() + " storage id: " + storage.getId());
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
                    throw new Exception("put: no free place " + "file id: " + file.getId() + " storage id: " + storage.getId());

            } else {

                throw new Exception("put: file allready exist " + "file id: " + file.getId() + " storage id: " + storage.getId());
            }
        }

    }//put

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
            System.out.println("delete: storage or file is null");

        } else {

            int index = indexOfFile(storage, file);

            File[] files = storage.getFiles();

            if (index > -1) {

                files[index] = null;
            } else {

                throw new Exception("delete: no file here");
            }
        }
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        //Первірка об'єктів на null


        //переносимо файли за допомогою функцій delete and put+
        if (storageFrom == null
                || storageTo == null
                || storageFrom.getFiles() == null) {
            System.out.println("transferAll: null object");
        } else {

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
            if (file != null) {
                try {
                    put(storageTo, file);
                    delete(storageFrom, file);
                } catch (Exception e) {
                    System.out.println("transferFile:" + e.getMessage());
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

        if (storage.supportedFormatValid(file.getFormat())) {
            return true;
        } else {
            throw new Exception("check file: files format is  not valid");
        }
    }

//    private boolean supportedFormatValid(String[] supportedFormats, String format) {
//        if (supportedFormats == null)
//            return false;
//
//        for (String element : supportedFormats) {
//            if (element != null && element.equalsIgnoreCase(format))
//                return true;
//        }
//        return false;
//    }

}


