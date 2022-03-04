package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class SlideWind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = 9;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            System.out.println(line);
            String[] strItems = line.split(" ");
            int sz = strItems.length;
            int[] arr = new int[sz];
            for (int i = 0; i < sz; i++) {
                arr[i] = Integer.parseInt(strItems[i]);
            }
            int left = 0, right = 0, sum = 0;
            int minLeft = 0, minRight = 0, minLen = Integer.MAX_VALUE;
            while (right < sz) {
                sum += arr[right];
                while (sum >= k) {
                    if(sum % k == 0){
                        int len = right - left + 1;
                        if (len < minLen) {
                            minLeft = left;
                            minRight = right;
                            minLen = len;
                        }
                    }
                    sum -= arr[left];
                    left++;
                }
                right++;
            }
            for(int i=minLeft; i< minRight; i++){
                System.out.printf("%d ", arr[i]);
            }
            System.out.println(arr[minRight]);
        }
    }
}
