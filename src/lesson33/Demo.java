package lesson33;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        ReadWriteFile.readFile("C:/Temp/test.txt");

        ReadWriteFile.writeFile("C:/Temp/test.txt", "Java Core");

    }
}
