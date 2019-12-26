package structure;

import java.util.List;

public class ListNode {
  public int val;
  public ListNode next = null;

  public ListNode(int val) {
    this.val = val;
  }

  //尾插法创建链表
  public void afterInsert(int index){
    if(index<5){
      ListNode newNode = new ListNode(index);
      next = newNode;
      newNode.afterInsert(++index);
    }
  }
}