package dp;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWays(nums,3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        Map<String,Integer> memo = new HashMap<>();
        return dfs(nums,target,0,0,memo);
    }

    private static int dfs(int[] nums, int target, int sum, int index,Map<String,Integer> memo){
        if (index == nums.length){
            return sum == target ? 1 : 0;
        }
        String key = index + "#" + sum;
        if (memo.containsKey(key)) return memo.get(key);
        int plus = dfs(nums,target,sum+nums[index],index+1,memo);
        int minus = dfs(nums,target,sum-nums[index],index+1,memo);
        memo.put(key,plus + minus);
        return plus + minus;
    }


    public int findTargetSumWays2(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) total += num;
        if (target > total || target < -total) return 0;
        int offset = total;
        int[][] dp = new int[n + 1][2 * total + 1];
        dp[0][offset] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int sum = -total; sum <= total; sum++) {
                int shiftedSum = sum + offset;

                if (dp[i - 1][shiftedSum] > 0) {
                    dp[i][shiftedSum + num] += dp[i - 1][shiftedSum];  // +
                    dp[i][shiftedSum - num] += dp[i - 1][shiftedSum];  // -
                }
            }
        }
        return dp[n][target + offset];
    }


}
