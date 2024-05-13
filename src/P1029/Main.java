package P1029;

import java.util.Scanner;

/**
 * ClassName: Main
 * Package: P1029
 * Description:
 *
 * @Author Benanalana
 * @Create 2024/3/2 15:43
 * @Version 1.0
 */
public class Main
{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        int R = scan.nextInt();
        int C = scan.nextInt();
        int[][] arr = new int[R][C];
        int[][] pos = new int[R][C];
        for (int i = 0; i < R; i++)
        {
            for (int j = 0; j < C; j++)
            {
                arr[i][j] = scan.nextInt();
                pos[i][j] = -1;
            }
        }
        int max = 0;
        for (int i = 0; i < R; i++)
        {
            for (int j = 0; j < C; j++)
            {
                int x = getLength(i, j, arr, pos);
                max = Math.max(max, x);
            }
        }
        System.out.println(max);
        scan.close();
    }


    public static int getLength(int i, int j, int[][] arr, int[][] pos)
    {
        if (pos[i][j] != -1)
            return pos[i][j];
        int length = 0;
        if (i + 1 < arr.length && arr[i][j] > arr[i + 1][j])
        {
            length = Math.max(length, getLength(i + 1, j, arr, pos));
        }
        if (0 <= i - 1 && arr[i][j] > arr[i - 1][j])
        {
            length = Math.max(length, getLength(i - 1, j, arr, pos));
        }
        if (j + 1 < arr[0].length && arr[i][j] > arr[i][j + 1])
        {
            length = Math.max(length, getLength(i, j + 1, arr, pos));
        }
        if (j - 1 >= 0 && arr[i][j] > arr[i][j - 1])
        {
            length = Math.max(length, getLength(i, j - 1, arr, pos));
        }
        pos[i][j] = length + 1;
        return pos[i][j];
    }
}
