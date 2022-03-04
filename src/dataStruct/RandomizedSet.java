package dataStruct;

import java.util.*;

public class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> data;
    private Random random;

    public RandomizedSet() {
        this.data = new ArrayList<>();
        this.map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        int flag = this.map.getOrDefault(val, -1);
        if (flag != -1) return false;
        this.data.add(val);
        this.map.put(val, this.data.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        int flag = this.map.getOrDefault(val, -1);
        if (flag == -1) return false;
        int idx = this.map.get(val);
        int size = this.data.size();
        int tail = this.data.get(size-1);
        this.data.set(idx, tail);
        this.map.put(tail, idx);
        this.data.remove(size - 1);
        this.map.remove(val);
        return true;
    }

    public int getRandom() {
        int idx = this.random.nextInt(this.data.size());
        return this.data.get(idx);
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(0));
        System.out.println(rs.insert(1));
        System.out.println(rs.remove(0));
        System.out.println(rs.insert(2));
        System.out.println(rs.remove(1));
        System.out.println(rs.getRandom());
    }
}
