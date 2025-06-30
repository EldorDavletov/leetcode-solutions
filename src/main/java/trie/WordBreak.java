package trie;


import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet","code")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict){
            trie.insert(word);
        }
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;
            for (int end : trie.getMatchingEnds(s,i)){
                dp[end] = true;
            }
        }
        return dp[n];
    }


}
