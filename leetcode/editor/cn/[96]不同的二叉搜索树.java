//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        int[] recodes = new int[n + 1];
        recodes[0] = 1;

        for (int i = 1; i <= n; i++) {
            int type = 0;
            for (int j = 0; j < i; j++) {
                int left = j;   //左子树的序号组成[0...left]
                int right = i - j - 1;  //右子树的序号组成[0...right]
                type += recodes[left] * recodes[right];
            }
            recodes[i] = type;
        }
        return recodes[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
