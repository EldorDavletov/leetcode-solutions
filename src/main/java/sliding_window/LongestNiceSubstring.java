package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring {
    public static void main(String[] args) {
        String s = "YazaAay";
        System.out.println(longestNiceSubstring(s));
    }

    public static String longestNiceSubstring(String s) {
        return helper(s,0,s.length());
    }
    private static String helper(String s, int start, int end){
        if (end - start < 2) return "";

        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            set.add(s.charAt(i));
        }

        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (set.contains(Character.toLowerCase(c)) && set.contains(Character.toUpperCase(c))){
                continue;
            }

            String left = helper(s,start,i);
            String right = helper(s,i+1,end);

            return left.length() >= right.length() ? left : right;
        }

        return s.substring(start,end);

    }
}
