package lesson4;

public class Demo {
    public static void main(String[] args) {
        HomeWork1 homeWork1 = new HomeWork1();

       HomeWorkExercise2 homeWorkExercise2 = new HomeWorkExercise2();

        System.out.println(HomeWorkExercise2.findDivCount((short)10, (short)100, (short)3));

        System.out.println(HomeWorkExercise2.sum(10, 100));

        System.out.println(HomeWorkExercise2.compareSums(10, 50, 3, 30));
        System.out.println(HomeWorkExercise2.compareSums(1,50, 30,60));

        System.out.println(HomeWorkExercise3.compareSums(11,32, 14,24));

    }
}
