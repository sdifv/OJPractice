//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> output = new ArrayList();
//        output.add(new ArrayList<Integer>());
//
//        for (int num : nums) {
//            List<List<Integer>> newSubsets = new ArrayList();
//            for (List<Integer> curr : output) {
//                newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
//            }
//            for (List<Integer> curr : newSubsets) {
//                output.add(curr);
//            }
//        }
//        return output;
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = (int) Math.pow(2,n); i<Math.pow(2,n+1); i++){
            String mark = Integer.toBinaryString(i).substring(1);

            List<Integer> res = new ArrayList<>();
            for(int j=0;j<mark.length();j++){
                if(mark.charAt(j)=='1'){
                    res.add(nums[j]);
                }
            }
            ans.add(res);
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
