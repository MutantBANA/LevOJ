package P1972;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int K = scan.nextInt();
        int M = scan.nextInt();
        int N = scan.nextInt();
        char[][] map = new char[M][N];
        while (K-- != 0) {
            int[][][] arr = new int[M][N][4];
            for (int i = 0; i < M; i++) {
                map[i] = scan.next().toCharArray();
            }
            int isFind = findWay(map, 0, 0, 3, arr);
            if (isFind == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scan.close();
    }


//    @Test
//    public void test(){
//        for (int i = 0; i < 10000; i++) {
//            int M = (int)(Math.random() * 50) + 2;
//            int N = (int)(Math.random() * 50) + 2;
//            char[][] map = new char[M][N];
//            int[][][] arr = new int[M][N][3];
//            char[] rand = {'W','G','X'};
//            for (int j = 0; j < M; j++) {
//                for (int k = 0; k < N; k++) {
//                    int index = (int)(Math.random() * 3);
//                    map[j][k] = rand[index];
//                }
//            }
//
//            int ret1 = isValid(map,3,0,0,arr);
//            int ret2 = findWay(map,0,0,3,arr);
////            System.out.println("----------------");
//            if(ret1 != ret2){
//                System.out.println("M = " + M);
//                System.out.println("N = " + N);
//                System.out.println("Arrays.toString(map) = " + Arrays.toString(map));
//            }
//        }
//    }

    /**
     * @param map
     * @param x
     * @param y
     * @param blood
     * @return 从x，y到m，n，blood！= 0 的时候找到
     */
    public static int findWay(char[][] map, int x, int y, int blood, int[][][] arr) {
        if (x < 0 || y < 0 || x >= map.length || y >= map[0].length)
            return 0;
        if (arr[x][y][blood - 1] != 0) {
            return arr[x][y][blood - 1];
        }
        if (map[x][y] == 'W') {
            arr[x][y][blood - 1] = -1;
            return arr[x][y][blood - 1];
        } else if (map[x][y] == 'X') {
            if (blood > 1) {
                blood--;
            } else {
                arr[x][y][blood - 1] = -1;
                return arr[x][y][blood - 1];
            }
        }
        if (x == map.length - 1 && y == map[0].length - 1) {
            arr[x][y][blood - 1] = 1;
            return 1;
        }
        char pre = map[x][y];
        map[x][y] = 'W';
        int flag = findWay(map, x - 1, y, blood, arr);
        flag = flag == 1 ? flag : findWay(map, x + 1, y, blood, arr);
        flag = flag == 1 ? flag : findWay(map, x, y + 1, blood, arr);
        flag = flag == 1 ? flag : findWay(map, x, y - 1, blood, arr);
        map[x][y] = pre;
        arr[x][y][blood - 1] = flag;
        return flag;
    }

    public static int isValid(char[][] arr, int rest, int i, int j, int[][][] dp) {
        if (dp[i][j][rest - 1] != 0) {
            return dp[i][j][rest - 1];
        }
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            dp[i][j][rest - 1] = 1;
            return dp[i][j][rest - 1];
        }
        int flag = -1;
        if (i > 0) {//上
            if (arr[i - 1][j] == 'G') {
                arr[i - 1][j] = 'W';
                flag = isValid(arr, rest, i - 1, j, dp);
                arr[i - 1][j] = 'G';
            } else if (arr[i - 1][j] == 'X' && rest > 1) {
                arr[i - 1][j] = 'W';
                flag = isValid(arr, rest - 1, i - 1, j, dp);
                arr[i - 1][j] = 'X';
            }
        }
        if (flag == -1 && i < arr.length - 1) {//下
            if (arr[i + 1][j] == 'G') {
                arr[i + 1][j] = 'W';
                flag = isValid(arr, rest, i + 1, j, dp);
                arr[i + 1][j] = 'G';
            } else if (arr[i + 1][j] == 'X' && rest > 1) {
                arr[i + 1][j] = 'W';
                flag = isValid(arr, rest - 1, i + 1, j, dp);
                arr[i + 1][j] = 'X';
            }
        }
        if (flag == -1 && j > 0) {//左
            if (arr[i][j - 1] == 'G') {
                arr[i][j - 1] = 'W';
                flag = isValid(arr, rest, i, j - 1, dp);
                arr[i][j - 1] = 'G';
            } else if (arr[i][j - 1] == 'X' && rest > 1) {
                arr[i][j - 1] = 'W';
                flag = isValid(arr, rest - 1, i, j - 1, dp);
                arr[i][j - 1] = 'X';
            }
        }
        if (flag == -1 && j < arr[0].length - 1) {//右
            if (arr[i][j + 1] == 'G') {
                arr[i][j + 1] = 'W';
                flag = isValid(arr, rest, i, j + 1, dp);
                arr[i][j + 1] = 'G';
            } else if (arr[i][j + 1] == 'X' && rest > 1) {
                arr[i][j + 1] = 'W';
                flag = isValid(arr, rest - 1, i, j + 1, dp);
                arr[i][j + 1] = 'X';
            }
        }
        dp[i][j][rest - 1] = flag;
        return dp[i][j][rest - 1];
    }
}
