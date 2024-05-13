package P1204;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            double sum = 0;
            int max= 0;
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
                sum += arr[i];
                max = Math.max(max,arr[i]);
            }

            if (arr[n - 1] > sum / 2) {
                System.out.println(sum - arr[n - 1]);
            } else {
                System.out.println(sum / 2);
            }
        }
    }
}
