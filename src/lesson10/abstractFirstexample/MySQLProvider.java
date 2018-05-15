package lesson10.abstractFirstexample;

public class MySQLProvider extends DbProvider {
    @Override
    void connectToDb(){
        //logic for Mysql
    }
    @Override
    void disconnectFromDb() {
    }
}
