package algorithm;

import java.util.Arrays;

public class HeapSort {
    public int[] sortArray(int[] nums) {
        buildHeap(nums);
        int len = nums.length;
        for(int i = nums.length-1; i>0; i--){
            swap(nums, 0, i);
            len--;
            heapify(nums, 0, len);
        }
        return nums;
    }

    private void buildHeap(int[] nums){
        int mid = nums.length/2;
        for(int i=mid; i>=0; i--){
            heapify(nums, i, nums.length);
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

    private void heapify(int[] nums, int idx, int len){
        int largetIdx = idx;
        if(getLeftChild(idx) < len && nums[getLeftChild(idx)] > nums[largetIdx]){
            largetIdx = getLeftChild(idx);
        }
        if(getRightChild(idx) < len && nums[largetIdx] < nums[getRightChild(idx)]){
            largetIdx = getRightChild(idx);
        }
        if(largetIdx != idx){
            swap(nums, idx, largetIdx);
            heapify(nums, largetIdx, len);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,1,1,2,0,0};
        HeapSort test = new HeapSort();
        System.out.println(Arrays.toString(test.sortArray(arr)));
    }
}
