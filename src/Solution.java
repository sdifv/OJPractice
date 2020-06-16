import java.util.Arrays;

class Solution {
  public void nextPermutation(int[] nums) {
    boolean change = false;

    int i = nums.length - 1;
    while (i > 0) {

      if (nums[i] > nums[i - 1]) {
        change = true;

        int target = Integer.MAX_VALUE;
        int index = -1;
        for(int j=i; j<nums.length; j++){
          if(nums[j]>nums[i-1] & nums[j]<target){
            target = nums[j];
            index = j;
          }
        }

        int temp = nums[i - 1];
        nums[i - 1] = target;
        nums[index] = temp;

        Arrays.sort(nums, i, nums.length);

        break;
      }
      i--;
    }
    if (!change) {
      Arrays.sort(nums);
    }
  }
}
