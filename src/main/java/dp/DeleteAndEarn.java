package dp;

public class DeleteAndEarn {
    public static void main(String[] args) {

    }

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num] += num;
        }

        int[] dp = new int[max + 1];
        dp[0] = 0;
        dp[1] = count[1];

        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + count[i]);
        }

        return dp[max];
    }
}
