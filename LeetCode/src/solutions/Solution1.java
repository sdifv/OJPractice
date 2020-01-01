package solutions;

/*
 * Q: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整
 * 数，判断数组中是否含有该整数。
 * tag: 查找，数组
 */
public class Solution1 {
  public static void main(String[] args) {
    Solution1 s = new Solution1();
    s.testFind();
  }

  public boolean Find(int target, int[][] array) {
    int r = array.length;
    int c = array[0].length;
    System.out.printf("r=%d,c=%d%n", r, c);

    if (c == 0) { // 数组为空
      return false;
    } else if (array[0][0] > target | array[r - 1][c - 1] < target) { // target越界
      return false;
    }

    for (int i = 0; i < r; i++) { // 找出r的上界
      if (array[i][0] > target) {
        r = i;
        break;
      }
    }

    for (int j = 0; j < c; j++) { // 找出c的上界
      if (array[0][j] > target) {
        c = j;
        break;
      }
    }

    for (int i = r - 1; i >= 0; i--) { // 在缩小的范围内反向遍历,加速查找
      for (int j = c - 1; j >= 0; j--) {
        if (array[i][j] == target) {
          return true;
        }
      }
    }
    return false;
  }

  public void testFind() {
    int[][] array1 = {{1, 2, 8, 9}, {4, 7, 10, 13}};
    int[][] array2 = {{}};
    int target = 7;
    if (Find(target, array2)) {
      System.out.println("Right!");
    } else {
      System.out.println("Wrong!");
    }
  }
}
