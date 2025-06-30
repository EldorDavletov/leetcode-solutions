package dp;

import java.util.Arrays;

public class PartitionEqualSubSet {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) return false;
        int target = sum /2;
        return dfs(nums,0,target,0);
    }

    private static boolean dfs(int[] nums, int index, int target, int depth){
        String indent = "  ".repeat(depth); // vizual indent
        System.out.println(indent + "→ ENTER: dfs(index = " + index + ",target = "+target+")");
        if (target == 0){
            System.out.println(indent + "→ EXIT: dfs(index = " + index + ",target = "+target+")");
            return true;
        }
        if (index == nums.length || target < 0){
            System.out.println(indent + "→ EXIT: dfs(index = " + index + ",target = "+target+")");
            return false;
        }

        // pick or skip
        boolean result = dfs(nums,index + 1, target - nums[index],depth + 1) ||
         dfs(nums,index + 1, target, depth + 1);
        System.out.println(indent + "→ EXIT: dfs(index = " + index + ",target = "+target+")");
        return result;
    }
}
