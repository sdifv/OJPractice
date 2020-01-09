package solutions;

import structure.RandomListNode;

import java.util.HashMap;
import java.util.Map;


public class Solution25 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        Map<RandomListNode,RandomListNode> map = new HashMap<>();

        RandomListNode p1 = pHead;
        RandomListNode p2 = pHead;
        //创建新旧链表的映射关系
        while(p1 != null){
            map.put(p1,new RandomListNode(p1.label));
            p1 = p1.next;
        }
        //根据旧链表的next和random关系来更新新链表的next和random
        while(p2 != null){
            if(p2.next != null){
                map.get(p2).next = map.get(p2.next);
            }else{
                map.get(p2).next = null;
            }
            map.get(p2).random = map.get(p2.random);
            p2 = p2.next;
        }
        return map.get(pHead);
    }
}
