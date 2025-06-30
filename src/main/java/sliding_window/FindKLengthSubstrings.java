package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class FindKLengthSubstrings {
    public static void main(String[] args) {
        String s = "havefunonleetcode";
        System.out.println(numKLenSubstrNoRepeats(s,5));
    }

    public static int numKLenSubstrNoRepeats(String s, int k) {
        int count = 0;
        Set<Character> window = new HashSet<>();
        for(int left = 0,right = 0; right < s.length(); right++){
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left++));
            }
            window.add(s.charAt(right));

            if (window.size() == k) {
                count++;
                window.remove(s.charAt(left++));
            }
        }

        return count;
    }
}
