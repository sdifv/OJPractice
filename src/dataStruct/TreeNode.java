package dataStruct;


//  Definition for a binary tree node.
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode treeOf(String[] arr) {
        int sz = arr.length;
        TreeNode[] treeNodeArr = new TreeNode[sz];
        for (int i = 0; i < sz; i++) {
            if (arr[i].equals("#")) {
                treeNodeArr[i] = null;
            } else {
                treeNodeArr[i] = new TreeNode(Integer.parseInt(arr[i]));
            }
        }
        for (int i = 0; i * 2 + 2 < sz; i++) {
            if (treeNodeArr[i] != null) {
                treeNodeArr[i].left = treeNodeArr[i * 2 + 1];
                treeNodeArr[i].right = treeNodeArr[i * 2 + 2];
            }
        }
        return treeNodeArr[0];
    }
}

