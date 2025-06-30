package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartition {
    public static void main(String[] args) {
        String str = "aabbaa";

        System.out.println(partition(str));

    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int start, List<String> path, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));
                backtrack(s, end + 1, path, result);
                path.remove(path.size() - 1);          // backtrack: oxirgi elementni olib tashlash
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }


    public static int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int maxLen = 0;
        boolean hasOdd = false;
        for (int freq : map.values()){
            if (freq%2==0){
                maxLen += freq;
            }else {
                maxLen += freq - 1;
                hasOdd = true;
            }
        }
        if (hasOdd) maxLen += 1;
        return maxLen ;
    }

    public static boolean canPermutePalindrome(String s) {
        int[] freq = new int[128];
        for(char c : s.toCharArray()){
            freq[c]++;
        }
        int len = 0;
        int odd = 0;
        for(int count : freq){
            if (count%2 == 0){
                len += count;
            }else {
                odd = count;
            }
        }

        return len == s.length() || len+odd == s.length();
    }
}

