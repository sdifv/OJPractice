import dataStruct.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        Set<ListNode> visited = new HashSet<>();
        visited.add(head);
        while(head.next != null){
            ListNode next = head.next;
            if(visited.contains(next)){
                return next;
            }
            visited.add(next);
            head = next;
        }
        return null;
    }
}