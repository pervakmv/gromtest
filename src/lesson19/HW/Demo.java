package lesson19.HW;

public class Demo {

    public static void main(String[] args) {
        //запускаємо функцію для створення репозиторію +
        //роблю вивів в консоль те що вийшло +
        //виводимо результати роботи методу put +

        String[] fileNameStorage1 = {"msconfig", "autoexec", "config" };
        String formatFileStorage1 = "dat";
        long idOffsetStorage1 = 100;
        String[] formatSupportedStorage1 = {"dat", "sys", "doc", "bat"};

        String[] fileNameStorage2 = {"kyiv", "paris" };
        String formatFileStorage2 = "dat";
        long idOffsetStorage2 = 100;
        String[] formatSupportedStorage2 = {"dat", "exe", "doc", "bat"};
        //String[] formatSupportedStorage2 = {"mem", "exe", "doc", "bat"};

        String[] fileNameStorage3 = {null, null, null, null };
        String formatFileStorage3 = "dat";
        long idOffsetStorage3 = 100;
        String[] formatSupportedStorage3 = {"dat", "exe", "doc", "bat"};
        //String[] formatSupportedStorage2 = {"mem", "exe", "doc", "bat"};


        Storage storage1 = CreateStorage(1, 100, fileNameStorage1, formatFileStorage1, formatSupportedStorage1);
        Storage storage2 = CreateStorage(2, 200, fileNameStorage2, formatFileStorage2, formatSupportedStorage2);
        Storage storage3 = CreateStorage( 3, 300,fileNameStorage3,formatFileStorage3, formatSupportedStorage3);
        Controller controller = new Controller();
      //PUT
        System.out.println(" - PUT - ");
        System.out.println(storage1.toString());
        System.out.println(storage2.toString());
        System.out.println(storage3.toString());

        try{
            controller.put(storage1, new File(110, "elas", "dat", 10));
            System.out.println("Result");
            System.out.println(storage1.toString());
        }catch (Exception e){
            System.out.print("Error : = ");
            System.out.println(e.getMessage());
        }

        try {
            controller.put(storage2, new File(299, "elSas", "dat", 10));
            controller.put(storage2, new File(300, "vailand", "doc", 10));
            controller.put(storage2, new File(301, "visman", "doc", 10));
//            controller.put(storage2, new File(302, "gogog", "doc", 10));
            System.out.println("Result");
            System.out.println(storage2.toString());
        }catch (Exception e){
            System.out.print("Error : = ");
            System.out.println(e.getMessage());
        }

        System.out.println(storage1.toString());
        System.out.println(storage2.toString());
        System.out.println(storage3.toString());

        //Transfer All
        System.out.println(" - Transfer all - ");
        System.out.println(storage1.toString());
        System.out.println(storage2.toString());
        System.out.println(storage3.toString());

        try{
            controller.transferAll(storage1, storage3);
            System.out.println("Result");
            System.out.println(storage1.toString());
            System.out.println(storage2.toString());
            System.out.println(storage3.toString());
        }catch(Exception e){
            System.out.println("Transfer all : " + e.getMessage());
        }

        System.out.println(" delete metod ");

        try{
            //controller.delete(storage1, new File(100, "msconfig", "dat", 16));
            controller.delete(storage1, null);
            System.out.println(storage1.toString());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        try{
            controller.transferAll(storage1, storage3);
            System.out.println(storage1.toString());
            System.out.println(storage3.toString());
        }catch(Exception e){
            System.out.println("transfer all " + e.getMessage());
        }


        try{
            controller.transferFile(storage3, storage1, 100);
            System.out.println(storage1.toString());
            System.out.println(storage3.toString());
        }catch(Exception e){
            System.out.println("transfer " + e.getMessage());
        }

    }


    private static Storage CreateStorage(long storageId, int offsetId, String[] fileName, String formatFile, String[] formatSupported) {
        //створюю масив файлів +
        //створюю репозиторій +
        //виводимо репозиторій +


        int filesNumber = 4;
        File[] files = new File[filesNumber];


        long sizeOfFiles = 16;


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
