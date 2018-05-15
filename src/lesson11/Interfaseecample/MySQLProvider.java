package lesson11.Interfaseecample;

public class MySQLProvider implements DbProvider {
    @Override
    public void connectToDb() {
        //some logic for SQL
    }

    @Override
    public void disconnectFromDb() {
        //some logic for SQL
    }

    @Override
    public void encryptData() {

    }
}