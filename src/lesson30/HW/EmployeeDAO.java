package lesson30.HW;

import java.util.Set;

public class EmployeeDAO extends DAO<Employee> {
    public EmployeeDAO() {
    }

    public EmployeeDAO(Set<Employee> base) {
        super(base);
    }
}
