package codetop.tencent;

public class LongRepeatArr {
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        LongRepeatArr test = new LongRepeatArr();
        System.out.println(test.findLength(new int[]{0, 1, 1, 1, 1}, new int[]{1, 0, 1, 0, 1}));
    }
}
