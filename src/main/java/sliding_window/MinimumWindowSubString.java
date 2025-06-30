package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        if (t.length()>s.length()) return "";
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        int left = 0, right = 0,  valid = 0, start = 0, minLen = Integer.MAX_VALUE;
        for(char c : t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);

    }

    public String minWindow0(String s, String t) {
        if (s.length() < t.length()) return "";

        String result = "";
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (containsAll(sub, t)) {
                    if (sub.length() < minLen) {
                        minLen = sub.length();
                        result = sub;
                    }
                }
            }
        }
        return result;
    }

    private static boolean containsAll(String sub, String t) {
        Map<Character, Integer> subCount = new HashMap<>();
        for (char c : sub.toCharArray()) {
            subCount.put(c, subCount.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            subCount.put(c, subCount.getOrDefault(c, 0) - 1);
            if (subCount.get(c) < 0) return false;
        }

        return true;
    }
}
