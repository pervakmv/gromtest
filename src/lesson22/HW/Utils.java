package lesson22.HW;

public class Utils {

    private static int limitTransactionsPerDayCount = 8;
    private static int limitTransactionsPerDayAmount = 100;
    private static int limitSimpleTransactionAmount = 40;
    private static String[] cities = {"Kiev", "Odessa"};


    public static int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public static int getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public static int getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionAmount;
    }

    public static String[] getCities() {
        return cities;
    }

    public static boolean availableCity(String city){
        for(String element : cities){
            if(element==city)
                return true;
        }
        return false;
    }

}
