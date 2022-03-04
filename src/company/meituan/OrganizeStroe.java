package company.meituan;

import java.util.Scanner;

public class OrganizeStroe {
    static int left, right;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = sc.nextInt();
        }

        left = 1;
        right = n;
        int lastVal = 0;
        boolean[] cuted = new boolean[n + 1];
        for (int id : ids) {
            cuted[id] = true;
            arr[id] = 0;
            if (id < left || id > right) {
                System.out.println(lastVal);
            } else {
                lastVal = scanMaxSum(arr, cuted);
                System.out.println(lastVal);
            }
        }
    }

    private static int scanMaxSum(int[] arr, boolean[] cuted) {
        int maxSum = Integer.MIN_VALUE;
        int[] sum = new int[arr.length];
        int sz = arr.length;
        left = 1;
        right = 1;
        for (int i = 1; i < sz; i++) {
            if (cuted[i]) {
                sum[i] = 0;
            } else {
                sum[i] = sum[i - 1] + arr[i];
                right = i;
                if(sum[i] > maxSum){
                    maxSum = sum[i];
                }
            }
        }
        return maxSum == Integer.MIN_VALUE ? 0 : maxSum;
    }
}
