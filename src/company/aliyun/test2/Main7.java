package company.aliyun.test2;

import java.util.Scanner;

public class Main7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[3][n+1];
        for(int i=0; i<3; i++){
            for(int j=1; j<=n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        long[][] dp = new long[n+1][3];
        for(int j=2; j<=n; j++){
            for(int i=0; i<3; i++){
                long diff1 = dp[j-1][0] + Math.abs(arr[i][j] - arr[0][j-1]);
                long diff2 = dp[j-1][1] + Math.abs(arr[i][j] - arr[1][j-1]);
                long diff3 = dp[j-1][2] + Math.abs(arr[i][j] - arr[2][j-1]);
                dp[j][i] = Math.min(diff1, Math.min(diff2, diff3));
            }
//            System.out.printf("%d: %d %d %d\n",j, dp[j][0], dp[j][1], dp[j][2]);
        }
        long ans = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
        System.out.println(ans);
    }
}
