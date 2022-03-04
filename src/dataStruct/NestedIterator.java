package dataStruct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> flatList;
    private int idx;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.idx = 0;
        this.flatList = new ArrayList<>();
        flat(nestedList);
    }

    private void flat(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if(nestedInteger.isInteger()){
                flatList.add(nestedInteger.getInteger());
            }else{
                flat(nestedInteger.getList());
            }

        }
    }

    @Override
    public Integer next() {
        return flatList.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx < flatList.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */