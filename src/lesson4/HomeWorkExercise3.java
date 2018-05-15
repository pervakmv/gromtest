package lesson4;

public class HomeWorkExercise3 {

    public static void main(String[] args) {

        System.out.println(compareSums(2,10,13,18));
        System.out.println(sum(2,10));
        System.out.println(sum(13,17));

    }


    public static boolean compareSums(int a, int b, int c, int d){

        if(sum(a,b) > sum(c,d)) return true;
        else return false;
    }

    private static long sum(int from, int to){
        long res=0;

        for(long i=from; i<=to; i++){
            res +=  i;
        }
        return res;
    }

}
