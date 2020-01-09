package solutions;

import structure.TreeNode;

import java.util.ArrayList;

public class Solution24 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null){
            return res;
        }
        path.add(root.val);
        target -= root.val;

        if(target == 0 && root.left == null && root.right == null) {
            //此处不能直接res.add(path),path后续的改变会影响引用对象的值
            res.add(new ArrayList<>(path));
        }

        ArrayList<ArrayList<Integer>> result1 = FindPath(root.left, target);
        ArrayList<ArrayList<Integer>> result2 = FindPath(root.right, target);

        path.remove(path.size()-1); //回溯？

        //全部遍历完毕后，返回结果
        return res;
    }
}
