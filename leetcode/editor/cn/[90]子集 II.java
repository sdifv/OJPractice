//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 数组 回溯算法 
// 👍 563 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    List<List<Integer>> perms;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        perms = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        backtrack(0, nums.length, perm);
        return map2Var(nums, perms);
    }

    private List<List<Integer>> map2Var(int[] nums, List<List<Integer>> perms) {
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> perm : perms) {
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < perm.size(); i++) {
                if (perm.get(i)==1) {
                    cur.add(nums[i]);
                }
            }
            Collections.sort(cur);
            if(!ans.contains(cur)){
                ans.add(cur);
            }
        }
        return ans;
    }

    private void backtrack(int idx, int length, List<Integer> perm) {
        if (idx == length) {
            perms.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < 2; i++) {
            perm.add(i);
            backtrack(idx + 1, length, perm);
            perm.remove(idx);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,2,2};
        System.out.println(s.subsetsWithDup(arr));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
