//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 566 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> ans;
    private boolean vis[];

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        vis = new boolean[n + 1];
        List<Integer> perm = new ArrayList<>();
        backtrack(n, 0, k, perm, 0);
        return ans;
    }

    private void backtrack(int n, int idx, int k, List<Integer> perm, int last) {
        if (idx == k) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = last + 1; i <= n; i++) {   // 选取从perm末尾的值往后尝试
            if (!vis[i]) {
                vis[i] = true;
                perm.add(i);
                backtrack(n, idx + 1, k, perm, i);
                vis[i] = false;
                perm.remove(idx);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> ans = s.combine(4, 2);
        System.out.println(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
