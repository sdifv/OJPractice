package company.aliyun.test1;

import algorithm.InterLeave;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main6 {
    private static int minStep = Integer.MAX_VALUE;
    private static List<Integer>[] graph;
    private static int[] level;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        level = new int[n+1];
        String[] items = br.readLine().trim().split(" ");
        for(int i=0; i<items.length; i++){
            level[i+1] = Integer.parseInt(items[i]);
        }
        graph = new List[n+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; i++){
            items = br.readLine().trim().split(" ");
            int u = Integer.parseInt(items[0]);
            int v = Integer.parseInt(items[1]);
            graph[u].add(v);
            graph[v].add(u);
        }
        for(int i=1; i<=n; i++){
            dfs(i, i, 0, 0);
        }
        if(minStep == Integer.MAX_VALUE){
            minStep = -1;
        }
        System.out.println(minStep);
    }

    private static void dfs(int root, int cur, int prev, int steps) {
        if(cur != root && level[cur] == level[root]){
            minStep = Math.min(steps, minStep);
            return;
        }
        for (Integer next : graph[cur]) {
            if(next != prev){
                dfs(root, next, cur, steps+1);
            }
        }
    }
}
