import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main5 {
    static class Loc {
        public int op;
        public int step;
        public int ops;
        public int x;

        public Loc(int x, int op, int step, int ops) {
            this.x = x;
            this.op = op;
            this.step = step;
            this.ops = ops;
        }

        public Loc jump() {
            x = x + op*step;
            op = op * -1;
            step = step * 2;
            ops++;
            return new Loc(x, op, step, ops);
        }

        public Loc reset() {
            op = 1;
            step = 1;
            ops++;
            return new Loc(x, op, step, ops);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int t = sc.nextInt();
        int[] table = new int[200001];
        for(int i =0;i< table.length;i++){
            table[i] = Integer.MAX_VALUE;
        }
        Queue<Loc> queue = new ArrayDeque<>();
        queue.add(new Loc(s, 1, 1, 0));
        while(!queue.isEmpty()){
            Loc loc = queue.poll();
            if(loc.x >= t){
                break;
            }else{
                Loc jump = loc.jump();
                if(jump.ops <= table[jump.x]){
                    table[jump.x] = jump.ops;
                    queue.add(jump);
                }
                Loc reset = loc.reset();
                if(reset.ops<=table[reset.x]){
                    table[reset.x] = reset.ops;
                    queue.add(reset);
                }
            }
        }
        System.out.println(table[t]);
    }
}
