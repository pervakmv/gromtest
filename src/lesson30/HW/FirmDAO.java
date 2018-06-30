package lesson30.HW;

import java.util.Set;

public class FirmDAO extends DAO<Firm> {
    public FirmDAO() {
    }

    public FirmDAO(Set<Firm> base) {
        super(base);
    }
}
