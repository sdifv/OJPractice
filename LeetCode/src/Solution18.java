import structure.TreeNode;
/*
 * Q:操作给定的二叉树，将其变换为源二叉树的镜像
 * tag: 树
 */
public class Solution18 {
  public void Mirror(TreeNode root) {
    if(root == null){
      return;
    }
    if(root.left == null){
      root.left = root.right;
      root.right = null;
      Mirror(root.left);
    }
    else if(root.right == null){
      root.right = root.left;
      root.left = null;
      Mirror(root.right);
    }
    else{
      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
      Mirror(root.right);
      Mirror(root.left);
    }
  }
}
