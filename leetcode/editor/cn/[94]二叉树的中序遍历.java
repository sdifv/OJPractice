//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


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
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();

        do {
            while (root != null) {
                //持续向左分支进行深搜，找到最左的叶子节点
                nodes.push(root);
                root = root.left;
            }
            if (!nodes.isEmpty()) {
                //从最分支的叶子节点向上回溯
                TreeNode node = nodes.pop();
                ans.add(node.val);
                //左-中-右，开始处理当前节点的右分支
                root = node.right;
            }
        } while (!nodes.isEmpty() || root != null); //迭代终止条件

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
