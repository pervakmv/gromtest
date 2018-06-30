package lesson30.HW;

import java.util.Arrays;
import java.util.Collection;

public class Department implements Comparable<Department>{
    DepartmentType type;
    Collection employees;

    public Department(DepartmentType type, Collection employees) {
        this.type = type;
        this.employees = employees;
    }

    public DepartmentType getType() {
        return type;
    }

    public Collection getEmployees() {
        return employees;
    }

    @Override
    public int compareTo(Department o) {

        return this.getType().compareTo(o.getType());
    }

    @Override
    public String toString() {
        return "Department{" +
                "type=" + type +
                //", employees=" + employees +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        return type == that.type;
    }

    @Override
    public int hashCode() {
        return type != null ? type.hashCode() : 0;
    }
}
