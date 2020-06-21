//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                int start = binaryExpandLeft(nums, left, mid - 1, target);
                int end = binaryExpandRight(nums, mid + 1, right, target);
                return new int[]{start, end};
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public int binaryExpandLeft(int[] nums, int left, int right, int target) {
        while(left<=right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    public int binaryExpandRight(int[] nums, int left, int right, int target) {
        while(left<=right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
