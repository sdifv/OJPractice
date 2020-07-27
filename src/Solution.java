import java.util.Arrays;

class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int imin = 1, imax = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            res = Math.max(imax, res);
        }
        return res;
    }
}
