package dp;

import java.util.Arrays;

public class PartitionToKEqual {
    public static void main(String[] args) {
        int[] nums = {4,3,2,3,5,2,1};
        System.out.println(canPartitionKSubsets(nums,4));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int target = sum / k;
        int N = nums.length;
        int[] dp = new int[1<<N];
        int[] total = new int[1<<N];
        dp[0] = 1;

        for(int mask = 0; mask < 1<<N; mask++){
            if(dp[mask] == 0) continue;
            for(int i = 0; i < N; i++){
                if( (mask & (1<<i)) == 0 ){
                    int future = mask | (1<<i);
                    if(dp[future] == 0 && nums[i] <= target - (total[mask] % target)){
                        dp[future] = 1;
                        total[future] = total[mask] + nums[i];
                    }
                }
            }
        }
        return dp[(1<<N)-1] == 1;

    }

    public static boolean canPartitionKSubsets0(int[] nums, int k) {
        if (nums.length < k) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int target = sum / k;
        boolean[] used = new boolean[nums.length];
        if (Arrays.stream(nums).max().getAsInt() > target) return false;
        return backtrack(nums,used,target,k,0,0);
    }



    private static boolean backtrack(int[] nums, boolean[] used, int target,int k, int currSum, int index){
        if (k == 0) return true;
        if (currSum == target) return backtrack(nums,used,target,k-1,0,0);
        for (int i = index; i < nums.length; i++) {
            if (used[i] || currSum + nums[i] > target) continue;
            used[i] = true;
            if (backtrack(nums,used,target,k,currSum+nums[i],i+1)) return true;
            used[i] = false; // backtrack qilamiz
        }
        return false;
    }
}
