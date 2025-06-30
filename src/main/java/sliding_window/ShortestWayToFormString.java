package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class ShortestWayToFormString {
    public static void main(String[] args) {
        System.out.println(shortestWay("abc","abcbc"));
    }

    public static int shortestWay(String source, String target) {
        int count = 1;
        Set<Character> set = new HashSet<>();
        for (char c : source.toCharArray()){
            set.add(c);
        }
        for (char c : target.toCharArray()){
            if (!set.contains(c)){
                return -1;
            }
        }
        int i = 0; // counter for source
        int j = 0; // counter for target
        while (j < target.length()){
            if (source.charAt(i) == target.charAt(j)){
                i++;
                j++;
            }else {
                i++;
            }
            if (i == source.length() && j < target.length()){
                i = 0;
                count++;
            }
        }

        return count;
    }
}
