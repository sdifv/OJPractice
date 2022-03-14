package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LURSubstr {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        char[] arr = s.toCharArray();
        int left = 0, right = 0;
        int maxLen = 1, sz = arr.length;
        Set<Character> set = new HashSet<>();
        while(right < sz){
            if(!set.contains(arr[right])){
                set.add(arr[right]);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            }else{
                while(set.contains(arr[right])){
                    set.remove(arr[left]);
                    left++;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LURSubstr lurSubstr = new LURSubstr();
        System.out.println(lurSubstr.lengthOfLongestSubstring("abcabcbb"));
    }
}
