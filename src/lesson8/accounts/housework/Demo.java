package lesson8.accounts.housework;

public class Demo {
    public static void main(String[] args) {
        Adder adder = new Adder();

        int a[] = {34, 100, 45, 3, 78};

        System.out.println(adder.check(a));
        System.out.println(adder.add(50, 25));
        System.out.println(adder.add(50, 125));

    }
}
