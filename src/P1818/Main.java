package P1818;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//饼干数量
        int q = scan.nextInt();//询问次数
        int[] w = new int[n];//饼干的饱腹感
        w[0] = scan.nextInt();
        for (int i = 1; i < n; i++) {
            w[i] = scan.nextInt();
            w[i] += w[i - 1];
        }
        int[] s = new int[q];
        for (int i = 0; i < q; i++) {
            s[i] = scan.nextInt();
            System.out.print(findNum(s[i], w) + 1 + " ");
        }
        scan.close();
    }

    //    public static int[] cumulativeArray(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            arr[i] += arr[i - 1];
//        }
//        return arr;
//    }
    public static int findMaxMin(int[] arr, int target) {
        int last = arr.length - 1;
        int fro = 0;
        int min = 0;
        int mid = 0;
        while (last >= fro) {
            mid = (last - fro) / 2 + fro;
            if (arr[mid] > target) {
                last = mid - 1;
            } else {
                fro = mid + 1;
                min = Math.max(min, arr[mid]);
            }
        }
        return min;
    }


    public static int findNum(int target, int[] w) {
        int last = w.length - 1;
        int fro = 0;
        int mid = (last + fro) / 2;
        while (last >= fro) {
            if (target <= w[mid]) {
                if (mid == 0 || w[mid - 1] < target) {
                    return mid;
                }
                last = mid - 1;
            } else {
                fro = mid + 1;
            }
            mid = (last + fro) / 2;
        }
        return -1;
    }
}
