package lesson19.HW;

public class Demo {

    public static void main(String[] args) {
        //запускаємо функцію для створення репозиторію +
        //роблю вивів в консоль те що вийшло +
        //виводимо результати роботи методу put +

        String[] fileNameStorage1 = {"msconfig", "autoexec", "config", "main", "agregat", "menu"};
        String formatFileStorage1 = "dat";
        long idOffsetStorage1 = 100;
        String[] formatSupportedStorage1 = {"dat", "exe", "doc", "bat"};

        String[] fileNameStorage2 = {"kyiv", "paris", "london", "boston", "warsaw", "riga"};
        String formatFileStorage2 = "dat";
        long idOffsetStorage2 = 100;
        String[] formatSupportedStorage2 = {"dat", "exe", "doc", "bat"};
        //String[] formatSupportedStorage2 = {"mem", "exe", "doc", "bat"};


        Storage storage1 = CreateStorage(1, 100, fileNameStorage1, formatFileStorage1, formatSupportedStorage1);
        Storage storage2 = CreateStorage(2, 200, fileNameStorage2, formatFileStorage2, formatSupportedStorage2);
        Storage storage3 = new Storage();
        System.out.println(storage1.toString() + "storageSizeCur " + storage1.storageSizeCur());
        System.out.println(storage2.toString() + "storageSizeCur " + storage2.storageSizeCur());
        System.out.println(" Пробуємо put ");
        Controller controler = new Controller();
        try {
            controler.put(storage1, new File(106, "systemsystemsystem", "dat", 25));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            controler.put(storage1, new File(107, "system", "dat", 23));
        } catch (Exception e) {
            System.out.println("storage 1 " + e.getMessage());
        }

        try {
            controler.put(storage2, new File(107, "system", "dat", 28));
        } catch (Exception e) {
            System.out.println("storage 2" + e.getMessage());
        }
        try {
            controler.put(null, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(storage1.toString());
        System.out.println(storage2.toString());

        //Пробуємо метод delete
        System.out.println(" -------- метод delete -------- ");

        try {
            controler.delete(storage1, new File(111, "autoexec", "dat", 25));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            controler.delete(storage2, new File(201, "paris", "dat", 22));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            controler.delete(null, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(storage1.toString());
        System.out.println(storage2.toString());

        //Пробуємо метод transferAll
        System.out.println(" -------- метод transferAll -------- ");
        //Збільшуємо розмір сховища 2
        storage2.setStorageSize(110);

        try {
            controler.transferAll(storage1, storage2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(storage1.toString());
        System.out.println(storage2.toString());



        try {
            controler.transferAll(storage1, storage2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(storage1.toString());
        System.out.println(storage2.toString());

        //Пробуємо метод transfer
        System.out.println(" -------- метод transferFile -------- ");
        controler.transferFile(storage2, storage1, 202);

        System.out.println(storage1.toString());
        System.out.println(storage2.toString());

    }


    private static Storage CreateStorage(long storageId, int offsetId, String[] fileName, String formatFile, String[] formatSupported) {
        //створюю масив файлів +
        //створюю репозиторій +
        //виводимо репозиторій +

        int filesNumber = 30;
        File[] files = new File[filesNumber];


        long sizeOfFiles = 10;


        for (int fileId = 0; fileId < fileName.length; fileId++) {
            try {

                files[fileId] = new File((long) fileId + offsetId, fileName[fileId], formatFile, sizeOfFiles);

            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("індекc за межами масиву " + "index = " + fileId);
            }
        }

        Storage storage = new Storage(storageId, files, formatSupported, "Ukraine", 90);

        return storage;
    }

}
