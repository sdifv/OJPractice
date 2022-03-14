package company.aliyun.test1;

import java.util.Scanner;

public class Main3 {
    static int BASE = (int) (Math.pow(10, 9) + 7);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <=m ; i++) {
            dp[1][i] = 1;
        }
        for (int i = 0; i <=m ; i++) {
            dp[0][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                for (int k = 0; k <= i-1; k++) {
                    dp[i][j] += (dp[k][j-1] * dp[i-1-k][j-1])%BASE;
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
