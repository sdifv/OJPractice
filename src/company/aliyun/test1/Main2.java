package company.aliyun.test1;

import java.util.Scanner;

public class Main2 {
    static int BASE = (int) (Math.pow(10, 9) + 7);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int n = sc.nextInt();
            System.out.println((fastPow(A, n)%BASE + fastPow(B, n)%BASE)%BASE);
        }
    }

    public static long fastPow(long base, int index){
        long tmp = 1;
        while (index > 0) {
            if ((index & 1) == 1) {
                tmp = base*tmp;
            }
            base = (base*base)%BASE;
            index >>= 1;
        }
        return tmp;
    }
}
