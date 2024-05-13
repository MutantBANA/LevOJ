package P1849;

import org.junit.Test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();//格子数量
        int M = scan.nextInt();//卡片数量
        int arrN[] = new int[N];
        for (int i = 0; i < N; i++) {
            arrN[i] = scan.nextInt();
        }
        int arrM[] = new int[4];
        for (int i = 0; i < M; i++) {
            arrM[scan.nextInt() - 1]++;
        }
        int arr[][][][] = new int[arrM[0] + 1][arrM[1] + 1][arrM[2] + 1][arrM[3] + 1];
        int max = findMax1(arrN, arrM, arr);
        System.out.print(max);
    }

    @Test
    public void test() {

        int N = (int) (Math.random() * 350) + 1;//格子数量
        int M = (int) (Math.random() * 120) + 1;//卡片数量
        int arrN[] = new int[N];
        for (int i = 0; i < N; i++) {
            arrN[i] = (int) (Math.random() * 100) + 1;
        }
        int arrM[] = new int[4];
        for (int i = 0; i < M; i++) {
            arrM[(int) (Math.random() * 4)]++;
        }
        int arr[][][][] = new int[arrM[0] + 1][arrM[1] + 1][arrM[2] + 1][arrM[3] + 1];
        int max = findMax1(arrN, arrM, arr);
        System.out.print(max);
    }

    /**
     * @param arrN 每个格子存的分数
     * @param arrM 每张牌剩余几张
     * @return 在走到x位置的时候的最大的得分
     */
    public static int findMax(int arrN[], int arrM[]) {
        int x = arrN.length - 1;
        for (int i = 0; i < arrM.length; i++) {
            x -= arrM[i] * (i + 1);
        }
        if (x == arrN.length - 1)
            return arrN[x];
        int max = 0;
        for (int i = 0; i < 4; i++) {
            if (arrM[i] > 0) {
                arrM[i]--;
                int count = findMax(arrN, arrM) + arrN[x];
                arrM[i]++;
                if (count > max) {
                    max = count;
                }
            }
        }
        return max;
    }

    public static int findMax1(int arrN[], int arrM[], int arr[][][][]) {
        if (arr[arrM[0]][arrM[1]][arrM[2]][arrM[3]] != 0) {
            return arr[arrM[0]][arrM[1]][arrM[2]][arrM[3]];
        }
        int x = arrN.length - 1;
        for (int i = 0; i < arrM.length; i++) {
            x -= arrM[i] * (i + 1);
        }
        int max = 0;
        for (int i = 0; i < 4; i++) {
            if (arrM[i] > 0) {
                arrM[i]--;
                int count = findMax1(arrN, arrM, arr);
                if (count > max) {
                    max = count;
                }
                arrM[i]++;
            }
        }
        arr[arrM[0]][arrM[1]][arrM[2]][arrM[3]] = max + arrN[x];
        return max + arrN[x];
    }
}
