package P1305;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 1;
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int num = scan.nextInt();
            System.out.println("Case " + count++ + ":");
            ArrayList<String> list = new ArrayList<>();
            boolean[] isVisited = new boolean[num];
            isVisited[0] = true;
            getWays(list, isVisited, 1, "1");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
            System.out.println();
        }
        scan.close();
    }


    public static void getWays(ArrayList<String> list, boolean[] isVisited, int count, String str) {
        if (count == isVisited.length) {
            list.add(str);
            return;
        }
        int pre = 0;
        for (int i = str.length() - 1; i >= 0 && str.charAt(i) != ' '; i--) {
            pre += (str.charAt(i) - '0') * Math.pow(10, str.length() - i - 1);//
        }
        for (int i = 2; i <= isVisited.length; i++) {
            if (!isVisited[i - 1]) {
                if (count == isVisited.length - 1) {
                    if (!isValid(i + 1)) {
                        return;
                    }
                }
                if (isValid(i + pre)) {
                    isVisited[i - 1] = true;
                    getWays(list, isVisited, count + 1, str + " " + i);
                    isVisited[i - 1] = false;
                }
            }
        }
    }

    public static boolean isValid(int num) {//判断素数
        if (num == 2 || num == 3) {
            return true;
        }
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
