package algorithm;

import dataStruct.ListNode;

import java.util.concurrent.locks.ReentrantLock;

public class ReverseKList {
    ListNode successor = null;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-555);
        dummy.next = head;
        ListNode prev = dummy;
        int n = left;
        while (--n > 0) {
            prev = prev.next;
        }
        ListNode rHead = reverse(prev.next, right - left + 1);
        prev.next = rHead;
        ListNode tail = rHead;
        while (tail.next != null) tail = tail.next;
        tail.next = successor;
        return dummy.next;
    }

    private ListNode reverse(ListNode head, int n) {
        ListNode prev = null;
        while (n-- > 0) {
            ListNode curNext = head.next;
            head.next = prev;
            prev = head;
            head = curNext;
        }
        successor = head;
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.valueOf(new int[]{1, 2, 3, 4, 5});
        ReverseKList rlist = new ReverseKList();
        ListNode newHead = rlist.reverseBetween(head, 2, 4);
        ListNode.printList(head);
    }
}
