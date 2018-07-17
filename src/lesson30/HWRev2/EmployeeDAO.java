package lesson30.HWRev2;

import java.util.Set;
import java.util.TreeSet;

public class EmployeeDAO {
    Set<Employee> base = new TreeSet<>();

    public EmployeeDAO() {
    }

    public EmployeeDAO(Set<Employee> base) {
        this.base = base;
    }

    public Set<Employee> getBase() {
        return base;
    }

    public void save(Employee element){
        base.add(element);
    }
}
