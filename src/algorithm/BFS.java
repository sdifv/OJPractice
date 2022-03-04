package algorithm;

import dataStruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int expectNumber) {
        res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        bfs(root, expectNumber);
        return res;
    }

    private void bfs(TreeNode root, int expect){
        Queue<PathNode> queue = new LinkedList<>();
        queue.offer(new PathNode(root, new ArrayList<Integer>(), expect));
        while(!queue.isEmpty()){
            PathNode hop = queue.poll();
            if(hop.expect == 0){
                res.add(hop.path);
            }else{
                TreeNode node = hop.node;
                if(node.left != null && node.left.val <= hop.expect){
                    ArrayList<Integer> path = new ArrayList<>(hop.path);
                    path.add(node.left.val);
                    queue.offer(new PathNode(node.left, path, expect-node.val));
                }
                if(node.right != null && node.right.val <= hop.expect){
                    ArrayList<Integer> path = new ArrayList<>(hop.path);
                    path.add(node.right.val);
                    queue.offer(new PathNode(node.right, path, expect-node.val));
                }
            }
        }
    }

    class PathNode{
        TreeNode node;
        ArrayList<Integer> path;
        int expect;

        public PathNode(TreeNode node, ArrayList<Integer> path, int expect){
            this.node = node;
            this.path = path;
            this.expect = expect;
        }
    }
}
