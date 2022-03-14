package company.aliyun.test2;

import java.util.Arrays;
import java.util.Scanner;

public class Main8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = sc.nextInt();
        }
        int[] ans = new int[n+1];
        Arrays.fill(ans, 1);
        for(int i=1; i<=n; i++){
            int ptr = arr[i];
            while(ptr != 0){
                ans[ptr]++;
                ptr = arr[ptr];
            }
        }
        for(int i=1; i<=n; i++){
            System.out.printf("%d ", ans[i]);
        }
    }
}
