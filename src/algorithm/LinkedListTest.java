package algorithm;

import dataStruct.ListNode;

public class LinkedListTest {
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        int n = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            n++;
        }
        if(n < k) return head;

        ListNode prev = null;
        ListNode cur = head;
        n = k;
        while(n-- > 0){
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        ListNode tail = prev;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = reverseKGroup(cur, k);
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.valueOf(new int[]{1, 2, 3, 4, 5});
        LinkedListTest test = new LinkedListTest();
        ListNode.printList(test.reverseKGroup(head, 3));
    }
}
