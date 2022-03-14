package algorithm;

import java.util.Arrays;

public class HeapSort {
    public int[] sortArray(int[] nums) {
        buildHeap(nums);
        System.out.println( Arrays.toString(nums));
        int len = nums.length;
        for(int i = nums.length-1; i>0; i--){
            swap(nums, 0, i);
            len--;
            sink(nums, 0, len);
        }
        return nums;
    }

    private void buildHeap(int[] nums){
        int mid = nums.length/2;
        for(int i=mid; i>=0; i--){
            sink(nums, i, nums.length);
        }
    }

    private int getLeftChild(int idx){
        return idx*2+1;
    }

    private int getRightChild(int idx){
        return idx*2+2;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void sink(int[] nums, int idx, int len){
        while(getLeftChild(idx) <= len){
            int largestIdx = getLeftChild(idx);
            if(getRightChild(idx) < len && nums[largestIdx] < nums[getRightChild(idx)]){
                largestIdx = getRightChild(idx);
            }
            if(nums[idx] > nums[largestIdx]) break;
            swap(nums, idx, largestIdx);
            idx = largestIdx;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,1,1,2,0,0};
        HeapSort test = new HeapSort();
        System.out.println(Arrays.toString(test.sortArray(arr)));
    }
}
