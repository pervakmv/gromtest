package lesson30.HWRev2;

import java.util.Set;
import java.util.TreeSet;

public class DepartmentDAO {
    Set<Department> departmentsList = new TreeSet<>();

    public DepartmentDAO() {
    }

    public DepartmentDAO(Set<Department> departmentsList) {
        this.departmentsList = departmentsList;
    }

    public Set<Department> getDepartmentsList() {
        return departmentsList;
    }


    public void save(Department element){
        departmentsList.add(element);
    }

}
