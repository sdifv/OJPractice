import structure.TreeHelper;
import structure.TreeNode;
/*
 * Q:操作给定的二叉树，将其变换为源二叉树的镜像
 * tag: 树
 */
public class Solution18 {

  public static void main(String[] args) {
    Solution18 s = new Solution18();
    s.testMirror();
  }

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

  public void testMirror(){
    TreeHelper treeHelper = new TreeHelper();
    String treeValues = "1,2,#,#,3,4,#,#,5,6,#,8,#,#";
    treeHelper.setValues(treeValues);
    TreeNode root = treeHelper.createTree();

    System.out.println("中序遍历二叉树：");
    treeHelper.inOrder(root);
    System.out.println();

    Mirror(root);

    System.out.println("中序遍历二叉树的镜像：");
    treeHelper.inOrder(root);
    System.out.println();

  }
}
