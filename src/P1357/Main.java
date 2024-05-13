package P1357;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < m; i++) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                arr[x - 1][y - 1] = Integer.MIN_VALUE;
            }
            int[] maxNum = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(dfs(arr, i, maxNum), max);
            }
            System.out.println(max);
        }
    }

    //dfs求的是不是count节点出发最长的食物链的长度
    public static int dfs(int[][] arr, int count, int[] maxNum) {
        int max = 0;
        if (maxNum[count] != 0) {
            return maxNum[count];
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[count][i] != 0) {
                max = Math.max(dfs(arr, i, maxNum), max);
            }
        }
        maxNum[count] = max + 1;
        return 1 + max;
    }
}
