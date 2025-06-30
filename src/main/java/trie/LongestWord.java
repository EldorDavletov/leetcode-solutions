package trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWord {

    public static void main(String[] args) {
        String[] words = {"a","banana","app","appl","ap","apply","apple"};
        LongestWord obj = new LongestWord();
        System.out.println(obj.longestWord(words));
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
        String word = "";
    }
    TrieNode root = new TrieNode();




    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isWord = true;
        curr.word = word;
    }

    public String longestWord(String[] words) {
        for (String word : words) {
            insert(word);
        }

        String[] result = {""};
        dfs(root, result);
        return result[0];
    }

    private void dfs(TrieNode node, String[] result) {
        if (node == null) return;

        if (!node.word.equals("") && !node.isWord) return; // invalid path

        if (node.word.length() > result[0].length() ||
                (node.word.length() == result[0].length() && node.word.compareTo(result[0]) < 0)) {
            result[0] = node.word;
        }

        for (TrieNode child : node.children) {
            if (child != null && child.isWord) {
                dfs(child, result);
            }
        }
    }





    public static String longestWord0(String[] words){
        Arrays.sort(words);
        String result = "";
        Set<String> set = new HashSet<>();
        for (String word : words){
            if (word.length() == 1 || set.contains(word.substring(0,word.length()-1))){
                set.add(word);
                if (word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0)){
                    result = word;
                }
            }
        }
        return result;
    }
}
