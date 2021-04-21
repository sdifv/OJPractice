//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 679 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> res;
    private boolean vis[];

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);  // 首先对数组进行排序
        List<Integer> cur = new ArrayList<>();
        backtrack(nums, 0, cur);
        return res;
    }

    private void backtrack(int[] nums, int k, List<Integer> cur) {
        if (k == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                // 只选取所有未被填充的相同元素最靠右的那个，第k个位置只会被相同元素中右边第i个填一次
                continue;
            }
            vis[i] = true;
            cur.add(nums[i]);
            backtrack(nums, k + 1, cur);
            vis[i] = false;
            cur.remove(k);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2};
        Solution s = new Solution();
        System.out.println(s.permuteUnique(arr));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
