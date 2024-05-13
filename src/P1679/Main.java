package P1679;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[][] map = new int[N][M];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = scan.nextInt();
            }
        }
        int crush_x = scan.nextInt();
        int crush_y = scan.nextInt();
        int watermelon_x = scan.nextInt();
        int watermelon_y = scan.nextInt();
        int min = findMin(map, N, M, crush_x - 1, crush_y - 1, watermelon_x - 1, watermelon_y - 1);
        System.out.println(min);
    }

    public static int findMin(int[][] map, int N, int M, int crush_x, int crush_y, int watermelon_x, int watermelon_y) {
        LinkedList<int[]> list = new LinkedList<>();
        list.addLast(new int[]{crush_x, crush_y});
        while (!list.isEmpty()) {
            int[] cur = list.pollFirst();
            int step = map[cur[0]][cur[1]];
            if (cur[0] - 1 >= 0 && map[cur[0] - 1][cur[1]] == 0) {//上
                list.addLast(new int[]{cur[0] - 1, cur[1]});
                map[cur[0] - 1][cur[1]] = step - 1;
            }
            if (cur[0] + 1 < N && map[cur[0] + 1][cur[1]] == 0) {//下
                list.addLast(new int[]{cur[0] + 1, cur[1]});
                map[cur[0] + 1][cur[1]] = step - 1;
            }
            if (cur[1] - 1 >= 0 && map[cur[0]][cur[1] - 1] == 0) {//左
                list.addLast(new int[]{cur[0], cur[1] - 1});
                map[cur[0]][cur[1] - 1] = step - 1;
            }
            if (cur[1] + 1 < M && map[cur[0]][cur[1] + 1] == 0) {//右
                list.addLast(new int[]{cur[0], cur[1] + 1});
                map[cur[0]][cur[1] + 1] = step - 1;
            }
        }
        if (map[watermelon_x][watermelon_y] == 0)
            return -1;
        else return -map[watermelon_x][watermelon_y];
    }

}
