package hash_table;

import java.util.HashMap;
import java.util.Map;

public class SingleRowKeyboard {
    public static void main(String[] args) {
        System.out.println(calculateTime0("pqrstuvwxyzabcdefghijklmno","leetcode"));
    }

    public static int calculateTime(String keyboard, String word) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i),i+1);
        }
        int prev = 1, count = 0;
        for(char c : word.toCharArray()){
            count += Math.abs(prev - map.get(c));
            prev = map.get(c);
        }

        return count;
    }

    public static int calculateTime0(String keyboard, String word) {
        int[] pos = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            pos[keyboard.charAt(i) - 'a'] = i;
        }

        int prev = 0;
        int count = 0;
        for (char c : word.toCharArray()) {
            int curr = pos[c - 'a'];
            count += Math.abs(curr - prev);
            prev = curr;
        }

        return count;
    }

}
