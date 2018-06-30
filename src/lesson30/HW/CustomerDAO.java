package lesson30.HW;

import java.util.Set;

public class CustomerDAO extends DAO<Customer> {
    public CustomerDAO() {
    }

    public CustomerDAO(Set<Customer> base) {
        super(base);
    }
}
