package P1477;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N =scan.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0]= scan.nextInt();
            arr[i][1] = scan.nextInt()/arr[i][0];
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
     int T = scan.nextInt();
    }
    public static int MaxMoney(int[][] arr)
    {
        int max = Integer.MIN_VALUE;

        return max;
    }

}
