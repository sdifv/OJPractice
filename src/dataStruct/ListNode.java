package dataStruct;

//Definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode valueOf(int[] arr){
        ListNode pre = null, head = null;
        for(int i: arr){
            ListNode node = new ListNode(i);
            if(head == null){
                head = node;
            }else{
                pre.next = node;
            }
            pre = node;
        }
        return head;
    }

    public static void printList(ListNode head){
        StringBuilder sb = new StringBuilder();
        while(head != null){
            sb.append(head.val).append("->");
            head = head.next;
        }
        sb.append("NULL");
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
