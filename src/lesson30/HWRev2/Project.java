package lesson30.HWRev2;

public class Project implements Comparable<Project> {
    String name;
    Customer customer;

    public Project(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public int compareTo(Project o) {
        if(!this.getCustomer().equals(o.getCustomer())){
            return this.getCustomer().compareTo(o.getCustomer());
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (!name.equals(project.name)) return false;
        return customer.equals(project.customer);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + customer.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", customer=" + customer +
                '}';
    }
}
