package lesson30.HWRev2;

import java.util.Set;
import java.util.TreeSet;

public class FirmDAO  {
    private Set<Firm> firmsList = new TreeSet<>();

    public FirmDAO() {
    }

    public FirmDAO(Set<Firm> firmsList) {
        this.firmsList = firmsList;
    }

    public Set<Firm> getFirmsList() {
        return firmsList;
    }

    public void save(Firm element){
        firmsList.add(element);
    }
}
