package P1870;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//村庄数量

        int[] arr = new int[n];//每个村庄的敌人数量
        int[] countNum = new int[n];
        for (int i = 0; i < n; i++) {
            countNum[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
//        int count = sum(n, arr, 0);
//        int count1 = dp(n,arr,0,countNum);
        int count2 = dpArr(n,arr);
//        System.out.println(count);
//        System.out.println(count1);
        System.out.println(count2);
//        int n =(int) (Math.random()*10000000+1);//村庄数量
//
//        int[] arr = new int[n];//每个村庄的敌人数量
//        int[] countNum = new int[n];
//        for (int i = 0; i < n; i++) {
//            countNum[i] = -1;
//        }
//        for (int i = 0; i < n; i++) {
//            arr[i] =(int) (Math.random()*1000+1);
//        }
////        int count = sum(n, arr, 0);
//        int count1 = dpArr(n,arr);
////        System.out.println(count);
//        System.out.println(count1);
    }


//    @Test
//    public  void test()
//    {
//
//        int n =(int) (Math.random()*100+1);//村庄数量
//
//        int[] arr = new int[n];//每个村庄的敌人数量
//        int[] countNum = new int[n];
//        for (int i = 0; i < n; i++) {
//            countNum[i] = -1;
//        }
//        for (int i = 0; i < n; i++) {
//            arr[i] =(int) (Math.random()*20+1);
//        }
////        int count = sum(n, arr, 0);
//        int count1 = dp(n,arr,0,countNum);
////        System.out.println(count);
//        System.out.println(count1);
//    }
    public static int sum(int n, int[] arr, int x) {
        if (x >= n) {
            return 0;
        }
        int p1 = sum(n, arr, x + 1);
        int p2 = sum(n, arr, x + 2) + arr[x];
        return Math.max(p1, p2);
    }
    public static int dp(int n, int[] arr, int x, int[] countNum)
    {
        if(x>=n)
            return 0;
        if(countNum[x] != -1)
            return countNum[x];
        int p1 = dp(n, arr, x + 1,countNum);
        int p2 = dp(n, arr, x + 2,countNum) + arr[x];
        countNum[x] = Math.max(p1, p2);
        return countNum[x];
    }
    public static int dpArr(int n,int[] arr)
    {
        int[] count = new int[arr.length];
        count[arr.length-1] = arr[arr.length-1];
        count[arr.length-2] = Math.max(arr[arr.length-1],arr[arr.length-2]);
        for (int i = arr.length-3; i >= 0 ; i--) {
            count[i] = Math.max(count[i+1],count[i+2]+arr[i]);
        }
        return count[0];
    }
}
