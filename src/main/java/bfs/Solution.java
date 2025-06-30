package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j]==1){
                   return bfs(grid,i,j,directions,visited);
                }
            }
        }
        return 0;
    }

    public static int bfs(int[][] grid, int startRow, int startCol, int[][] directions,boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow,startCol});
        visited[startRow][startCol] = true;
        int perimeter = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length || grid[newRow][newCol] == 0) {
                    perimeter++;
                } else if (!visited[newRow][newCol]) {
                    queue.offer(new int[]{newRow,newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return perimeter;
    }

    public int islandPerimeter2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    // Hujayraning har bir tomoni uchun perimetrni hisoblash
                    if (r == 0 || grid[r - 1][c] == 0) perimeter++; // Yuqori
                    if (r == rows - 1 || grid[r + 1][c] == 0) perimeter++; // Past
                    if (c == 0 || grid[r][c - 1] == 0) perimeter++; // Chap
                    if (c == cols - 1 || grid[r][c + 1] == 0) perimeter++; // O'ng
                }
            }
        }

        return perimeter;
    }


}



