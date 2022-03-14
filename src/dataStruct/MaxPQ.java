package dataStruct;

import java.util.Arrays;

public class MaxPQ<T extends Comparable<T>> {
    private int size;
    private T[] data;

    public MaxPQ(int cap) {
        data = (T[]) new Comparable[cap + 1];
        size = 0;
    }

    public T max() {
        return data[1];
    }

    public void insert(T item) {
        size++;
        if (size >= data.length) {
            throw new RuntimeException("the priority queue is full");
        }
        data[size] = item;
        swim(size);
    }

    private void swim(int i) {
        while (i > 1 && less(i, getParent(i))) {
            swap(i, getParent(i));
            i = getParent(i);
        }
    }

    private void swap(int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public T delMax() {
        T maxVal = data[1];
        swap(1, size);
        data[size] = null;
        size--;
        sink(1);
        return maxVal;
    }

    private void sink(int i) {
        while (getLeft(i) <= size) {
            int idx = getLeft(i);
            if (getRight(i) <= size && less(getRight(i), idx)) {
                idx = getRight(i);
            }
            if(less(i, idx)) break;
            swap(i, idx);
            i = idx;
        }
    }

    private boolean less(int i, int j) {
        return data[i].compareTo(data[j]) < 0;
    }

    private int getParent(int i) {
        return i / 2;
    }

    private int getLeft(int i) {
        return 2 * i;
    }

    private int getRight(int i) {
        return 2 * i + 1;
    }

    public T[] data(){
        return data;
    }

    public static void main(String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<>(10);
        pq.insert(4);
        pq.insert(3);
        pq.insert(6);
        pq.insert(7);
        System.out.println(Arrays.toString(pq.data()));
    }
}
