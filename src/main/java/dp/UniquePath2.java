package dp;

import java.util.Arrays;

public class UniquePath2 {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        System.out.println(uniquePathsWithObstacles(grid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];

        if (obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1){
            return 0;
        }else {
            dp[0][0] = 1;
            for (int i = 1; i < n; i++) {
                if (obstacleGrid[i][0] == 0) {
                    dp[i][0] = dp[i-1][0];
                }else {
                    break;
                }
            }
            for(int j = 1; j < m; j++){
                if (obstacleGrid[0][j] == 0){
                    dp[0][j] = dp[0][j-1];
                }else {
                    break;
                }
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (obstacleGrid[i][j] == 1){
                        dp[i][j] = 0;
                    }else {
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
        }

        return dp[n-1][m-1];
    }


    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1); // -1 = hali hisoblanmagan

        return dp(m - 1, n - 1, obstacleGrid, memo);
    }

    private int dp(int i, int j, int[][] grid, int[][] memo) {
        // Chegaradan chiqib ketgan bo‘lsa
        if (i < 0 || j < 0) return 0;

        // To‘siq bo‘lsa
        if (grid[i][j] == 1) return 0;

        // Start nuqta
        if (i == 0 && j == 0) return 1;

        // Agar allaqachon hisoblangan bo‘lsa
        if (memo[i][j] != -1) return memo[i][j];

        int fromTop = dp(i - 1, j, grid, memo);
        int fromLeft = dp(i, j - 1, grid, memo);

        memo[i][j] = fromTop + fromLeft;
        return memo[i][j];
    }

}
