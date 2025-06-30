package leetcodesolutions.dp;

import java.util.Arrays;

public class Solutions {

    public static void main(String[] args) {
//        int[] coins = {1,2,5};
//        System.out.println(coinChange(coins,11));
//        System.out.println(uniquePaths(3,7));
//        System.out.println(uniquePaths(3,2));

        int[] nums = {1,2,5};
        System.out.println(canPartition(nums));
    }


    public static int coinChange(int[] coins, int amount) {
        int[] amounts = new int[amount+1];
        Arrays.sort(coins);
        Arrays.fill(amounts,-1);
        amounts[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int minCoins = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin > i) {
                    break;
                }
                int rem = i - coin;
                if (amounts[rem] != -1) {
                    minCoins = Math.min(minCoins, amounts[rem] + 1);
                }
            }
            if (minCoins!=Integer.MAX_VALUE){
                amounts[i] = minCoins;
            }
        }

        return amounts[amount];
    }


    public static int longestCommonSubsequence(String text1, String text2) {

        int len1 = text1.length();
        int len2 = text2.length();
        int [][] dp = new int[len1+1][len2+1];
        int cnt = 0;

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text2.charAt(j)==text1.charAt(i)){
                    cnt++;
                    i++;
                }
            }
        }

        return 1;
    }


    public static int uniquePaths(int m, int n) {
        int[][] dp = new int [m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }


        return dp[m-1][n-1];
    }

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum&1)==1 || nums.length == 1) return false;
        Arrays.sort(nums);
        int target = sum/2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = target / 2; j > num - 1; j--) {
                dp[j] = dp[j] | dp[j - num];
            }
        }

        return dp[target];
    }
}
