package dfs;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };
        System.out.println(numEnclaves(grid));
    }

    public static int numEnclaves(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && (i==0||j==0||i==rows-1||j==cols-1)) {
                    dfs(grid, i, j);
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (grid[i][j]==1) count++;
            }
        }

        return count;
    }

    public static void dfs(int[][] grid,int i,int j){
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
