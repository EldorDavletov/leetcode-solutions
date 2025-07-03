package dp;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimb {
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        MinCostClimb obj = new MinCostClimb();
        System.out.println(obj.minCostClimbingStairs(cost));
    }

    Map<Integer,Integer> memo = new HashMap<>();


    public int minCostClimbingStairs(int[] cost) {
        return Math.min(
                dp(cost, memo, cost.length - 1),
                dp(cost, memo, cost.length - 2)
        );
    }
    private int dp(int[] cost, Map<Integer,Integer> memo, int i){
        if(i < 2) return cost[i];

        if(!memo.containsKey(i)){
            memo.put(i, cost[i] + Math.min(
                    dp(cost, memo, i - 1),
                    dp(cost, memo, i - 2)
            ));
        }

        return memo.get(i);
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]); // finishga chiqish uchun
    }

}
