package company.aliyun.test1;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0){
            int n = sc.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                y[i] = sc.nextInt();
            }
            System.out.println(solve(x, y, n));
        }
    }

    private static int solve(int[] x, int[] y, int n) {
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = x[i];
            data[i][1] = y[i];
        }
        Arrays.sort(data, (a,b)->{
            if(a[0] == b[0])
                return a[1] - b[1];
            else
                return a[0] - b[0];
        });
        int ans = 1;
        int lastx = data[0][0], lasty = data[0][1];
        for (int i = 1; i < n; i++) {
            if(data[i][0] > lastx && data[i][1] > lasty){
                ans++;
                lastx = data[i][0];
                lasty = data[i][1];
            }
        }
        return ans;
    }
}
