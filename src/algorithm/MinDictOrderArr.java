package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinDictOrderArr {
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";
        // 优先队列默认是小根堆，最小的在前面
        // 自定义comparator => int compare(o1,o2),外比较
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> String.format("%d%d", a, b).compareTo(String.format("%d%d", b, a)));
        for (int num : nums) {
            pq.offer(num);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MinDictOrderArr minDictOrderArr = new MinDictOrderArr();
        System.out.println(minDictOrderArr.minNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
