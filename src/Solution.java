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
                target = target - value;
                backtrack(allRes, curRes, candidates, target);
                target = target + value;
                curRes.pop();
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        int[] candidates = {2,3,6,7};
        List<List<Integer>> res = s.combinationSum(candidates,7);
        for(List<Integer> r:res){
            System.out.println(r);
        }
    }
}