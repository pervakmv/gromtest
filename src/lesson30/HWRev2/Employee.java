package lesson30.HWRev2;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

public class Employee implements Comparable<Employee>{
    private String firstName;
    private String lastName;
    private Date dateHired;
    private Position position;
    private Department department;
    private Set<Project> projects;


    public Employee(String firstName, String lastName, Date dateHired, Position position, Department department, Set<Project> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = dateHired;
        this.position = position;
        this.department = department;
        this.projects = projects;
    }

    @Override
    public int compareTo(Employee e) {
        if(!this.getLastName().equals(e.getLastName())){
            return this.getLastName().compareTo(e.getLastName());
        }
        if(!this.getFirstName().equals(e.getFirstName())){
            return this.getFirstName().compareTo(e.getFirstName());
        }
        return 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public Position getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateHired=" + dateHired +
                ", position=" + position +
                ", department=" + department +
                ", projects=" + projects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        return lastName != null ? lastName.equals(employee.lastName) : employee.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
