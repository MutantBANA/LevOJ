package P1855;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//学生数量
        int m = scan.nextInt();//水龙头
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            queue.add(arr[i]);
        }
        for (int i = m; i < n; i++) {
            int count = queue.poll();
            count += arr[i];
            queue.add(count);
        }
//        int max = 0;
//        while (!queue.isEmpty()) {
//            int flag = queue.poll();
//            max = Math.max(max, flag);
//        }
        while(queue.size() != 1)
        {
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
