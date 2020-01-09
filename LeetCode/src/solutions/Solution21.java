package solutions;

import java.util.ArrayList;
/*
 * Q：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序
 * 列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度
 * 是相等的）
 * tag: 栈
 */
public class Solution21 {
  public static void main(String[] args) {
    Solution21 s = new Solution21();
    s.testIsPopOrder();
  }

  public boolean IsPopOrder(int[] pushA, int[] popA) {
    if (pushA.length == 0) {
      return false;
    }
    ArrayList<Integer> stack = new ArrayList<>();

    for (int i = 0, j = 0; i < pushA.length; ) {
      stack.add(pushA[i++]);
      while (j < popA.length && stack.get(stack.size() - 1) == popA[j]) {   //栈顶元素刚好和符合出栈条件
        stack.remove(stack.size() - 1);
        j++;
      }
    }

    return stack.isEmpty();
  }

  public void testIsPopOrder() {
    int[] pushA = {1, 2, 3, 4, 5}, popA = {4, 3, 5, 1, 2};
    System.out.println(IsPopOrder(pushA, popA));
  }
}
