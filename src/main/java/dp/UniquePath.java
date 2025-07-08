package dp;

import java.util.Arrays;

public class UniquePath {
    public static void main(String[] args) {
        UniquePath obj = new UniquePath();
        System.out.println(obj.uniquePaths(3,7));
    }

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int[] row : memo)
            Arrays.fill(row,-1);

        return dp(memo,m-1,n-1);
    }

    private int dp(int[][] memo, int i, int j){
        if (i == 0 || j == 0) return 1;

        if (memo[i][j] != -1) return memo[i][j];

        memo[i][j] = dp(memo,i-1,j) + dp(memo,i,j-1);
        return memo[i][j];
    }
}
