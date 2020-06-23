//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
// Related Topics 数组 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> allRes = new ArrayList<>();
        Stack<Integer> curRes = new Stack<>();

        Arrays.sort(candidates);
        backtrack(allRes, curRes, candidates, target);

        return allRes;
    }

    public void backtrack(List<List<Integer>> allRes, Stack<Integer> curRes, int[] candidates, int target) {
        if (target == 0) {
            List<Integer> res = new ArrayList<>(curRes);
            Collections.sort(res);
            if(!allRes.contains(res)){
                allRes.add(new ArrayList<>(curRes));
            }
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            int value = candidates[i];
            if (value <= target) {
                curRes.push(value);
                backtrack(allRes, curRes, candidates, target-value);
                curRes.pop();
            }else{
                break;
            }
        }
    }

//    public static void main(String[] args) {
//        Solution s= new Solution();
//        int[] candidates = {2,3,6,7};
//        List<List<Integer>> res = s.combinationSum(candidates,7);
//        for(List<Integer> r:res){
//            System.out.println(r);
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
