package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Date;
import java.util.Calendar;

public class TransactionDAO {

    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws LimitExceeded  {

        // сумма транзакции больше указанного лимита
        // сумма транзакций за день больше дневного лимита
        // количество транзаций за день больше указанного лимита
        // если город платы (совершения транзации) не разрешен
        // не хватило места


//TODO

        return transactions[4];
    }


    private void validate(Transaction transaction) throws LimitExceeded{
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can't be saved");

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum > utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can't be saved");
        }

        if (count > utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can't be saved");
        }


//        if (!utils.availableCity(transaction.getCity())) {
//            throw new BadRequestException("City is not available " + transaction.getId() + ". Can't be saved");
//        }
//        if (!thereIsFreeSpace())
//            throw new InternalServerException("no free memory available " + transaction.getId() + ". Can't be saved");
    }//validate


    public boolean thereIsFreeSpace() {
        for (Transaction tr : transactions) {
            if (tr == null)
                return true;
        }
        return false;
    }

    public Transaction[] transactionList() {
        return null;
    }


    public Transaction[] transactionList(String city) {
        return null;
    }

    public Transaction[] transactionList(int amount) {
        return null;
    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;

            }
        }
        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;

    }
}
