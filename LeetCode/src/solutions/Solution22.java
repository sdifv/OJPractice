package solutions;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Q: 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 * tag: 队列，树
 */
public class Solution22 {
  public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<>();

    if (root == null) {
      return res;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
      TreeNode t = q.poll();
      res.add(t.val);

      if (t.left != null) {
        q.offer(t.left);
      }
      if (t.right != null) {
        q.offer(t.right);
      }
    }

    return res;

  }
}
