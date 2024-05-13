package P1848;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        int min = dp1(str1, str2);
        System.out.println(min);
    }

    public static int dp1(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= str2.length(); i++) {
            dp[0][i] = i;
        }
        //尽可能让i，j对应的是dp表的格子
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int min = Math.min(dp[i][j + 1], dp[i + 1][j]);
                    min = Math.min(min, dp[i][j]);
                    dp[i + 1][j + 1] = min + 1;
                }
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return dp[str1.length()][str2.length()];
    }
}
