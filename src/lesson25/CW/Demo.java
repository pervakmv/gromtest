package lesson25.CW;

public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO generalDAO = new GeneralDAO();

        Order order = new Order(1);

        generalDAO.validate(order);

        TestClass<String, Order, Long> testClass = new TestClass<>();
        System.out.println(testClass.doSomething1("rrr"));

        //long - Long
        //int - Integer
        //short - Short

        int test = 100;
        long variable = 111; // - це не об'єкт
        Long variable2 = new Long(222);

        generalDAO.validate(variable2);

        generalDAO.validate(test);


    }
}
