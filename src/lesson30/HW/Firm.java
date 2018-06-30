package lesson30.HW;

import java.util.Collection;

import java.util.Date;
import java.util.TreeSet;

public class Firm implements Comparable<Firm> {
    private Date dateFounded;
    private Collection<Department> departments;
    private Collection<Customer> customers;


    public Firm() {
    }

    public Firm(Date dateFounded, Collection<Department> departments, Collection<Customer> customers) {
        this.dateFounded = dateFounded;
        this.departments = departments;
        this.customers = customers;
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public Collection<Department> getDepartments() {
        return departments;
    }

    public void setDateFounded(Date dateFounded) {
        this.dateFounded = dateFounded;
    }

    public void setDepartments(Collection<Department> departments) {
        this.departments = departments;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }

    public Collection<Customer>getCustomers() {
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
