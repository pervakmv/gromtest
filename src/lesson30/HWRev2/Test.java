package lesson30.HWRev2;

import java.util.Set;
import java.util.TreeSet;

public class Test<T> {

    private Set<T> list = new TreeSet<>();

    public Test(Set<T> list) {
        this.list = list;
    }


    public Set<T> getSection(int fromIndex, int endIndex){
        if(list.size() == 0
            || fromIndex > list.size()
            || endIndex > list.size())
            return null;

        Set<T>res = new TreeSet<>();
        int index = 0;
        for(T element : list){
            if(index >= fromIndex && index <= endIndex){
                res.add(element);
            }
            index++;
        }
        return res;
    }

}
