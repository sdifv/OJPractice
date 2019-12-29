import structure.ListNode;
import java.util.ArrayList;
import java.util.Iterator;
/*
 * Q: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 * tag: 链表
 */
public class Solution3 {
  public static void main(String[] args) {
    Solution3 s = new Solution3();
    s.testPrintListFromTailToHead();
  }

  public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

    ArrayList<Integer> res = new ArrayList<>();

    if (listNode == null) {
      return res;
    }

    ListNode pre = null;
    ListNode next = null;

    while (listNode != null) {
      next = listNode.next;
      listNode.next = pre;
      pre = listNode;
      listNode = next;
    }

    while (pre != null) {
      res.add(pre.val);
      pre = pre.next;
    }

    return res;
  }

  public void testPrintListFromTailToHead() {
    ListNode testList = new ListNode(0);
    testList.afterInsert(1);

    ArrayList<Integer> res = printListFromTailToHead(testList);
    Iterator<Integer> it = res.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }
}
