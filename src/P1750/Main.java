package P1750;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        long count = mergeSort(arr, 0, n - 1);
        System.out.println(count);
    }

    public static long mergeSort(int[] arr, int l, int r) {//返回逆序对数量从l-r
//        int count = 0;
//        for (int i = 0; i <n ; i++) {
//           count +=Math.abs(map.get(arr[i])-i);
//        }
//        return count;
//        int[] count = new int[n];
//        int max = 0;
//        for (int i = 1; i < n; i++) {
//            max = Math.max(max, count[i - 1]);
//            for (int j = i - 1; j >= 0; j--) {
//                if (arr[i] < arr[j]) {
//                    count[i] += 1;
//                }
//            }
//            count[i] += count[i - 1];
//        }
//        return count[n - 1];
//        int max = 0;
//        int l = 0;
//        int r = 0;
//        for (int i = 1; i <= n; i++) {
//            r+=i;
//            while(l<n&&r<n)
//            {
//                if(arr[l] > arr[r])
//                {
//                    max++;
//                }
//                r+=1;
//                l+=1;
//            }
//            r = 0;
//            l = 0;
//        }
//        return max;
        if (l >= r)
            return 0;
        int mid = (r - l) / 2 + l;
        long left = mergeSort(arr, l, mid);//左边区间内部的逆序对
        long right = mergeSort(arr, mid + 1, r);//右边区间内部的逆序对
        return left + right + merge(arr, l, r, mid);//左边在右边的逆序对
    }

    public static long merge(int[] arr, int l, int r, int mid) {//l-mid范围到mid+1-r的逆序对的数量
        int[] count = new int[r - l + 1];//记录排完序的数组
        int i = l;
        int j = mid + 1;
        long sum = 0;//记录逆序对
        int index = 0;//排序的位置
        while (i <= mid && j <= r) {
            if (arr[i] > arr[j]) {
                //当左边比右边大，说明出现逆序对，因为是降序排序，所以左边比右边的右边还大，右边的边界是r，在第j个的地方出现逆序对所以r-j+1是逆序对数
                sum += r - j + 1;
                count[index++] = arr[i++];
            } else {
                //当左边等于右边，右边先放进count[]，因为目的是根据左边找到右边第一个比它小的数
                count[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            //因为剩下来的左边一定比右边小，降序排序，构成不了逆序对
            count[index++] = arr[i++];
        }
        while (j <= r) {
            count[index++] = arr[j++];
        }
        for (int k = 0; k < index; k++) {
            //更新arr数组
            arr[l + k] = count[k];
        }
        return sum;
    }
}
