//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        int rn = grid.length;
        int cn = grid[0].length;

        int[][] table = new int[rn][cn];
        table[0][0] = grid[0][0];
        for (int i = 1; i < rn; i++) {
            table[i][0] = table[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < cn; j++) {
            table[0][j] = table[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < rn; i++) {
            for (int j = 1; j < cn; j++) {
                int costLeft = table[i][j - 1] + grid[i][j];
                int costTop = table[i - 1][j] + grid[i][j];
                table[i][j] = Math.min(costLeft, costTop);
            }
        }
        return table[rn - 1][cn - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
