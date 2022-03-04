package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3)
            return ans;
        Arrays.sort(nums);
        int sz = nums.length;
        int i1 = 0;
        while (i1 < sz) {
            int target = -nums[i1];
            int i2 = i1 + 1, i3 = sz - 1;
            while (i2 < i3) {
                int temp = nums[i2] + nums[i3];
                if (temp < target) {
                    while (i2 + 1 < sz && nums[i2] == nums[i2 + 1]) i2++;
                    i2++;
                } else if (temp > target) {
                    while (i3 - 1 >= 0 && nums[i3] == nums[i3 - 1]) i3--;
                    i3--;
                } else {
                    ans.add(Arrays.asList(nums[i1], nums[i2], nums[i3]));
                    while (i2 + 1 < sz && nums[i2] == nums[i2 + 1]) i2++;
                    while (i3 - 1 >= 0 && nums[i3] == nums[i3 - 1]) i3--;
                    i2++;
                    i3--;
                }
            }
            while (i1 + 1 < sz && nums[i1] == nums[i1 + 1]) i1++;
            i1++;
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

}
