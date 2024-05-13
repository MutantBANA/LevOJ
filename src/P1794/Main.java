package P1794;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String[] split = br.readLine().split(" ");
            int minSize = Integer.parseInt(split[0]);
            int maxSize = Integer.parseInt(split[1]);
            int n = Integer.parseInt(br.readLine());
            split = br.readLine().split(" ");
            int[] fishSize = new int[n];
            for (int i = 0; i < n; i++) {
                fishSize[i] = Integer.parseInt(split[i]);
            }
            int sum = 0;
            for (int i = minSize; i <= maxSize; i++) {
                boolean flag = true;
                for (int j = 0; j < n; j++) {
                    if ((fishSize[j] * 2 <= i && fishSize[j] * 10 >=  i )||( fishSize[j]/2 >=  i && fishSize[j] / 10 <= i) ){
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    sum++;
                }
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
