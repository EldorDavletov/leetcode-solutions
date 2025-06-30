package daily_question;

import java.util.*;

public class BFSExamples {

    public static void main(String[] args) {
        int[][] board = {
                {4, 1, 2},
                {5, 0, 3}
        };
        int result = slidingPuzzle(board);
        System.out.println("Minimal harakatlar soni: " + result);
    }

    public static int slidingPuzzle(int[][] board) {
        String target = "123450"; // Maqsad holat
        String start = Arrays.deepToString(board).replaceAll("\\[|]|,|\\s", ""); // Boshlang'ich holat

        // Har bir hujayra uchun bo'sh joy harakatlari (2x3 taxtada)
        int[][] directions = {
                {1, 3},     // 0-pozitsiya: pastga yoki o'ngga
                {0, 2, 4},  // 1-pozitsiya: chapga, o'ngga yoki pastga
                {1, 5},     // 2-pozitsiya: chapga yoki pastga
                {0, 4},     // 3-pozitsiya: yuqoriga yoki o'ngga
                {1, 3, 5},  // 4-pozitsiya: yuqoriga, chapga yoki o'ngga
                {2, 4}      // 5-pozitsiya: yuqoriga yoki chapga
        };

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return steps; // Maqsad holatga erishildi
                }

                // Bo'sh joyning pozitsiyasini aniqlash
                int zeroPos = current.indexOf('0');
                for (int dir : directions[zeroPos]) {
                    // Yangi holat yaratish uchun massivni almashtiramiz
                    char[] newBoard = current.toCharArray();
                    swap(newBoard, zeroPos, dir);
                    String newState = new String(newBoard);

                    if (!visited.contains(newState)) {
                        queue.add(newState);
                        visited.add(newState);
                    }
                }
            }
            steps++; // Navbatdagi qadam
        }
        return -1; // Maqsad holatga erishib bo'lmadi
    }

    // Bo'sh joyni almashtirish funksiyasi
    private static void swap(char[] board, int i, int j) {
        char temp = board[i];
        board[i] = board[j];
        board[j] = temp;
    }

}
