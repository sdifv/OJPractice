//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 933 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int minHops;

    public int jump(int[] nums) {
        int curHops = 0;
        int curIndex = 0;
        minHops = Integer.MAX_VALUE;
        int[] hops = new int[nums.length];
        for (int i = 0; i < hops.length; i++) {
            hops[i] = Integer.MAX_VALUE;
        }
        backtrack(nums, hops, 0, 0);
        return minHops;
    }

    private void backtrack(int[] nums, int[] hops, int curIndex, int curHops) {
        if (curIndex == nums.length - 1) {
            if (curHops < minHops) {
                minHops = curHops;
            }
            return;
        }
        for (int hop = 1; hop <= nums[curIndex] && curIndex + hop < nums.length; hop++) {   // 显约束
            if (hops[curIndex + hop] > curHops + 1) {   // 隐约束
                hops[curIndex + hop] = curHops + 1;
                backtrack(nums, hops, curIndex + hop, curHops + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        Solution s = new Solution();
        System.out.println(s.jump(arr));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
