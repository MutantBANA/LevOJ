package P1475;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static class group implements Comparable<group> {
        int x;
        int y;

        public group() {
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int compareTo(group other) {
            return Integer.compare( other.y,this.y);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "group{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()) {
            int money = scan.nextInt();
            int n = scan.nextInt();
            int max = 0;
            group[] gp = new group[n];
            for (int i = 0; i < n; i++) {
                gp[i] = new group();
                gp[i].setX(scan.nextInt());
                max = max > gp[i].getX() ? max : gp[i].getX();
            }
            for (int i = 0; i < n; i++) {
                gp[i].setY(scan.nextInt());
            }
//        System.out.println(Arrays.toString(gp));
            Arrays.sort(gp);
            System.out.println(Arrays.toString(gp));
            System.out.println(max);
            boolean[] arr = new boolean[max];
            for (int i = 0; i < n; i++) {
                int x = gp[i].getX() - 1;
                while (x >= 0) {
                    if (arr[x] != true) {
                        arr[x] = true;
                        break;
                    }
                    x--;
                }
                if (x < 0) {
                    money -= gp[i].getY();
                }
            }

            System.out.println(money);
        }
    }
}
