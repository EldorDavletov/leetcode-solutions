package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIS2 {
    public static void main(String[] args) {
        int[] nums = {4,2,1,4,3,4,5,8,15};
        System.out.println(lengthOfLIS(nums,3));
    }

    public static int lengthOfLIS(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && nums[i] - nums[j] <= k){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public int lengthOfLIS2(int[] nums, int k) {
        int maxVal = 100_000;  // per problem constraints
        SegmentTree segTree = new SegmentTree(maxVal + 1);
        int result = 0;

        for (int num : nums) {
            int l = Math.max(1, num - k);
            int r = num - 1;
            int best = segTree.query(l, r, 1, 1, maxVal);
            segTree.update(num, best + 1, 1, 1, maxVal);
            result = Math.max(result, best + 1);
        }

        return result;
    }
}
