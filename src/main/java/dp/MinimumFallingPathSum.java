package dp;

public class MinimumFallingPathSum {

    public static void main(String[] args) {
        int[][] matrix = {
                {2,1,3},
                {6,5,4},
                {7,8,9}
        };

        MinimumFallingPathSum obj = new MinimumFallingPathSum();

        System.out.println(obj.minFallingPathSum(matrix));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[n-1][j] = matrix[n-1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j == 0){
                    dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + matrix[i][j];
                } else if (j == n - 1) {
                    dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j-1]) + matrix[i][j];
                }else {
                    dp[i][j] = Math.min(dp[i+1][j+1], Math.min(dp[i+1][j],dp[i+1][j-1])) + matrix[i][j];
                }
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minSum = Math.min(minSum,dp[0][i]);
        }


        return minSum;

    }

    private int dp(int[][] matrix, int i, int j, int sum){
        int n = matrix.length;
        if (i < 0 || i >= n || j < 0 || j >= n) return 0;

        return 0;
    }
}
