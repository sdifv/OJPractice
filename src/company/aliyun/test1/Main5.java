package company.aliyun.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] items = br.readLine().trim().split(" ");
            arr[i][0] = Integer.parseInt(items[0]);
            arr[i][1] = Integer.parseInt(items[1]);
        }

    }
}
