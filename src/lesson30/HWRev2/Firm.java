package lesson30.HWRev2;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Firm implements Comparable<Firm> {
    private Date dateFounded;
    private Set<Department> departments;
    private Set<Customer> customers;


    public Firm() {
    }

    public Firm(Date dateFounded, Set<Department> departments, Set<Customer> customers) {
        this.dateFounded = dateFounded;
        this.departments = departments;
        this.customers = customers;
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDateFounded(Date dateFounded) {
        this.dateFounded = dateFounded;
    }

    public void setDepartments(TreeSet<Department> departments) {
        this.departments = departments;
    }

    public void setCustomers(TreeSet<Customer> customers) {
        this.customers = customers;
    }

    public Set<Customer>getCustomers() {
        return customers;
    }

    @Override
    public int compareTo(Firm o) {

        return this.getDateFounded().compareTo(o.getDateFounded());
    }

    @Override
    public String toString() {
        return "Firm{" +
                "dateFounded=" + dateFounded +
                ", departments=" + departments +
                ", customers=" + customers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Firm firm = (Firm) o;

        if (!dateFounded.equals(firm.dateFounded)) return false;
        if (!departments.equals(firm.departments)) return false;
        return customers.equals(firm.customers);
    }

    @Override
    public int hashCode() {
        int result = dateFounded.hashCode();
        result = 31 * result + departments.hashCode();
        result = 31 * result + customers.hashCode();
        return result;
    }
}
