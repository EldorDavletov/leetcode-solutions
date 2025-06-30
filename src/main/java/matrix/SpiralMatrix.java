package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][]  matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = cols -1,  up = 0, down = rows - 1;
        List<Integer> result = new ArrayList<>();
        while (up <= down && left <= right) {

            for (int j = left; j <= right; j++) result.add(matrix[up][j]); // chapdan o'nga yurish
            up++;

            for (int j = up; j <= down; j++) result.add(matrix[j][right]); // yuqoridan pastga yurish
            right--;

            if (left <= right) {
                for (int j = right; j >= left; j--) result.add(matrix[down][j]); //o'ngdan chapga yurish
                down--;
            }

            if (up <= down) {
                for (int j = down; j >= up; j--) result.add(matrix[j][left]); // pastdan tepaga yurish
                left++;
            }

        }

        return result;
    }
}
