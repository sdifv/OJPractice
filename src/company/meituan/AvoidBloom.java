package company.meituan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AvoidBloom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] rooms = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            rooms[i] = sc.nextInt();
        }
        int idx = 1, swapCnt = 0;
        int i = 2;
        while (i <= m) {
            while (rooms[i] != idx) i++;
            if (i <= m) {
                idx = nextRoom(rooms, idx, i, n);
                if (idx == -1){
                    swapCnt++;
                    break;
                }
                swapCnt++;
            }
        }
        System.out.println(swapCnt);
    }

    private static int nextRoom(int[] rooms, int idx, int i, int n) {
        Set<Integer> ids = new HashSet<>();
        for (int j = 1; j <= n; j++) {
            ids.add(j);
        }
        ids.remove(idx);
        while (i < rooms.length) {
            if (ids.size() == 1) {
                return ids.iterator().next();
            } else {
                ids.remove(rooms[i]);
            }
            i++;
        }
        return -1;

    }
}
