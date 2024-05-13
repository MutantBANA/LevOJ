package P1395;

import org.junit.Test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int N = scan.nextInt();
            boolean[] list = new boolean[N];
            arrange(N, list, new StringBuilder());
        }
        scan.close();
    }

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            arrange(i, new boolean[i], new StringBuilder());
            System.out.println("---------------------------------");
        }
    }

    public static void arrange(int N, boolean[] list, StringBuilder string) {
        if (string.length() == N) {
            System.out.println(string);
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (list[i - 1] == true) {
                continue;
            } else {
                list[i - 1] = true;
                string.append(String.valueOf(i));
                arrange(N, list, string);
                string.deleteCharAt(string.length() - 1);
                list[i - 1] = false;
            }
        }
    }
}
