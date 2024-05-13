package B4809;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: Main
 * Package: B4809
 * Description:
 *
 * @Author Benanalana
 * @Create 2024/3/4 15:30
 * @Version 1.0
 */
public class Main {
    static class Gold implements Comparable<Gold> {
        public double weight;
        public double cost;

        public Gold() {
        }

        public Gold(double x, double y) {
            this.weight = x;
            this.cost = y;
        }

        public int compareTo(Gold n) {
            return (int) (n.cost - cost);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int T = scan.nextInt();//背包大小
        int num = 0;
        Gold[] arr = new Gold[N];

        for (int i = 0; i < N; i++) {
            double x = scan.nextDouble();
            arr[i] = new Gold();
            arr[i].cost = scan.nextDouble() / x;
            arr[i].weight = x;
        }
        Arrays.sort(arr);
        num = money(arr, T, N);
        System.out.println(num);
    }

    public static int money(Gold[] arr, int T, int N) {
        int max = 0;
        for (int i = 0; i < N && T != 0; i++) {

            if (T >= arr[i].weight) {
                T -= arr[i].weight;
                max += arr[i].weight * arr[i].cost;
            } else {
                max += arr[i].cost * T;
                T = 0;
            }
        }
        return max;
    }
}
