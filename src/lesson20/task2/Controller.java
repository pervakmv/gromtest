package lesson20.task2;

import lesson20.task2.exception.LimitExceeded;

public class Controller {
    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction) throws LimitExceeded {
        return transactionDAO.save(transaction);
    }

    Transaction[] transactionList(){
        return null;
    }

    Transaction[] transactionList(String city){
        return null;
    }

    Transaction[] transactionList(int amount){
        return null;
    }

}
