import java.util.Arrays;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int mid = preorder[0];
        TreeNode node = new TreeNode(mid);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == mid) {
                node.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOf(inorder, i));
                node.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                break;
            }
        }
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}