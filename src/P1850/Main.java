package P1850;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] high = new int[n];
        int[] left = new int[n];//记录左边比i位置大的数的个数
        int[] right = new int[n];//记录右边比i位置大的数的个数
        for (int i = 0; i < n; i++) {
            high[i] = scan.nextInt();
            int max = 0;
            for (int j = 1; j <= i; j++) {
                if (high[i] > high[i - j]) {
                    max = Math.max(left[i - j] + 1, max);
                }
            }
            left[i] = max;
        }
       // System.out.println(Arrays.toString(left));
        for (int i = n - 1; i >= 0; i--) {
            int max = 0;
            for (int j = 1; j <= n - i - 1; j++) {
                if (high[i] > high[i + j]) {
                    max = Math.max(right[i + j] + 1, max);
                }
            }
            right[i] = max;
        }
       // System.out.println(Arrays.toString(right));
        int max = 0;
        for (int i = 0; i < n; i++) {
                max = Math.max(max, right[i] + left[i]);
        }
       // System.out.println(max);
        System.out.println(n - max - 1);
    }
}
