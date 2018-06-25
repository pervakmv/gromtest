package lesson30.task1;

public class USBank extends Bank {
    public USBank(long id, String bankcountry, Currency currency, int numberOffEmployers, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankcountry, currency, numberOffEmployers, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        if(getCurrency()==Currency.USD)
            return 1000;
        else
            return 1200;
    }

    @Override
    public int getLimitOfFunding() {
        if (getCurrency() == Currency.EUR)
            return 10000;
        return Integer.MAX_VALUE;
    }

    @Override
    public double getMonthlyRate() {
        //monthly rate - 1% with USD and 2% with EUR
        if (getCurrency() == Currency.EUR)
            return 0.02;
        else
            return 0.01;
    }

    @Override
    public double getCommission(int amount) {
        //commisi
        if (getCurrency() == Currency.USD) {
            if (amount <= 1000)
                return 0.05;
            else
                return 0.07;
        } else {
            if (amount <= 1000)
                return 0.06;
            else
                return 0.08;
        }
    }
}
