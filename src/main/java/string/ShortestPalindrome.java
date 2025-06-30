package string;

public class ShortestPalindrome {

    public static void main(String[] args) {
        String s = "abad";
        System.out.println(shortestPalindrome(s));
    }

    public String shortestPalindrome0(String s) {
        int length = s.length();
        String reversedString = new StringBuilder(s).reverse().toString();

        // Iterate through the string to find the longest palindromic prefix
        for (int i = 0; i < length; i++) {
            if (s.substring(0, length - i).equals(reversedString.substring(i))) {
                return reversedString.substring(0, i) + s;
            }
        }
        return "";
    }

    public static String shortestPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reversed;

        int[] lps = new int[combined.length()];
        for (int i = 1; i < combined.length(); i++) {
            int len = lps[i - 1];
            while (len > 0 && combined.charAt(i) != combined.charAt(len)) {
                len = lps[len - 1];
            }
            if (combined.charAt(i) == combined.charAt(len)) {
                len++;
            }
            lps[i] = len;
        }

        int palPrefixLen = lps[combined.length() - 1];
        String suffix = s.substring(palPrefixLen);
        String prefixToAdd = new StringBuilder(suffix).reverse().toString();
        return prefixToAdd + s;
    }
}
