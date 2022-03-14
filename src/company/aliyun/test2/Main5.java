package company.aliyun.test2;

import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int left = 1, right = n - 2;
        while (left <= right) {
            // 1. 交换
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            // 2. 滑动指针
            left += 2;
            right -= 2;
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if(i == n-1){
                sum += Math.abs(arr[i] - arr[0]);
            }else{
                sum += Math.abs(arr[i] - arr[i+1]);
            }
        }
        System.out.println(sum);
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
    }
}
