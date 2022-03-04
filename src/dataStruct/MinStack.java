package dataStruct;

import java.util.ArrayList;
import java.util.List;

class MinStack {
    int size;
    List<Integer> data;
    List<Integer> minVar;

    public MinStack() {
        this.data = new ArrayList<>();
        this.minVar = new ArrayList<>();
        this.size = 0;
    }

    public void push(int val) {
        this.data.add(val);
        if(this.minVar.isEmpty()){
            this.minVar.add(val);
        }else{
            this.minVar.add(Math.min(this.minVar.get(this.size-1), val));
        }
        this.size++;
    }

    public void pop() {
        this.data.remove(this.size-1);
        this.minVar.remove(this.size-1);
        this.size--;
    }

    public int top() {
        return this.data.get(this.size-1);
    }

    public int getMin() {
        return this.minVar.get(this.size-1);
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(-2);
        ms.push(-3);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
