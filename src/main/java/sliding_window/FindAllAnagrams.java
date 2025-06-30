package sliding_window;

import java.util.*;

public class FindAllAnagrams {
    public static void main(String[] args) {
        System.out.println(findAnagrams("baa","aa"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for (char c : p.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int n = s.length();
        int valid = 0;
        for (int left = 0, right = 0; right < n; right++){
            char c = s.charAt(right);
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (Objects.equals(window.get(c), need.get(c))){
                    valid++;
                }
                while (window.get(c) > need.get(c)){
                    char c1 = s.charAt(left);
                    if (Objects.equals(window.get(c1), need.get(c1))){
                        valid--;
                    }
                    window.put(c1,window.get(c1)-1);
                    if (window.get(c1) <= 0){
                        window.remove(c1);
                    }
                    left++;
                }

            }else {
                window.clear();
                left = right + 1;
                valid = 0;
            }
            if (valid == need.size()){
                result.add(left);
                char c1 = s.charAt(left);
                if (Objects.equals(window.get(c1), need.get(c1))){
                    valid--;
                }
                window.put(c1,window.get(c1)-1);
                if (window.get(c1) <= 0){
                    window.remove(c1);
                }
                left++;
            }

        }

        return result;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] need = new int[26];
        int[] window = new int[26];

        for (char c : p.toCharArray()) need[c - 'a']++;

        int left = 0, right = 0, matches = 0;

        while (right < s.length()) {
            char rChar = s.charAt(right++);
            window[rChar - 'a']++;

            // Maintain window size == p.length()
            if (right - left > p.length()) {
                char lChar = s.charAt(left++);
                window[lChar - 'a']--;
            }

            if (Arrays.equals(need, window)) {
                result.add(left);
            }
        }

        return result;
    }

}
