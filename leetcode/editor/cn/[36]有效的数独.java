//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.Arrays;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // board is a 9*9 grid
        // rows[x][y] == 1: the xth row in board has appeared number y;
        byte[][] rows = new byte[9][10];
        // cols[x][y] == 1: the xth col in board has appeard number y;
        byte[][] cols = new byte[9][10];
        // subgrid[x] == 1: the number x has appeared number x;
        byte[] subgrid = new byte[10];

        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                for(int x=0;x<3;x++){
                    for(int y=0;y<3;y++){
                        char value = board[i+x][j+y];
                        if(value!='.'){
                            int num = value - '0';
                            if(rows[i+x][num] == 1){
                                return false;
                            }
                            rows[i+x][num] = 1;
                            if(cols[j+y][num] == 1){
                                return false;
                            }
                            cols[j+y][num] = 1;
                            if(subgrid[num] == 1){
                                return false;
                            }
                            subgrid[num] = 1;
                        }else{
                            continue;
                        }
                    }
                }
                Arrays.fill(subgrid, (byte) 0);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
