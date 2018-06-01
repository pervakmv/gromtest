package lesson19.HW;

public class Demo {

    public static void main(String[] args) {
        //запускаємо функцію для створення репозиторію +
        //роблю вивів в консоль те що вийшло +
        //виводимо результати роботи методу put +

        String[] fileNameStorage1 = {"msconfig", "autoexec", "config", "main", "agregat", "menu"};
        String formatFileStorage1 = "dat";
        long idOffsetStorage1 = 100;
        String[] formatSupportedStorage1 = {"dat", "sys", "doc", "bat"};

        String[] fileNameStorage2 = {"kyiv", "paris", "london", "boston", "warsaw", "riga"};
        String formatFileStorage2 = "dat";
        long idOffsetStorage2 = 100;
        String[] formatSupportedStorage2 = {"dat", "exe", "doc", "bat"};
        //String[] formatSupportedStorage2 = {"mem", "exe", "doc", "bat"};


        Storage storage1 = CreateStorage(1, 100, fileNameStorage1, formatFileStorage1, formatSupportedStorage1);
        Storage storage2 = CreateStorage(2, 200, fileNameStorage2, formatFileStorage2, formatSupportedStorage2);
        Storage storage3 = new Storage();
        Controller controller = new Controller();
      //PUT
        System.out.println(" - PUT - ");


        try {
            controller.put(storage1, new File(110, "elas", "dat", 10));
            System.out.println("Result");
            System.out.println(storage1.toString());
        }catch (Exception e){
            System.out.print("Error : = ");
            System.out.println(e.getMessage());
        }






    }


    private static Storage CreateStorage(long storageId, int offsetId, String[] fileName, String formatFile, String[] formatSupported) {
        //створюю масив файлів +
        //створюю репозиторій +
        //виводимо репозиторій +


        int filesNumber = 8;
        File[] files = new File[filesNumber];


        long sizeOfFiles = 10;


        for (int fileId = 0; fileId < fileName.length; fileId++) {
            try {

                files[fileId] = new File((long) fileId + offsetId, fileName[fileId], formatFile, sizeOfFiles);

            } catch ( Exception e ) {
                System.err.println("індекc за межами масиву " + "index = " + fileId);
            }
        }

        Storage storage = new Storage(storageId, files, formatSupported, "Ukraine", 90);

        return storage;
    }

}
