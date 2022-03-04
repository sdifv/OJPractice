package company.meituan;

import java.util.Scanner;

public class UserName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            String line = sc.next();
            if(check(line)){
                System.out.println("Accept");
            }else{
                System.out.println("Wrong");
            }
        }
    }

    private static boolean check(String line) {
        boolean hasLetter = false;
        boolean hasNumber = false;
        char[] arr = line.toCharArray();
        // 1. 检查首字符是否是字母
        if(Character.isLetter(arr[0])){
            hasLetter = true;
            for (char c : arr) {
                if(Character.isDigit(c)){
                    hasNumber = true;
                }else if(!Character.isLetter(c)){
                    return false;
                }
            }
        }
        return hasLetter && hasNumber;
    }
}
