package company.aliyun.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main7 {
    static class Item implements Comparable {
        public int a = Integer.MAX_VALUE;
        public int m = 0;

        @Override
        public int compareTo(Object o) {
            Item that = (Item) o;
            if (this.a == that.a) {
                return that.m - this.m;
            }
            return this.a - that.a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] items = br.readLine().trim().split(" ");
        int n = Integer.parseInt(items[0]), m = Integer.parseInt(items[1]);
        Item[] cost = new Item[n];
        items = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            cost[i] = new Item();
            cost[i].a = Integer.parseInt(items[i]);
            cost[i].m = 1;
        }
        int k = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < k; i++) {
            items = br.readLine().trim().split(" ");
            int u = Integer.parseInt(items[0]);
            int v = Integer.parseInt(items[1]);
            cost[u - 1].a += cost[v - 1].a;
            cost[u - 1].m++;
            cost[v - 1].a = Integer.MAX_VALUE;
            cost[v - 1].m = 0;
        }
        Arrays.sort(cost);
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            if (cost[i].m == 0)
                continue;
            for (int j = m; j >= cost[i].a; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i].a] + cost[i].m);
            }
        }
        System.out.println(dp[m]);
    }

}
