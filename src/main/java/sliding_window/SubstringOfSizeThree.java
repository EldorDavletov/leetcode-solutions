package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class SubstringOfSizeThree {
    public static void main(String[] args) {
        String s = "xyzzaz";
        System.out.println(countGoodSubstrings(s));
    }

    public static int countGoodSubstrings(String s) {
        int count = 0;
        int left = 0, right = 0;
        Set<Character> window = new HashSet<>();
        while (right < s.length()){
            char c = s.charAt(right);
            while (!window.add(c)){
                window.remove(s.charAt(left++));
            }

            if (window.size() == 3){
                count++;
                window.remove(s.charAt(left++));
            }
            right++;

        }
        return count;
    }
}
