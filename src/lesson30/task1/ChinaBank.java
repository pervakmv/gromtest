package lesson30.task1;

public class ChinaBank extends Bank {
    public ChinaBank(long id, String bankcountry, Currency currency, int numberOffEmployers, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankcountry, currency, numberOffEmployers, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        if (getCurrency() == Currency.USD)
            return 100;
        else
            return 150;
    }

    @Override
    public int getLimitOfFunding() {

        if (getCurrency() == Currency.EUR)
            return 5000;
        else
            return 10000;
    }

    @Override
    public double getMonthlyRate() {
        //monthly rate - 1% with USD and 2% with EUR
        if (getCurrency() == Currency.EUR)
            return 0.0;
        else
            return 0.01;
    }

    @Override
    public double getCommission(int amount) {

        //commisi
        if (getCurrency() == Currency.USD) {
            if (amount <= 1000)
                return 0.03;
            else
                return 0.05;
        } else {
            if (amount <= 1000)
                return 0.1;
            else
                return 0.11;
        }
    }
}
