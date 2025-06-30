package dp;

public class JumpGames {
    public static void main(String[] args) {
        int[] nums = {2,2,1,3,1,1,2};
        System.out.println(jump(nums));
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n-1];
    }

    public boolean canJumpOrg(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; // If we can't reach index i, return false
            maxReach = Math.max(maxReach, i + nums[i]); // Update the max reachable index
            if (maxReach >= nums.length - 1) return true; // If we can reach the last index, return true
        }
        return false;
    }

    public static int jump0(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    min = Math.min(dp[j]+1,min);
                }
            }
            dp[i] = min;
        }
        return dp[n-1];
    }

    public static int jump(int[] nums) {
        int far = 0, end = 0, steps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            far = Math.max(far, i + nums[i]); // Eng uzoqqa borish mumkin bo‘lgan joyni yangilaymiz

            if (i == end) { // Hozirgi qadam tugaganda sakrash qilamiz
                steps++;
                end = far; // Yangi sakrash chegarasini o‘rnatamiz
            }
        }
        return steps;
    }



}
