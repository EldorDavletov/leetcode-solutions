package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(),n);
        return result;
    }

    private static void backtrack(List<List<String>> result,List<String> current, int n){
        int row = current.size();
        if (row == n){
            result.add(new ArrayList<>(current));
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(current, row, col)) {
                // Qatorni hosil qilamiz, masalan, "..Q."
                char[] rowChars = new char[n];
                for (int i = 0; i < n; i++) rowChars[i] = '.';
                rowChars[col] = 'Q';
                current.add(new String(rowChars)); // Qatorni ro‘yxatga qo‘shamiz

                backtrack(result, current, n); // Keyingi qator uchun rekursiya

                current.remove(current.size() - 1); // Backtrack: oxirgi qatorni olib tashlash
            }
        }


    }
    private static boolean isSafe(List<String> current,int row, int col){
        // Avvalgi qatorlarda qirolichalar joylashgan joylarni tekshiramiz
        for (int i = 0; i < row; i++) {
            int queenCol = current.get(i).indexOf('Q'); // i-qatordagi qirolichaning ustuni

            // Agar bir xil ustunda yoki diagonalda bo'lsa, xavfsiz emas
            if (queenCol == col || Math.abs(queenCol - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
