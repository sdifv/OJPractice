package algorithm;

import java.util.Arrays;

public class JieYuShui {
    public int trap(int[] height) {
        int sz = height.length;
        int[] left = new int[sz];
        int[] right = new int[sz];
        for(int i=1; i<sz; i++){
            // i坐标左边最高的柱子高度
            left[i] = Math.max(left[i-1], height[i-1]);
        }
        for(int i=sz-2; i>=0; i--){
            // i坐标右边最高的柱子高度
            right[i] = Math.max(right[i+1], height[i+1]);
        }
        int ans = 0;
        for(int i=1; i<sz-1; i++){
            int boundHeight = Math.min(left[i], right[i]);
            ans += (boundHeight > height[i]) ? boundHeight - height[i] : 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        JieYuShui test = new JieYuShui();
        System.out.println(test.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
