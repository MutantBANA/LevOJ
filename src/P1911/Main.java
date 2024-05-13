package P1911;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int sum = num /10;
        sum += num %10;
        System.out.println(sum );
    }
}
