package algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] arr = {2,1,5,4};
        for (int num : arr) {
            pq.offer(num);
            if(pq.size() > 2)
                pq.poll();
        }
        System.out.println(pq);
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int[] arr1 = {1, 2, 3, 4};
        Comparator<Integer> cmp = (o1, o2) -> o2 - o1;
    }
}
