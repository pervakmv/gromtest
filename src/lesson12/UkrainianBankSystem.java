package lesson12;

public class UkrainianBankSystem implements BankSystem {


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
    }

    @Override
    public void fund(User user, int amount) {
        if (amount <= user.getBank().getLimitOfFunding())
            user.setBalance(user.getBalance() + amount);
        else
            printFundErrorMsg(amount, user);

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

}
