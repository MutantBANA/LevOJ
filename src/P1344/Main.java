package P1344;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.next();
            System.out.println(findMax(str));
        }
    }

    public static int findMax(String str) {

        int[][] arr = new int[str.length()][str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < arr.length; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    arr[i][j] = arr[i + 1][j - 1] + 2;

                } else {
                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j - 1]);

                }
            }
        }
        return arr[0][arr.length - 1];
    }
}
