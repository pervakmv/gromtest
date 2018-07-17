package lesson30.HWRev2;

public class Customer implements Comparable<Customer> {
    private String name;
    private String country;
    private int monthlyPay;

    public Customer(String name, String country, int monthlyPay) {
        this.name = name;
        this.country = country;
        this.monthlyPay = monthlyPay;
    }

    @Override
    public int compareTo(Customer customer) {

//        if(!customer.getName().equals(this.getName())){
//            return customer.getName().compareTo(this.getName());
//        }
        if(!this.getName().equals(customer.getName())){
            return this.getName().compareTo(customer.getName());
        }

//        if(!customer.getCountry().equals(this.getCountry())){
//            return customer.getCountry().compareTo(this.getCountry());
//        }

        if(!this.getCountry().equals(customer.getCountry())){
            return this.getCountry().compareTo(customer.getCountry());
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", monthlyPay=" + monthlyPay +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getMonthlyPay() {
        return monthlyPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (monthlyPay != customer.monthlyPay) return false;
        if (!name.equals(customer.name)) return false;
        return country.equals(customer.country);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + monthlyPay;
        return result;
    }
}

