package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.trim().isEmpty()) return 0;
        Set<Character> window = new HashSet<>();
        int maxLen = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (!window.add(c)){
                window.remove(s.charAt(left++));
            }
            maxLen = Math.max(maxLen, window.size());
        }
        return maxLen;
    }
}
