package lesson30.HW;

import java.util.Set;

public class ProjectDAO extends DAO<Project> {
    public ProjectDAO() {
    }

    public ProjectDAO(Set<Project> base) {
        super(base);
    }
}
