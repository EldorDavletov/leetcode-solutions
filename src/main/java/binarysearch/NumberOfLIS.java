package binarysearch;

import java.util.Arrays;

public class NumberOfLIS {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(findNumberOfLIS(nums));
    }

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j]; // Yangi uzunlik topildi, oldingi countni olamiz
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j]; // Xuddi shu uzunlikdagi yana bir subsequence topildi
                    }
                }
            }
        }
        int maxLen = 0;
        for (int len : dp) {
            maxLen = Math.max(maxLen, len);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) {
                result += count[i];
            }
        }

        return result;
    }
}
