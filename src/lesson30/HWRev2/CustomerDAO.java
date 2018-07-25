package lesson30.HWRev2;

import java.util.Set;
import java.util.TreeSet;

public class CustomerDAO {

    Set<Customer> customersList = new TreeSet<>();

    public CustomerDAO() {
    }


    public CustomerDAO(Set<Customer> customersList) {
        this.customersList = customersList;
    }

    public Set<Customer> getCustomersList() {
        return customersList;
    }

    public void save(Customer element){
        customersList.add(element);
    }
}
