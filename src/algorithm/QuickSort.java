package algorithm;

import java.util.Arrays;

public class QuickSort {
    private static void sort(int[] nums, int left, int right) {
        if (left < right) {
            int x = nums[left];
            int i = left, j = right;
            while (i < j) {
                while (i < j && nums[j] > x) j--;
                if (i < j) nums[i++] = nums[j];
                while (i < j && nums[i] < x) i++;
                if (i < j) nums[j--] = nums[i];
            }
            nums[i] = x;
            sort(nums, left, i - 1);
            sort(nums, i + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 3, 8, 7, 4, 1};
        sort(arr, 0, 6);
        System.out.println(Arrays.toString(arr));
    }
}
