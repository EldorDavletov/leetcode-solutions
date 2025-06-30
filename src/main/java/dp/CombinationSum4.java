package dp;

public class CombinationSum4 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(combinationSum4(nums,4));
    }

    public static int combinationSum4(int[] nums, int target) {
        Integer[] memo = new Integer[target+1];
        return dfs(nums,target,0,memo);
    }

    private static int dfs(int[] nums, int target, int sum,Integer[] memo){
        if (sum == target) return 1;
        if (sum > target) return 0;
        if (memo[sum] != null) return memo[sum];

        int total = 0;
        for(int num : nums){
            total += dfs(nums,target,sum+num,memo);
        }
        return memo[sum] = total;
    }

    public int _combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int sum = 1; sum <= target; sum++) {
            for (int num : nums) {
                if (sum - num >= 0) {
                    dp[sum] += dp[sum - num];
                }
            }
        }

        return dp[target];
    }

}
