package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            int temp = 0;
            for (int j = i; j < n -1-i; j++) {
                temp = matrix[i][j];
                //left -> top
                matrix[i][j] = matrix[n-1-j][i];
                // bottom -> left
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                // right -> bottom
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                // top -> right
                matrix[j][n-1-i] = temp;
            }
        }
    }

    public static void setZeroes(int[][] matrix) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int row: rows){
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
        }
        for (int col: cols){
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][col] = 0;
            }
        }


    }

}
