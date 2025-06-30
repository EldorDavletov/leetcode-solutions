package dp;

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
}
