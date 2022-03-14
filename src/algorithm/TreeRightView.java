package algorithm;

import dataStruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int sz = queue.size();
            for(int i=0; i<sz; i++){
                TreeNode node = queue.poll();
                if(i == sz-1) {
                    ans.add(node.val);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeRightView rightView = new TreeRightView();
        rightView.rightSideView(TreeNode.treeOf(new String[]{"1", "2", "3", "4", "#", "#", "#"}));
    }
}
