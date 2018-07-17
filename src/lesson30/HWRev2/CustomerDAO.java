package lesson30.HWRev2;

import java.util.Set;
import java.util.TreeSet;

public class CustomerDAO {

    Set<Customer> base = new TreeSet<>();

    public CustomerDAO() {
    }


    public CustomerDAO(Set<Customer> base) {
        this.base = base;
    }

    public Set<Customer> getBase() {
        return base;
    }

    public void save(Customer element){
        base.add(element);
    }
}
