//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
import java.beans.IntrospectionException;
import java.util.*;

class Solution {
    List<List<Integer>> ans;
    Stack<Integer> res;
    public List<List<Integer>> permute(int[] nums) {
        this.ans = new ArrayList<>();
        this.res = new Stack<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited,false);
//        res.push(nums[0]);
//        visited[0] = true;
        backtrace(nums,visited);
        return ans;
    }

    public void backtrace(int[] nums, boolean[] visited){
        boolean over = true;
        for (int i = 0; i <visited.length ; i++) {
            over = over&visited[i];
            if(!over){
                break;
            }
        }
        if(over){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!visited[i]){
                res.push(nums[i]);
                visited[i] = true;
                backtrace(nums, visited);
                visited[i] = false;
                res.pop();
            }
        }
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[] nums = {1,2,3};
//        List<List<Integer>> ans = s.permute(nums);
//        System.out.println(ans);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
