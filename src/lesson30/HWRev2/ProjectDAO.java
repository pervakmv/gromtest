package lesson30.HWRev2;

import java.util.Set;
import java.util.TreeSet;

public class ProjectDAO {
    Set<Project> projectsList = new TreeSet<>();

    public ProjectDAO() {
    }

    public ProjectDAO(Set<Project> projectsList) {
        this.projectsList = projectsList;
    }

    public Set<Project> getProjectsList() {
        return projectsList;
    }

    public void save(Project element) {
        projectsList.add(element);
    }


    public Set<Project> projectsByCustomer(Customer customer) {//Список проектов выполняемых для данного заказчика
        Set<Project> resList = new TreeSet<>();

        for (Project prg : projectsList) {
            if (prg.getCustomer().equals(customer)) {
                resList.add(prg);
            }
        }
        return resList;

    }


}
