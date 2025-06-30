package backtracking;

public class WordSearch {
    public static void main(String[] args) {
       char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
       String word = "ABCCED";
        System.out.println(exist(board,word));
    }

    public static boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (backtrack(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word,int row, int col, int index){
        // Agar so‘zning oxirgi harfini ham topsak, true qaytaramiz.
        if (index == word.length()) {
            return true;
        }

        // Cheklovlarni tekshirish: tashqariga chiqish, noto‘g‘ri harf va oldin ishlatilgan joy.
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
                board[row][col] != word.charAt(index)) {
            return false;
        }

        // Hozirgi xujayrani belgilash
        char temp = board[row][col];
        board[row][col] = '#'; // Belgilash

        // 4 yo‘nalishda qidiruv
        boolean found = backtrack(board, word, row + 1, col, index + 1) || // Pastga
                backtrack(board, word, row - 1, col, index + 1) || // Tepaga
                backtrack(board, word, row, col + 1, index + 1) || // O‘ngga
                backtrack(board, word, row, col - 1, index + 1);   // Chapga

        board[row][col] = temp; // Belgini tiklash
        return found;
    }
}
