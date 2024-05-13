package P1971;

import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int X = scan.nextInt();
//        int N = scan.nextInt();
//        int[] monster = new int[N];
//        for (int i = 0; i < N; i++) {
//            monster[i] = scan.nextInt();
//        }
//        int[] num = calculatedDamage(X);
//        int[] count = new int[N];
//        calculatedBits(num);
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < num.length; j++) {
//                if (compare(monster[i], num[j]) < 0) {
//                    count[i] = j;
//                    break;
//                }
//            }
//        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(count[i]);
//        }
//    }
//
//    public static int compare(int x, int y) {
//        return x - y;
//    }
//
//    public static int[] calculatedDamage(int X) {
//        int[] num = new int[10000];
//        num[0] = X;
//        for (int i = 1; i < 100; i++) {
//            if (i % 2 == 0) {
//                num[i] = num[i - 1] * i * X;
//            } else num[i] = num[i - 1] * X;
//        }
//        return num;
//    }
//
//    public static int[] calculatedBits(int[] num) {
//        for (int i = 0; i < num.length; i++) {
//            int flag = 0;
//            while (num[i] != 0) {
//                flag++;
//                num[i] /= 10;
//            }
//            num[i] = flag;
//        }
//        return num;
//    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int X = scan.nextInt();
        int N = scan.nextInt();
        double[] arr = calculateArr();
        for (int i = 0; i < N; i++) {
            int monster = scan.nextInt();
            int res = findLeftMax(arr, monster, X);
            System.out.println(res);
        }
        scan.close();
    }

    public static double[] calculateArr() {
        double[] arr = new double[200001];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + Math.log10(2 * i);
        }
        return arr;
    }

    public static int findLeftMax(double[] arr, int monster, int x) {
        int right = arr.length * 2;
        int left = 0;
        int min = right;
        while (left <= right) {
            int mid = (left - right) / 2 + right;
            double count = arr[mid / 2] + (mid + 1) * Math.log10(x);
            if (count >= monster) {
                min = Math.min(min, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }
}
