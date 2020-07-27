//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表 
// 👍 643 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode root = new ListNode(head.val);
        while(head.next!=null){
            ListNode next = head.next;
            // 有序插入给定链表的节点，返回新链表的头
            root = seqInsert(root, new ListNode(next.val));
            head = next;
        }
        return root;
    }

    public ListNode seqInsert(ListNode root, ListNode node){
        if(root.val>=node.val){
            node.next = root;
            return node;
        }else {
            ListNode pre = root;
            ListNode next = pre.next;

            while(next!=null){
                if(pre.val<node.val && next.val>=node.val){
                    // 找到插入点，将node插到pre和next之间
                    pre.next = node;
                    node.next = next;
                    return root;
                }else{ // pre和next节点的值均小于node,指针后移
                    pre = next;
                    next = pre.next;
                }
            }
            // 遍历所有节点，此时pre指向尾节点，还未插入node，则插到最后
            pre.next = node;
            return root;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
