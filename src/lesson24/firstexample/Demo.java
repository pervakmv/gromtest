package lesson24.firstexample;

public class Demo <T> {

//    private printUser(User user){
//        //print
//    }

//    private printSolution(Solution Solution){
//        //print
//    }

//    private printChannel(channel channel){
//        //print
//    }


    public void print(T t){
     //print
        System.out.println(t);
    }

    private static void calculatePrice(FirstOrder firstOrder){
        System.out.println(firstOrder.getPrice());

    }

//    private void calculatePrice(SecondOrder secondOrder){
//        Sys.out.println(secondOrder.getPrice());
//
//    }

    public static void main(String[] args) {
        calculatePrice(new FirstOrder());
        calculatePrice(new SecondOrder());
    }

}
