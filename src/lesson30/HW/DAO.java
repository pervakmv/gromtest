package lesson30.HW;

import java.util.Set;
import java.util.TreeSet;

public class DAO<T> {

    private Set<T> base = new TreeSet<>();

    public DAO(Set<T> base) {
        this.base = base;
    }

    public DAO() {
    }



    public T save(T t) {
        if (base.add(t))
            return t;
        return null;
    }

    public Set<T> getAll() {
        return  base;
    }


    public T getObjectByIndex(int index) {

        if (base.size() == 0
                || index > base.size())
            return null;
        T[] array = (T[]) base.toArray();

        return array[index];

    }

    public Set<T> getSection(int fromIndex, int endIndex) {
        if (base.size() == 0
                || fromIndex > base.size()
                || endIndex > base.size())
            return null;

        Set<T> res = new TreeSet<>();
        int index = 0;
        for (T element : base) {
            if (index >= fromIndex && index <= endIndex) {
                res.add(element);
            }
            index++;
        }
        return res;
    }

}
