//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return ans;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            Queue<TreeNode> subQueue = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    subQueue.offer(node.left);
                }
                if(node.right!=null){
                    subQueue.offer(node.right);
                }
                list.add(node.val);
            }
            ans.add(list);
            queue = new LinkedList<>(subQueue);
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
