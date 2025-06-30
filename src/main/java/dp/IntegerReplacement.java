package dp;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {
    Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        IntegerReplacement obj = new IntegerReplacement();
        System.out.println(obj.integerReplacement(87));
        System.out.println(obj.map);
    }

    public  int integerReplacement0(int n) {
        if( n == 1) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
           if ((i & 1) == 0){
               dp[i] = dp[i/2] + 1;
           }else {
               dp[i] = Math.min(dp[i-1],dp[(i+1)/2]+1) + 1;
           }
        }
        return dp[n];
    }

    public  int integerReplacement(int n) {

        return helper(n,map);
    }
    public static int helper(long n, Map<Integer,Integer> map){
        if (n == 1) return 0;
        if (map.containsKey((int) n)) return map.get((int) n);
        int steps;
        if ((n&1)==0){
            steps = helper(n/2,map)+1;
        }else {
            steps = Math.min(helper(n-1,map),helper(n+1,map)) + 1;
        }
        map.put((int)n,steps);
        return steps;
    }
}
