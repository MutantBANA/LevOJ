package P1797;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//马的数量
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = scan.nextInt();
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int money = maxMoney(arr1, arr2, n);
        System.out.println(money);
    }

//    @Test
//    public void test() {
//        int n = (int)(Math.random()*10000);//马的数量
//        int[] arr1 = new int[n];
//        int[] arr2 = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr1[i] = (int)(Math.random()*100);
////            System.out.print(arr1[i] + " ");
//        }
////        System.out.println();
//        for (int i = 0; i < n; i++) {
//            arr2[i] = (int)(Math.random()*100);
////            System.out.print(arr2[i] + " ");
//        }
//        Arrays.sort(arr1);
//        Arrays.sort(arr2);
//
//        int money = maxMoney(arr1, arr2, n);
//        System.out.println(money);
//    }

    public static int maxMoney(int[] arr1, int[] arr2, int n) {
        int al = 0;
        int ar = n - 1;
        int bl = 0;
        int br = n - 1;
        int money = 0;
        while (al <= ar && bl <= br) {
            if (arr1[al] > arr2[bl]) {
                money += 200;
                al++;
                bl++;
            } else if (arr1[al] < arr2[bl]) {
                money -= 200;
                al++;
                br--;
            } else {
                if (arr1[ar] > arr2[br]) {
                    ar--;
                    br--;
                    money += 200;
                } else if (arr1[ar] < arr2[br]) {
                    money -= 200;
                    al++;
                    br--;
                } else {
                    if (arr1[al] < arr2[br]) {
                        al++;
                        br--;
                        money -= 200;
                    } else {
                        return money;
                    }
                }
            }
        }
        return money;
    }
}
