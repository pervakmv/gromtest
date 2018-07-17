package lesson30.HWRev2;

import java.util.Set;
import java.util.TreeSet;

public class DepartmentDAO {
    Set<Department> base = new TreeSet<>();

    public DepartmentDAO() {
    }

    public DepartmentDAO(Set<Department> base) {
        this.base = base;
    }

    public Set<Department> getBase() {
        return base;
    }


    public void save(Department element){
        base.add(element);
    }
}
