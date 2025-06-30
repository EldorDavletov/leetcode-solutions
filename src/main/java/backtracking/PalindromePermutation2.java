package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePermutation2 {
    public static void main(String[] args) {
        String  s = "aabbhijkkjih";
        System.out.println(generatePalindromes(s));
    }

    public static List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int odd = 0;
        String mid = "";
        StringBuilder half = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            if (count[i] % 2 == 1) {
                odd++;
                mid = "" + (char) i;
            }
            for (int j = 0; j < count[i] / 2; j++) {
                half.append((char) i);
            }
        }

        if (odd > 1) return result; // Palindrom yasash mumkin emas

        backtrack(result, new boolean[half.length()], new StringBuilder(), half.toString(), mid);
        return result;
    }

    private static void backtrack(List<String> result, boolean[] used, StringBuilder path, String half, String mid) {
        if (path.length() == half.length()) {
            StringBuilder rev = new StringBuilder(path).reverse();
            result.add(path + mid + rev);
            return;
        }

        for (int i = 0; i < half.length(); i++) {
            if (used[i]) continue;
            if (i > 0 && half.charAt(i) == half.charAt(i - 1) && !used[i - 1]) continue;

            used[i] = true;
            path.append(half.charAt(i));
            backtrack(result, used, path, half, mid);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }


    private static boolean isPalindrome(String str){
        int left = 0, right = str.length() - 1;
        while (left < right){
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }
}
