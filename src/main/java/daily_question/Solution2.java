package daily_question;

public class Solution2 {

    public static void main(String[] args) {

    }

    public static int maxScore(String s) {
        int n = s.length();
        int[] prefixZeros = new int[n];
        int[] suffixOnes = new int[n];

        // Prefix array for counting zeros
        prefixZeros[0] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            prefixZeros[i] = prefixZeros[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
        }

        // Suffix array for counting ones
        suffixOnes[n - 1] = s.charAt(n - 1) == '1' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            suffixOnes[i] = suffixOnes[i + 1] + (s.charAt(i) == '1' ? 1 : 0);
        }

        // Calculate maximum score
        int maxScore = 0;
        for (int i = 0; i < n - 1; i++) { // Split point should not include the last character
            maxScore = Math.max(maxScore, prefixZeros[i] + suffixOnes[i + 1]);
        }

        return maxScore;

    }
}
