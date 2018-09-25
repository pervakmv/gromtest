package lesson36.Utils;



import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Utils {

    private static Scanner in = new Scanner(System.in);

    public static long readKeyboardWithScannerLong(String prefStr) {
        Scanner scanner = new Scanner(System.in);

        //usinscanner
        System.out.println(prefStr);

        // String str = in.next();
        Long lng = in.nextLong();

        // scanner.close();
        //return Long.valueOf(str);
        return lng;
    }

    public static String readKeyboardWithScannerString(String prefStr) {
        //Scanner scanner = new Scanner(System.in);
        System.out.print(prefStr);
        String str = new String();

        str = in.next();

        return str;

    }

    public static void GetScores() {
        in.close();
    }


    public static String readFromKeyboardString(String prefStr) {


        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        String str = new String();
        try {
            System.out.print(prefStr);
            str = br.readLine();


        } catch (IOException e) {
            System.err.println("readFromKeyboardString: Reading from keyboard failed " + prefStr);
        } finally {
            //IOUtils.closeQuietly(reader);
            //IOUtils.closeQuietly(br);
            System.out.println("Без осовобождения ресурсов");
        }
        return str;
    }


    public static Date dateMapping(String inputString) throws Exception {
        String[] array = inputString.split("-");
        if (array.length != 3)
            throw new Exception("dateMapping: input data is faild");
        return new Date(Integer.parseInt(array[2])-1900, Integer.parseInt(array[1])-1, Integer.parseInt(array[0]));
    }





}
