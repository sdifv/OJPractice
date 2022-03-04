package algorithm;

public class Test {
    public int findNthDigit (int n) {
        // write code here
        // 0
        // 1 ~ 9      | digit = 1 start = 1 * 1       count = 1 * 9 * 1
        // 10 ~ 99    | digit = 2 start = 1 * 10      count = 10 * 9 * 2
        // 100 ~ 999  | digit = 3 start = 1 * 10 * 10 count = 100 * 9 * 3
        if (n <= 0) return 0;
        long start = 1, digit = 1, count = 9;
        while (n > count) {
            n -= count; // 减去当前位数的总长度
            start *= 10;
            digit += 1;
            count = start * 9 * digit;
        }
        // 找到当前位数的区间了
        String num = (start + (n - 1) / digit) + ""; // 减去第0号元素0
        int idx = (int)((n - 1) % digit);
        return Integer.parseInt(num.charAt(idx) + "");
    }

    public int NumberOf1(int n) {
        int base = 1;
        int ans = 0;
        while(n != 0){
            if((n & base) == 1){
                ans++;
            }
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.findNthDigit(10));
    }
}