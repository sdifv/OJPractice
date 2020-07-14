//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        while(root!=null){
            if(root.left==null){
                // 左子树为空，直接从右子树开始处理
                root = root.right;
            }else{
                // 遍历找到左子树的最右叶子节点leftNode
                TreeNode leftNode = root.left;
                while(leftNode.right!=null){
                    leftNode = leftNode.right;
                }
                // 将右子树挂到leftNode的右子树上
                leftNode.right = root.right;
                // 将原先的左子树挂到root的右子树上
                root.right = root.left;
                // 去除左子树
                root.left = null;
                // 指向下一层的根节点
                root = root.right;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
