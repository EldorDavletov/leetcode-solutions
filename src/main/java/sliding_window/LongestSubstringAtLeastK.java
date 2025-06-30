package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtLeastK {

    public static void main(String[] args) {
        System.out.println(longestSubstring("bbaaacbd",3));
    }

    public static int longestSubstring(String s, int k) {
        if (k == 1) return s.length();

        int n = s.length();
        Map<Character,Integer> freq = new HashMap<>();
        StringBuilder window = new StringBuilder();
        for(char c: s.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (freq.get(c) < k){
                maxLen = Math.max(maxLen,getValidLen(window.toString(),k));
                window.setLength(0);
            }else {
                window.append(c);
            }
        }
        maxLen = Math.max(maxLen, getValidLen(window.toString(), k));
        return maxLen;
    }

    private static int getValidLen(String sub, int k){
        int[] freq = new int[26];
        for (char c : sub.toCharArray()){
            freq[c-'a']++;
        }
        for (int val : freq){
            if (val < k && val > 0) return 0;
        }

        return sub.length();
    }


    public static int longestSubstring2(String s, int k) {
        int maxLen = 0;
        int n = s.length();

        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {
            int[] freq = new int[26];
            int left = 0, right = 0;
            int unique = 0;      // window ichidagi unique harflar
            int countAtLeastK = 0; // k martadan ko'p bo'lganlar

            while (right < n) {
                if (unique <= targetUnique) {
                    int idx = s.charAt(right) - 'a';
                    if (freq[idx] == 0) unique++;
                    freq[idx]++;
                    if (freq[idx] == k) countAtLeastK++;
                    right++;
                } else {
                    int idx = s.charAt(left) - 'a';
                    if (freq[idx] == k) countAtLeastK--;
                    freq[idx]--;
                    if (freq[idx] == 0) unique--;
                    left++;
                }

                if (unique == targetUnique && unique == countAtLeastK) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
        }

        return maxLen;
    }

    public static int longestSubstring3(String s, int k) {
        return helper(s, k, 0, s.length());
    }

    private static int helper(String s, int k, int start, int end) {
        if (end - start < k) return 0;

        // Harflar chastotasi
        int[] freq = new int[26];
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int mid = start; mid < end; mid++) {
            // Agar bu harf kam qatnashgan bo‘lsa → valid substring bo‘lolmaydi
            if (freq[s.charAt(mid) - 'a'] < k) {
                int midNext = mid + 1;
                while (midNext < end && freq[s.charAt(midNext) - 'a'] < k) {
                    midNext++;
                }
                // Rekursiv ikkiga bo‘lamiz
                return Math.max(helper(s, k, start, mid), helper(s, k, midNext, end));
            }
        }

        // Hamma harflar kamida k marta qatnashgan
        return end - start;
    }

}
