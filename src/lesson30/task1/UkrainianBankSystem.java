package lesson30.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {


    private Set<Transaction> transactions = new TreeSet<>();


    @Override
    public void withdraw(User user, int amount) {
        //проверить можно ли снять -
        // проверить лимит,
        // -проверить достаточно ли деег
        //снять деньги

        if (!checkWithdraw(user, amount))
            return;

        double balanceAfterWithdraw = user.getBalance() - amount - amount * user.getBank().getCommission(amount);
        user.setBalance(balanceAfterWithdraw);
        createAndSaveTransaction(new Date(), TransactionType.WITHDRAWAL, amount, "sdsdc");

    }

    @Override
    public void fund(User user, int amount) {
        if (amount <= user.getBank().getLimitOfFunding())
            user.setBalance(user.getBalance() + amount);
        else
            printFundErrorMsg(amount, user);

        createAndSaveTransaction(new Date(), TransactionType.WITHDRAWAL, amount, "sdsdc");
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        //снимаем деньги fromUser
        //пополняем toUser

        if (!checkWithdraw(fromUser, amount))
            return;


        if (!checkCurrency(fromUser, toUser))
            return;


        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));

        fund(toUser, amount);
    }

    @Override
    public void paySalary(User user) {

        fund(user, user.getSalary());

    }


    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawalErrorMsg(amount, user);
            return true;
        }
        return false;
    }


    private boolean checkWithdraw(User user, int amount) {
        return (!checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                (!checkWithdrawLimits(user, amount, user.getBalance())));
    }

    private boolean checkCurrency(User user1, User user2) {

        if (user1.getBank().getCurrency() ==
                user2.getBank().getCurrency()) {
            return true;
        } else {
            printCurrencyIsDifferent();
            return false;

        }
    }

    private void printWithdrawalErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money " + amount + " from user " + user.toString());
    }

    private void printFundErrorMsg(int amount, User user) {
        System.err.println("Can't fund money " + amount + " for user " + user.toString());
    }

    private void printCurrencyIsDifferent() {
        System.err.println("The currency is different");
    }

    private Transaction createAndSaveTransaction(Date dateCreated, TransactionType type, int amount, String descr){
        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(), dateCreated, null,  type, amount, descr);
        transactions.add(tr);
        return tr;
    }

    public Set<Transaction> getTransaction(){
        return transactions;
    }


}
