package dp;

public class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(change(5,coins));
    }

    public static int change0(int amount, int[] coins){
        Integer[][] memo = new Integer[coins.length+1][amount+1];
        return  dfs(amount,coins, memo,0);
    }

    private static int dfs(int amount, int[] coins, int index){
        if (amount == 0) return 1;
        if (index == coins.length) return 0;
        if (amount < 0) return 0;

        int  take = dfs(amount-coins[index],coins,index);
        int  skip = dfs(amount,coins,index+1);

        return take + skip;
    }
    private static int dfs(int amount, int[] coins, Integer[][] memo,int index){
        if (amount == 0) return 1;
        if (index == coins.length || amount < 0) return 0;

        if (memo[index][amount] != null) return memo[index][amount];

        int  take = dfs(amount-coins[index],coins, memo,index);
        int  skip = dfs(amount,coins,memo,index+1);

        return memo[index][amount] = take + skip;
    }

    private static int change(int amount, int[] coins){
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins){
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

}
