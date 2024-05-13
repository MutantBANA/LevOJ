package P1748;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t != 0) {
            int n = scan.nextInt();
            int[][] arr = new int[n][4];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = scan.nextInt();
                }
            }
            int[] addArr = add(arr);
            int temp = 0;
            int target = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    target = arr[i][2] + arr[j][3];
                    temp += binarySearch(addArr, -target);
                }
            }
            System.out.println(temp);
            t--;
        }
        scan.close();
    }

    public static int[] add(int[][] arr) {
        int[] addArr = new int[arr.length * arr.length];
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                addArr[temp++] = arr[i][0] + arr[j][1];
            }
        }
        Arrays.sort(addArr);
        return addArr;
    }

    public static int binarySearch(int[] arr, int target) {
        int temp = 0;
        int last = arr.length - 1;
        int fro = 0;
        int i = 0;
        while (last >= fro) {
            i = (last - fro) / 2 + fro;
            if (arr[i] > target) {
                last = i - 1;
            } else if (arr[i] < target) {
                fro = i + 1;
            } else {
                temp++;
                int x = i;
                while (i + 1 < arr.length && arr[++i] == target)
                    temp++;
                while (x - 1 >= 0 && arr[--x] == target)
                    temp++;
                break;
            }
        }
        return temp;
    }

    public static int find(int[] arr, int target) {
        int last = arr.length - 1;
        int fro = 0;
        int mid = 0;
        while (last >= fro) {
            mid = (last - fro) / 2 + fro;
            if (arr[mid] > target) {
                last = mid - 1;
            } else if (arr[mid] < target) {
                fro = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
