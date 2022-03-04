package algorithm;

import javax.security.auth.callback.CallbackHandler;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Caculator {

    public int calculate1(String s) {
        char preSign = '+';
        int num = 0, len = s.length();
        Stack<Integer> st = new Stack<>();
        List<Character> opList = Arrays.asList('+', '-', '*', '/');
        for(int i=0; i<len; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            }
            if(opList.contains(c) || i == len-1){   // 最后一位也要处理剩余状态
                switch(preSign){
                    case '+':
                        st.push(num);
                        break;
                    case '-':
                        st.push(-num);
                        break;
                    case '*':
                        st.push(st.pop()*num);
                        break;
                    case '/':
                        st.push(st.pop()/num);
                        break;
                }
                num = 0;
                preSign = c;
            }
        }
        int res = 0;
        while(!st.isEmpty()){
            res += st.pop();
        }
        return res;
    }

    public int calculate(String s){
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            list.addLast(c);
        }
        return calculate(list);
    }

    public int calculate(LinkedList<Character> list) {
        int num =0;
        char preSign = '+';
        Stack<Integer> st = new Stack<>();
        List<Character> opList = Arrays.asList('+', '-', '*', '/');

        while(list.size() > 0) {
            char c = list.pollFirst();
            if (c == '(') {
                num = calculate(list);
            }

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || list.isEmpty()) {   // 最后一位也要处理剩余状态
                switch (preSign) {
                    case '+':
                        st.push(num);
                        break;
                    case '-':
                        st.push(-num);
                        break;
                    case '*':
                        st.push(st.pop() * num);
                        break;
                    case '/':
                        st.push(st.pop() / num);
                        break;
                }
                num = 0;
                preSign = c;
            }
            if (c == ')') {
                break;
            }
        }
        int res = 0;
        while (!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Caculator caculator = new Caculator();
        System.out.println(caculator.calculate("1 + ((5 /2+3) - 2)"));
    }
}
