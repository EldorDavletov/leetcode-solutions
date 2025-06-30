package string;

public class LongestPalindrome {
    private static int maxLen, start;
    public static String longestPalindrome(String s) {
        if (s.length()<=1) return s;

        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s,i,i);// satr uzunligi toq bulganda
            expandAroundCenter(s,i,i+1); // satr uzunligi juft bulganda
        }

        return s.substring(start, start+maxLen);
    }

    public static void expandAroundCenter (String s, int left, int right){
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        if (maxLen<right-left-1) {
            start = left + 1;
            maxLen = right-left-1;
        }
    }
}
