package lesson19.HW;

public class Controller {

    public void put(Storage storage, File file) throws Exception {

        //зчитуємо масив файлів з репозиторію +
        //перевіряємо файл +
        //записуємо файл +

        File files[] = storage.getFiles();
        try {
            storage.checkFile(file);
            storage.putFile(file);
        } catch (Exception e) {
            System.out.println("put" + e.getMessage());
        }


    }//put


    public void delete(Storage storage, File file) throws Exception {
        //виявляємо чи є такий елемент в сховищі+
        //визначаємо індекс +
        if (storage == null
                || file == null) {
            System.out.println("delete: storage or file is null");

        } else {

            File[] files = storage.getFiles();

            if (storage.verifyFileNonExistence(file)) {
                throw new Exception("delete: no file exist " + "file id: " + file.getId() + " storage id: " + storage.getId());
            }
            try {
                files[storage.indexOfFile(file)] = null;
            } catch (Exception e) {
                System.out.println(e.getMessage());
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

            try {
                storageTo.checkFiles(storageFromFiles);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            //перевірка наявних вільних місць в масиві сховища

            if (numberNotNullElementFileArray(storageFromFiles) > numberNullElementFileArray(storageTo.getFiles())) {
                throw new Exception(" no free celses at the storage id: " + storageTo.getId());
            }


            for (File transferFile : storageFromFiles) {
                if (transferFile == null)
                    continue;
                try {
                    storageTo.putFile(transferFile);
                    delete(storageFrom, transferFile);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private int numberNullElementFileArray(File[] files) {
        int res = 0;
        for (File element : files) {
            if (element == null)
                res++;
        }
        return res;
    }

    private int numberNotNullElementFileArray(File[] files) {
        int res = 0;
        for (File element : files) {
            if (element != null)
                res++;

        }
        return res;
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) {
        if (storageFrom == null ||
                storageTo == null) {
            System.out.println("transferFile: null object");
        } else {
            File file = storageFrom.findFileById(id);
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


}


