package lesson29.CW;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetInro {
    public static void main(String[] args) {

        Set<String> set = new LinkedHashSet<>();
        set.add("testStr");

        set.add("111");

        set.add("aaa");

        set.add("aaa");
        set.add("111");

        System.out.println(set);



        Set<File> files = new HashSet<>();
        File file1 = new File("pict.txt", 100);
        File file2 = new File("home.txt", 100);
        File file3 = new File("home.txt", 300);
        files.add(file1);
        files.add(file2);
        files.add(file3);

        System.out.println(files.toString());



    }
}
