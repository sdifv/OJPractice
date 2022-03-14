package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIp {
    List<String> ans;
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        if(s.length() < 4) return ans;
        char[] arr = s.toCharArray();
        LinkedList<Integer> ip = new LinkedList<>();
        backtrace(arr, 0,0, ip);
        return ans;
    }

    private void backtrace(char[] arr, int idx, int num, LinkedList<Integer> ip) {
        if(ip.size() == 4){
            if(idx == arr.length){
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 3; j++) {
                    sb.append(ip.get(j)).append(".");
                }
                sb.append(ip.get(3));
                ans.add(sb.toString());
                return;
            }else{
                return;
            }
        }

        for(int i=idx; i<arr.length && i<idx+3; i++){
            num = num*10 + (arr[i]-'0');
            if(num>=0 && num<=255){
                ip.addLast(num);
                backtrace(arr, i+1, 0, ip);
                ip.removeLast();
            }
            if(num == 0) break;
        }
    }

    public static void main(String[] args) {
        RestoreIp ri = new RestoreIp();
        System.out.println(ri.restoreIpAddresses("101023"));
    }
}
