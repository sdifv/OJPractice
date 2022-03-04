package algorithm;

import java.util.HashMap;
import java.util.Map;

public class ConsequentSubArr {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sz = nums.length;
        if(sz < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int[] sum = new int[sz];
        for(int i=0; i<sz; i++){
            if(i == 0){
                sum[i] = nums[i];
            }else{
                sum[i] = sum[i-1] + nums[i];
            }
            int r = sum[i] % k;
            if(map.containsKey(r)){
               if(Math.abs(i - map.get(r)) >= 2)
                   return true;
            }else{
                map.put(r, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ConsequentSubArr test = new ConsequentSubArr();
        System.out.println(test.checkSubarraySum(new int[]{5,0,0,0}, 3));
    }
}
