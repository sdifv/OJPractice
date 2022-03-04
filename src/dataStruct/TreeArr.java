package dataStruct;

public class TreeArr {
    int[] arr;
    int[] farr;
    int[] darr;

    public TreeArr(int[] arr) {
        this.arr = arr;
        this.build();
    }

    private void build() {
        farr = new int[arr.length + 1];
        for (int i = 1; i < arr.length; i++) {
            updateArr(this.farr, i, arr[i]);
            updateArr(this.darr, i, arr[i] - arr[i - 1]);
        }
    }

    private int lowbit(int x) {
        return x & (-x);
    }

    public int query(int idx) {
        int res = 0;
        while (idx > 0) {
            res += farr[idx];
            idx -= lowbit(idx);
        }
        return res;
    }

    public int intervalQuery(int begin, int end) {
        return query(end) - query(begin - 1);
    }

    public void updateArr(int[] data, int idx, int val) {
        while (idx < arr.length) {
            data[idx] += val;
            idx += lowbit(idx);
        }
    }

    public void update(int idx, int val){
        this.updateArr(this.farr, idx, val);
    }

    public void intervalUpdate(int begin, int end, int val) {
        this.updateArr(this.darr, begin, val);
        this.updateArr(this.darr, end+1, -val);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 3, 2, 4, 5, 6};
        TreeArr treeArr = new TreeArr(arr);
        System.out.println(treeArr.query(5));
        treeArr.update(2, 2);
        System.out.println(treeArr.query(5));
        System.out.println(treeArr.intervalQuery(2, 5));
    }
}
