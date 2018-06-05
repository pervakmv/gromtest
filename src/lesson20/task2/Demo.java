package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        //Створюємо трназакції
        Transaction[] transactions = new Transaction[10];
        Controller controller = new Controller();

        transactions[0] = new Transaction(120, "Kiev", 25, "plc", TransactionType.OUTCOME, new Date());
        transactions[1] = new Transaction(121, "Odessa", 35, "plc", TransactionType.OUTCOME, new Date());
        transactions[2] = new Transaction(122, "Kiev", 33, "plc", TransactionType.OUTCOME, new Date());
        transactions[3] = new Transaction(123, "Odessa", 33, "plc", TransactionType.OUTCOME, new Date());


        //TransactionDAO data = new TransactionDAO(transactions);
        System.out.println(Arrays.deepToString(transactions));


        //Записуємо масив
        for (Transaction element : transactions) {
            try {
                controller.save(element);
            } catch (Exception e) {

                System.out.println(e.getMessage());

            }

        }

        //Записуємо додатковий елемент
        System.out.println(" ---- after method save --------");
        Transaction tr1 = new Transaction(124, "Kiev", 20, "Plc", TransactionType.INCOME, new Date());
        try {
            controller.save(tr1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            System.out.println(Arrays.deepToString(controller.transactionList()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


}
