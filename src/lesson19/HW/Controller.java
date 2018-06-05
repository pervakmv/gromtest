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

            storage.verifyFileToExistence(file);

            files[storage.indexOfFile(file)] = null;
        }
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {

        File[] storageFromFiles = storageFrom.getFiles();

        storageTo.checkFiles(storageFromFiles);

        //перевірка наявних вільних місць в масиві сховища

        if (storageFrom.numberNotNullElementFileArray() > storageTo.numberNullElementFileArray()){
            throw new Exception(" no free celses at the storage id: " + storageTo.getId());
        }

        for (File transferFile : storageFromFiles) {
            if (transferFile == null)
                continue;
            storageTo.putFile(transferFile);
            delete(storageFrom, transferFile);
        }


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


