package algorithm;

import java.util.Scanner;

public class MinTap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            String line = sc.next();
            char[] strArr = line.toCharArray();
            int sz = strArr.length;
            // dp[i][0] 输入字符串[0,i]部分，大写关闭时所需的最少次数
            // dp[i][1] 输入字符串[0,i]部分，大写打开时所需的最少次数
            int[][] dp = new int[sz][2];
            for (int i = 0; i < sz; i++) {
                char c = strArr[i];
                if (c > 'a' && c < 'z') {
                    if (i == 0) {
                        dp[0][0] = 1;
                        dp[0][1] = 2;
                    } else {
                        dp[i][0] = Math.min(dp[i - 1][0] + 1, dp[i - 1][1] + 2);
                        dp[i][1] = Math.min(dp[i - 1][0] + 2, dp[i - 1][1] + 2);
                    }
                } else {
                    if (i == 0) {
                        dp[0][0] = 2;
                        dp[0][1] = 2;
                    } else {
                        dp[i][0] = Math.min(dp[i - 1][0] + 2, dp[i - 1][1] + 2);
                        dp[i][1] = Math.min(dp[i - 1][0] + 2, dp[i - 1][1] + 1);
                    }
                }
            }
            System.out.println(Math.min(dp[sz - 1][0], dp[sz - 1][1]));
        }
    }
}
