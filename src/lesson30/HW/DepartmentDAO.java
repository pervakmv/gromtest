package lesson30.HW;

import java.util.Set;

public class DepartmentDAO extends DAO<Department> {
    public DepartmentDAO() {
    }

    public DepartmentDAO(Set<Department> base) {
        super(base);
    }
}
