//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String multiply(String num1, String num2) {

        if(num1.equals("0") | num2.equals("0")){
            return "0";
        }
        List<int[]> resList = new ArrayList<>();

        for (int i = num1.length()-1; i >= 0 ; i--) {   // 乘数
            int x = num1.charAt(i) - '0';
            int[] res = new int[num2.length()];
            for (int j = num2.length()-1; j >= 0 ; j--) {   // 被乘数
                int y = num2.charAt(j) - '0';
                res[j] = x*y;
            }
            resList.add(res);   // 保存每一轮的乘积数组
        }

        // 将每一轮的乘积数组按位相加
        List<Integer> ansList = new ArrayList<>();
        for(int i=0; i<num1.length()+num2.length()-1; i++){
            int sum = 0;
            boolean flag = false;
            for(int j=0; j<resList.size(); j++){
                int[] arr = resList.get(j);
                int index = arr.length-(i-j)-1; // 第j个乘积数组中参与累加的元素下标
                if(index>=0 & index<arr.length){
                    sum += arr[index];
                    flag = true;
                }
            }
            if(flag){
                ansList.add(sum);
            }
        }
//        System.out.println(ansList);
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<ansList.size(); i++){
            int var = ansList.get(i);
            int x = var%10;
            sb.append(x);
            if(var/10!=0){
                if(i==ansList.size()-1){
                    ansList.add(var/10);
                }else{
                    ansList.set(i+1, ansList.get(i+1)+var/10);
                }
            }
        }
        return sb.reverse().toString();
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        String num1 = "0";
//        String num2 = "234563";
//        String res = s.multiply(num1,num2);
//        System.out.println(res);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
