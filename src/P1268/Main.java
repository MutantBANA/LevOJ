package P1268;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = scan.nextInt();
        }

        System.out.println(maxSubarraySum(arr));
    }

    public static int maxSubarraySum(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 当前元素加入之后，是否能使当前和更大
            currentSum = Math.max(nums[i], currentSum + nums[i]);//在第i位置上面的数加上前面的最大值数是否会增大
            // 更新最大和
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
