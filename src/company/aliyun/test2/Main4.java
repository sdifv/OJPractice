package company.aliyun.test2;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] xArr = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            xArr[i] = x;
        }
        Arrays.sort(xArr);
        int mid = xArr.length / 2;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(xArr[i] - xArr[mid]);
        }
        System.out.println(sum);
    }
}
