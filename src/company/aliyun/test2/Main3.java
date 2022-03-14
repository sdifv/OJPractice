package company.aliyun.test2;

import java.util.Scanner;

public class Main3 {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong(), B = sc.nextLong();
        long a = sc.nextLong(), b = sc.nextLong();
        long g = gcd(a, b);
        a /= g;
        b /= g;
        long x = A / a * a;
        long y = x / a * b;
        if(y > B){
            y = B / b * b;
            x = a * y / b;
        }
        System.out.printf("%d %d\n", x, y);
    }

    private static long gcd(long a, long b) {
        if(b==0)
            return a;
        else
            return gcd(b,a%b);
    }
}
