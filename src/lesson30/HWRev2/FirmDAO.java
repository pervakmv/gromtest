package lesson30.HWRev2;

import java.util.Set;
import java.util.TreeSet;

public class FirmDAO  {
    private Set<Firm> base = new TreeSet<>();

    public FirmDAO() {
    }

    public FirmDAO(Set<Firm> base) {
        this.base = base;
    }

    public Set<Firm> getBase() {
        return base;
    }

    public void save(Firm element){
        base.add(element);
    }
}
