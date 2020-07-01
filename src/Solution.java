class Solution {
    public boolean canJump(int[] nums) {
        if(nums[0] == 0 && nums.length>1){
            return false;
        }
        int count = 0;
        for (int i = 0; i <nums.length-1 ; i++) {
            if(nums[i]==0){
                count++;
                for(int j=0;j<i;j++){
                    if(nums[j] >= i-j+1){
                        count--;
                        break;
                    }
                }
            }
        }
        if(count == 0){
            return true;
        }
        return false;
    }
}