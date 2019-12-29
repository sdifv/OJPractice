import java.util.ArrayList;
/*
 * Q:输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * tag: 数组
 */
public class Solution19 {

  // 走的方向：向右、向下、向左、向上
  private final int[] dx = {0, 1, 0, -1};
  private final int[] dy = {1, 0, -1, 0};

  public static void main(String[] args) {
    Solution19 s = new Solution19();
    s.testPrintMatrix();
  }

  public ArrayList<Integer> printMatrix(int[][] matrix) {
    int r = matrix.length, c = matrix[0].length;
    boolean[][] vis = new boolean[r][c];
    ArrayList<Integer> res = new ArrayList<>();

    int x = 0, y = 0, dir = 0;
    while (x >= 0 && x < r && y >= 0 && y < c && !vis[x][y]) {
      res.add(matrix[x][y]);
      vis[x][y] = true;

      while (x + dx[dir] >= 0
          && x + dx[dir] < r
          && y + dy[dir] >= 0
          && y + dy[dir] < c
          && !vis[x + dx[dir]][y + dy[dir]]) {
        x += dx[dir];
        y += dy[dir];
        res.add(matrix[x][y]);
        vis[x][y] = true;
      }

      // 走不动了换方向
      dir = (dir + 1) % 4;
      x += dx[dir];
      y += dy[dir];
    }

    return res;
  }

  public void testPrintMatrix() {
    int[][] matrix = {{1, 2, 3, 4}, {3, 4, 5, 6}, {4, 5, 6, 7}, {7, 8, 9, 10}};
    ArrayList<Integer> res = printMatrix(matrix);
    for (Integer r : res) {
      System.out.print(r.toString()+' ');
    }
  }
}
