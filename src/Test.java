

import dataStruct.ListNode;
import dataStruct.TreeNode;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 1. 排序
        Arrays.sort(nums);
        // 2. 递归的解决
        return nSum(nums, 4, 0, target);
    }

    private List<List<Integer>> nSum(int[] nums, int n, int start, int target){
        int sz = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 3. 基本排除原则
        if(sz < n || n < 2){
            return res;
        }
        if(n == 2){
            int left = start, right = sz-1;
            while(left < right){
                int leftVal = nums[left], rightVal = nums[right];
                int sum = leftVal + rightVal;
                if(sum < target){
                    while(left<right && nums[left] == leftVal)  // 消除重复情况
                        left++;
                }else if(sum > target){
                    while(left<right && nums[right] == rightVal)
                        right--;
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(leftVal);
                    list.add(rightVal);
                    res.add(list);
                    while(left<right && nums[left] == leftVal) left++;
                    while(left<right && nums[right] == rightVal) right--;
                }
            }
            return res;
        }else{
            for(int i=start; i<sz-n; ){
                int num = nums[i];
                List<List<Integer>> curRes = nSum(nums, n - 1, i + 1, target - num);
                for (List<Integer> list : curRes) {
                    list.add(num);
                    res.add(list);
                }
                while(i<sz && nums[i] == num) i++;
            }
            return res;
        }
    }

    private List<List<Integer>> test(int[] arr, int target){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int sz = arr.length;
        for(int i=0; i<sz-3; ){
            int num1 = arr[i];
            for(int j=i+1; j<sz-2; ){
                int num2 = arr[j];
                for(int s=j+1; s<sz-1; ){
                    int num3 = arr[s];
                    for(int k=s+1; k<sz; ){
                        int num4 = arr[k];
                        if(num1+num2+num3+num4==target){
                            res.add(Arrays.asList(num1,num2,num3,num4));
                        }
                        while(k<sz && arr[k] == num4) k++;
                    }
                    while(s<sz-1 && arr[s] == num3) s++;
                }
                while(j<sz-2 && arr[j] == num2) j++;
            }
            while(i<sz-3 && arr[i] == num1) i++;
        }
        return res;
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null) return pHead;
        ListNode head = null;
        ListNode left = new ListNode(-1), right = pHead;
        while(right != null){
            ListNode cur = right;
            while(right.next != null && right.next.val == cur.val)
                right = right.next;
            if(cur == right){
                left.next = right;
                if(head == null){
                    head = left.next;
                }
                left = left.next;
                right = right.next;
            }else{
                right = right.next;
            }
        }
        left.next = right;
        return head;
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)
            return false;
        return verify(sequence, 0, sequence.length-1);
    }

    private boolean verify(int[] seq, int start ,int end){
        if(start >= end) return true;
        int mid = seq[end];
        int i=start;
        while(i <= end && seq[i] < mid) i++;
        for(int j=i; j<=end; j++){
            if(seq[j] < mid){
                return false;
            }
        }
        return verify(seq, start, i-1) && verify(seq, i, end-1);
    }

    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int expectNumber) {
        res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root, expectNumber, path);
        return res;
    }

    private void dfs(TreeNode root, int expect, ArrayList<Integer> path){
        if(expect == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(root.val);
        if(root.left != null){
            dfs(root.left, expect-root.val, path);
        }
        if(root.right != null){
            dfs(root.right, expect-root.val, path);
        }
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        Test test = new Test();
        long start = System.currentTimeMillis();
        Set<String> set = new HashSet<>();
//        test.VerifySquenceOfBST(new int[]{1,3,2});
        System.out.println(System.currentTimeMillis()-start);
    }
}