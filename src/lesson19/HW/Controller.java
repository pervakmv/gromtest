package lesson19.HW;

public class Controller {

    public void put(Storage storage, File file) throws Exception {


        //зчитуємо масив файлів з репозиторію +
        //перевіряємо файл +
        //записуємо файл +
        File files[] = storage.getFiles();
        storage.checkFile(file);
        storage.putFile(file);


    }//put


    public void delete(Storage storage, File file) throws Exception {
        //виявляємо чи є такий елемент в сховищі+
        //визначаємо індекс +
        if (storage == null
                || file == null) {
            System.out.println("delete: storage or file is null");

        } else {

            File[] files = storage.getFiles();

            storage.verifyFileNonExistence(file);

//            try {
            files[storage.indexOfFile(file)] = null;
            //          } catch (Exception e) {
            //             System.out.println(e.getMessage());
            //         }

        }
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        boolean flagAllOk = true;


        //переносимо файли за допомогою функцій delete and put+
        if (storageFrom == null
                || storageTo == null
                || storageFrom.getFiles() == null
                || storageTo.getFiles() == null) {
            System.out.println("transferAll: null object");
        } else {

            File[] storageFromFiles = storageFrom.getFiles();

            storageTo.checkFiles(storageFromFiles);

            //перевірка наявних вільних місць в масиві сховища

            if (numberNotNullElementFileArray(storageFromFiles) > numberNullElementFileArray(storageTo.getFiles())) {
                throw new Exception(" no free celses at the storage id: " + storageTo.getId());
            }

            for (File transferFile : storageFromFiles) {
                if (transferFile == null)
                    continue;
                storageTo.putFile(transferFile);
                delete(storageFrom, transferFile);
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

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        if (storageFrom == null ||
                storageTo == null) {
            System.out.println("transferFile: null object");
        } else {
            File file = storageFrom.findFileById(id);
            if (file != null) {
                storageTo.checkFile(file);
                storageTo.putFile(file);
                delete(storageFrom, file);


            }

        }
    }

}


