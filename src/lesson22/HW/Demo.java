package lesson22.HW;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        //Створюємо трназакції
        Transaction[] transactions = new Transaction[10];
        Controller controller = new Controller();

        transactions[0] = new Transaction(120, "Kiev", 2, "plc", TransactionType.OUTCOME, new Date());
        transactions[1] = new Transaction(121, "Odessa", 3, "plc", TransactionType.OUTCOME, new Date());
        transactions[2] = new Transaction(122, "Kiev", 3, "plc", TransactionType.OUTCOME, new Date());
        transactions[3] = new Transaction(123, "Odessa", 3, "plc", TransactionType.OUTCOME, new Date());

        transactions[4] = new Transaction(124, "Kiev", 2, "plc", TransactionType.OUTCOME, new Date());
        transactions[5] = new Transaction(125, "Odessa", 3, "plc", TransactionType.OUTCOME, new Date());
        transactions[6] = new Transaction(126, "Kiev", 3, "plc", TransactionType.OUTCOME, new Date());
        transactions[7] = new Transaction(127, "Odessa", 3, "plc", TransactionType.OUTCOME, new Date());

        transactions[8] = new Transaction(128, "Borispol", 3, "plc", TransactionType.OUTCOME, new Date());
        transactions[9] = new Transaction(129, "Odessa", 3, "plc", TransactionType.OUTCOME, new Date());


        //TransactionDAO data = new TransactionDAO(transactions);
        System.out.println(Arrays.deepToString(transactions));


        //Записуємо масив
        for (Transaction element : transactions) {
            try {
                System.out.println("--" + controller.save(element).toString());
            } catch (Exception e) {

                System.out.println(e.getMessage());

            }

        }

        //Записуємо додатковий елемент
        System.out.println(" ---- after method save --------");
        Transaction tr1 = new Transaction(129, "Odessa", 3, "plc", TransactionType.OUTCOME, new Date());
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


        System.out.println(" ---- TransactionList by city --------");

            System.out.println(Arrays.deepToString(controller.transactionList("Kiev")));

        System.out.println(" ---- TransactionList by id --------");

        System.out.println(Arrays.deepToString(controller.transactionList(3)));

    }


}
