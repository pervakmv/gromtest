package lesson20.task2;

public class Utils {

    private int limitTransactionsPerDayCount = 8;
    private int limitTransactionsPerDayAmount = 100;
    private int limitSimpleTransactionAmount = 40;
    private String[] cities = {"Kiev", "Odessa"};


    public int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public int getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public int getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionAmount;
    }

    public String[] getCities() {
        return cities;
    }

    public boolean availableCity(String city){
        for(String element : cities){
            if(element==city)
                return true;
        }
        return false;
    }

}
