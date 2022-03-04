package company.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Errands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] value = new int[n][2];
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt(), w = sc.nextInt();
            value[i][0] = v + 2 * w;
            value[i][1] = i + 1;
        }
        Arrays.sort(value, (a, b) -> {
            return b[0] - a[0];
        });

        int[] ans = new int[m];
        for (int i = 0; i < m && i < n; i++) {
            ans[i] = value[i][1];
        }
        Arrays.sort(ans);
        for (int i = 0; i < m; i++) {
            System.out.printf("%d ", ans[i]);
        }
    }
}
