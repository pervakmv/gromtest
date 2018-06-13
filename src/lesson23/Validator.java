package lesson23;

public class Validator {
    private String name;
    private final int checkCount = 7;


    public Validator(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public int getCheckCount() {
        return checkCount;
    }

    public final boolean validate() {
        //
        //
        //
        return false;
    }

}
