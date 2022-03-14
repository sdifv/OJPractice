package algorithm;

public class FastPow {
    public static long fun(long base, int index){
        long tmp = 1;
        while (index > 0) {
            if ((index & 1) == 1) {
                tmp = base*tmp;
            }
            base *= base;
            index >>= 1;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(fun(2, 6));
    }
}
