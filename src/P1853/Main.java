package P1853;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();//初始魔法值
        int S = scan.nextInt();//初始位置和终点的距离
        int T = scan.nextInt();//岛沉没的时间
        countTime(M, S, T);
    }

    public static void countTime(int M, int S, int T) {
        int max1 = 0;
        int max2 = 0;
        for (int i = 1; i <= T; i++) {
            if (M >= 10) {
                max2 += 60;
                M -= 10;
            } else {
                M += 4;
            }
            max1 = Math.max(max2, max1 + 17);
            if (max1 >= S) {
                System.out.println("Yes");
                System.out.println(i);
                return;
            }
        }
        System.out.println("No");
        System.out.println(max1);
    }
}
