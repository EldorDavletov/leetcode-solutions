package dp;

import java.util.ArrayList;
import java.util.List;

public class Pascal2 {
    private int[][] memo;

    public static void main(String[] args) {
        Pascal2 obj = new Pascal2();
        System.out.println(obj.getRow(4));
    }

    public  List<Integer> getRow(int rowIndex) {
        memo = new int[rowIndex][rowIndex]; // 0-initsiya
        List<List<Integer>> result = new ArrayList<>();

        for (int row = 0; row < rowIndex; row++) {
            List<Integer> current = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                current.add(getPascal(row, col));
            }
            result.add(current);
        }

        return result.get(result.size()-1);
    }

    private int getPascal(int row, int col) {
        if (col == 0 || col == row) return 1;

        if (memo[row][col] != 0) return memo[row][col];

        memo[row][col] = getPascal(row - 1, col - 1) + getPascal(row - 1, col);
        return memo[row][col];
    }
}
