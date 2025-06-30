package hash_table;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

    }

    public static char repeatedCharacter(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
            if (map.get(c)>1){
                return c;
            }
        }
        return '0';
    }

    public char repeatedCharacter0(String s) {
        boolean[] seen = new boolean[128]; // ASCII assumption
        for (char c : s.toCharArray()) {
            if (seen[c]) return c;
            seen[c] = true;
        }
        return '0';
    }

    public char repeatedCharacter2(String s) {
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!seen.add(c)) return c;
        }
        return '0';
    }

}
