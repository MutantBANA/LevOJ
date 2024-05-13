package P1851;

import org.junit.Test;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int z = scan.nextInt();
        int n = scan.nextInt();//询问次数
        HashMap<Integer, Integer> map = setMap(x, y, z);
        for (int i = 0; i < n; i++) {
            int count = scan.nextInt();
            if (map.containsKey(count)) {
                System.out.println(map.get(count));
            } else
                System.out.println(-1);
        }
    }

    public static HashMap<Integer, Integer> setMap(int x, int y, int z) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(x, 0);
        map.put(y, 1);
        for (int i = 2; i < z;) {
//            if (!map.containsKey(x + y)) {
//                map.put(x + y, i);
//                int flag = x;
//                x = y;
//                y = flag + y;
//            }
            map.put(x + y, i);
                int flag = x;
                x = y;
                y = flag + y;
                i = i*2;
        }
        return map;
    }

    @Test
    public void test() {
        int x = 1;
        int y = 14;
        int[] arr = new int[200];
        arr[0] = 1;
        arr[1] = 14;
        System.out.println(0 + " " + arr[0]);
        System.out.println(1 + " " + arr[1]);
        for (int i = 2; i < 200; i++) {
            arr[i] = arr[i / 2] + arr[i / 4];
            System.out.println(i + " " + arr[i]);
        }
    }
}
