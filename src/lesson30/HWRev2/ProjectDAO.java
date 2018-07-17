package lesson30.HWRev2;

import java.util.Set;
import java.util.TreeSet;

public class ProjectDAO{
    Set<Project> base = new TreeSet<>();

    public ProjectDAO() {
    }

    public ProjectDAO(Set<Project> base) {
        this.base = base;
    }

    public Set<Project> getBase() {
        return base;
    }

    public void save(Project element){
        base.add(element);
    }




    public Set<Project> getSection(int fromIndex, int endIndex) {
        if (base.size() == 0
                || fromIndex > base.size()
                || endIndex > base.size())
            return null;

        Set<Project> res = new TreeSet<>();
        int index = 0;
        for (Project element : base) {
            if (index >= fromIndex && index <= endIndex) {
                res.add(element);
            }
            index++;
        }
        return res;
    }

}
