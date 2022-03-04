package algorithm;

public class MyAtoi {
    public int myAtoi(String s) {
        if(s == null || s.length() == 0)
            return 0;
        // 1. 去掉前导空格
        char[] arr = s.toCharArray();
        int sz = arr.length, i = 0;
        while(arr[i] == ' ') i++;
        // 2. 确定符号位
        long sum = 0L;
        int mark = 1;
        if(arr[i] == '-'){
            i++;
            mark = -1;
        }else if(arr[i] == '+'){
            i++;
        }
        // 3. 解析数位
        boolean start = false;
        while(i < sz){
            if(arr[i] <'0' || arr[i] >'9')
                break;
            if(!start && arr[i]=='0'){
                i++;
            }else{
                sum = sum * 10 + (arr[i]-'0');
                start = true;
                i++;
                // 3. 数值截断
                if(sum*mark >= Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }else if(sum*mark <= Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }
        }
        return (int)sum*mark;
    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        System.out.println(myAtoi.myAtoi("+0 32"));
    }
}
