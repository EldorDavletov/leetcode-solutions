package dfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands0(char[][] grid) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {
                {-1,0}, // yuqoriga
                {1,0}, // pastga
                {0,-1},// chapga
                {0,1} // o'nga
        };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1'){
                    count++;
                    queue.add(new int[]{i,j});
                    grid[i][j] = '0';
                    while (!queue.isEmpty()){
                        int[] temp = queue.poll();
                        for(int[] direction : directions){
                            int newRow = temp[0] + direction[0];
                            int newCol = temp[1] + direction[1];
                            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1') {
                                queue.add(new int[]{newRow, newCol});
                                grid[newRow][newCol] = '0'; // Belgilab qo'yamiz
                            }
                        }

                    }
                }
            }
        }

        return count;
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') { // Yangi orol topildi
                    count++;
                    dfs(grid, i, j); // DFS chaqiramiz
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Matritsadan tashqariga chiqib ketmaslik va faqat "1" larni tekshirish
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0'; // Tashrif buyurilganini belgilaymiz

        // To‘rt yo‘nalishda DFS chaqiramiz
        dfs(grid, r - 1, c); // Yuqoriga
        dfs(grid, r + 1, c); // Pastga
        dfs(grid, r, c - 1); // Chapga
        dfs(grid, r, c + 1); // O‘ngga
    }
}
