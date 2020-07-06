//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    char[][] board;
    String word;
    int rn, cn;

    public boolean exist(char[][] board, String word) {
        this.rn = board.length;
        this.cn = board[0].length;
        this.board = board;
        this.word = word;

        // 从方阵外开始搜索
        for (int i = -1; i < rn; i++) {
            for (int j = 0; j < cn; j++) {
                boolean[][] visited = new boolean[rn][cn];
                StringBuilder sb = new StringBuilder();
                if (backtrace(i, j, sb, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrace(int x, int y, StringBuilder sb, boolean[][] visited) {
        if (sb.toString().equals(word)) {
            return true;
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int m = x + dx[i];
            int n = y + dy[i];

            if (m >= 0 && m < rn && n >= 0 && n < cn) {
                if (!visited[m][n]) {
                    if (board[m][n] == word.charAt(sb.length())) {
                        sb.append(board[m][n]);
                        visited[m][n] = true;
                        if (!backtrace(m, n, sb, visited)) {
                            visited[m][n] = false;
                            sb.deleteCharAt(sb.length() - 1);
                        } else {
                            // 退出条件
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
