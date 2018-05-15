package lesson4;

public class HomeWorkExercise2 {

    public static void main(String[] args) {
        System.out.println(findDivCount((short)1,(short)20,2));
        System.out.println(compareSums(2,10,2,5));
    }

    public static int findDivCount(short a, short b, int n) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (i % n == 0)
                count++;
        }
        return count;
    }



    public static int sum(int from, int to){
        int res=0;

        for(int i=from; i<=to; i++){
            res += i;
        }
        return res;
    }//public static int sum

    public static boolean compareSums(int a, int b, int c, int d){
        if(sum(a, b)>sum(c,d)) return true;
        else return false;
    }
}
