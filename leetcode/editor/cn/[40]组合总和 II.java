//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    ArrayList<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> one_answer = new ArrayList<>();
    int[] candidates;
    int target;
    int n;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        this.n = candidates.length;
        Arrays.sort(candidates);
        backtrack(0, 0);
        return res;
    }

    private void backtrack(int start, int path_sum) {//即将往one_answer里填入第start个元素candidates[start]
        if (path_sum >= target) {//因为数组元素都是正整数，path_sum不可能减少
            return;
        }
        for (int i = start; i < n; i++) {//组合，从当前元素开始循环
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            one_answer.add(candidates[i]);
            if (path_sum + candidates[i] == target) {
                res.add(new ArrayList<>(one_answer));
            }
            backtrack(i + 1, path_sum + candidates[i]);
            one_answer.remove(one_answer.size() - 1);
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
