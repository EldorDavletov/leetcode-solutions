package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("ab",1));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int  maxLen = 0;
        Map<Character,Integer> freq = new HashMap<>();
        for(int left = 0, right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            freq.put(c,freq.getOrDefault(c,0)+1);
            while (freq.size() > k){
                char leftChar = s.charAt(left++);
                freq.put(leftChar,freq.get(leftChar)-1);
                if (freq.get(leftChar) == 0){
                    freq.remove(leftChar);
                }
            }
            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }


}
