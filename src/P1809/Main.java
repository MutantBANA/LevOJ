package P1809;

import org.junit.Test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//路径长度
        int m = scan.nextInt();//积水个数
        int k = scan.nextInt();//最远可跨越
        int[] arr = new int[n];//存水坑的位置，水坑位置赋1
        for (int i = 0; i < m; i++) {
            arr[scan.nextInt() - 1] = 1;
        }
        int[] min = new int[n];
        findMin(arr, min, k);
        System.out.println(min[n - 1]);
    }

    @Test
    public void test()
    {
        int n =(int)(Math.random()*100000+1);//路径长度
        int m = (int)(Math.random()*100000+1);//积水个数
        int k = (int)(Math.random()*50+1);//最远可跨越
        int[] arr = new int[n];//存水坑的位置，水坑位置赋1
        int[] min = new int[n];
        int[] min1 = new int[n];
        findMin(arr, min, k);
        findMin(arr,min1,k,0);
        System.out.println(min[n - 1]);
        System.out.println(min1[n - 1]);
    }
    /**
     * @param arr 水坑位置
     * @param k
     * @return
     */
    public static void findMin(int[] arr, int[] minArr, int k) {
        for (int j = 0; j < arr.length; j++) {
            int min = Integer.MAX_VALUE;
            for (int i = j - 1; i >= j - k && i >= 0; i--) {
                if (min > minArr[i]) {
                    min = minArr[i];
                }
            }
            minArr[j] = (min == Integer.MAX_VALUE ? 0 : min) + arr[j];
        }
    }
    public static void findMin(int[] arr,int[] minArr,int k,int x)
    {
        if(x >= arr.length)
            return;
        int min = Integer.MAX_VALUE;
        for (int i = x - 1 ; i >= x-k && i >= 0; i--) {
            if(min > minArr[i])
            {
                min = minArr[i];
            }
        }
        minArr[x] = (min== Integer.MAX_VALUE? 0:min) + arr[x];
        findMin(arr,minArr,k,x + 1);
    }
}