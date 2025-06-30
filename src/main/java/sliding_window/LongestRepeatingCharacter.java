package sliding_window;

public class LongestRepeatingCharacter {
    public static void main(String[] args) {
//        System.out.println(characterReplacement("ABAABBBB",2));
//        System.out.println(characterReplacement("ABAA",1));
        System.out.println(characterReplacement("ABBBA",2));
    }

    public static int characterReplacement(String s, int k) {
        int maxLen = 1;
        int left = 0, right = 0, max = 0;
        int[] freq = new int[26];
        while (right < s.length()){
            char c = s.charAt(right);
            freq[c-'A']++;
            max = Math.max(max,freq[c-'A']);

            while ((right-left+1) - max > k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }

    public static int longestRepeatingSubstringNoChange(String s) {
        int maxLen = 1;
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            maxLen = Math.max(maxLen, count);
        }

        return maxLen;
    }

}
