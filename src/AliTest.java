import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//public class Main {
//
//}

public class AliTest {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[][] arr = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean flag = true;
                int sum = arr[i][0] + arr[j][0];
                for (int s = 1; s < k; s++) {
                    if (arr[i][s] + arr[j][s] != sum) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans++;
                    System.out.println(sum);
                }
            }
        }
        System.out.println(ans);
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        LinkedList<Integer> path = new LinkedList<>();
        backtrace(1, n, path, m);
    }

    private static void backtrace(int start, int n, LinkedList<Integer> path, int len) {
        if (path.size() == len) {
            for (int i = 0; i < len - 1; i++) {
                System.out.printf("%d ", path.get(i));
            }
            System.out.println(path.get(len - 1));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.addLast(i);
            backtrace(i + 1, n, path, len);
            path.removeLast();
        }
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int ans = 0, last = arr.length - 1;
            while (last > 2) {
                int plan1 = arr[0] * 2 + arr[last - 1] + arr[last];
                int plan2 = arr[0] + arr[1] * 2 + arr[last];
                ans += Math.min(plan1, plan2);
                last -= 2;
            }
            if (last == 2) {
                ans += (arr[0] + arr[1] + arr[2]);
            }
            if (last == 1) {
                ans += arr[1];
            }
            if (last == 0) {
                ans += arr[0];
            }
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), B = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
        double k = a*1.0/b;
        double leftx = k, rightx = k * B;
        if(rightx < 1 || leftx > A){
            System.out.println("0 0");
        }else{
            int x = (int) (A / k);
        }
    }
}
