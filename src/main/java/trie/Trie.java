package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
    int wordCount = 0;
    int prefixCount = 0;
}
public class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode node = root;
        for (char ch : word.toCharArray()){
            node = node.children.computeIfAbsent(ch, character -> new TrieNode());
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word){
        TrieNode node = root;
        for (char ch : word.toCharArray()){
            if (!node.children.containsKey(ch)) return false;
            node = node.children.get(ch);
        }
        return node.isEndOfWord;
    }

    boolean startsWith(String prefix){
        TrieNode node = root;
        for (char ch : prefix.toCharArray()){
            if (!node.children.containsKey(ch)) return false;
            node = node.children.get(ch);
        }
        return true;
    }

    void printTree() {
        printNode(root, "", true);
    }

    private void printNode(TrieNode node, String prefix, boolean isLast) {
        if (prefix.isEmpty()) {
            System.out.println("(root)");
        }

        List<Character> keys = new ArrayList<>(node.children.keySet());
        for (int i = 0; i < keys.size(); i++) {
            char ch = keys.get(i);
            TrieNode child = node.children.get(ch);
            boolean lastChild = (i == keys.size() - 1);

            System.out.print(prefix);
            if (isLast) {
                System.out.print("└── ");
            } else {
                System.out.print("├── ");
            }

            System.out.print(ch);
            if (child.isEndOfWord) System.out.print(" *");
            System.out.println();

            // Recursive chaqiriq — keyingi level
            printNode(child, prefix + (isLast ? "    " : "│   "), lastChild);
        }
    }


    List<Integer> getMatchingEnds(String s, int start) {
        List<Integer> ends = new ArrayList<>();
        TrieNode node = root;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!node.children.containsKey(c)) break;
            node = node.children.get(c);
            if (node.isEndOfWord) ends.add(i + 1); // end position of match
        }
        return ends;
    }

    int countWordsEqualTo(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) return 0;
            node = node.children.get(ch);
        }
        return node.wordCount;
    }

    int countWordsStartingWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.children.containsKey(ch)) return 0;
            node = node.children.get(ch);
        }
        return node.prefixCount;
    }

    // 📛 So‘zni o‘chirish (agar mavjud bo‘lsa)
    boolean erase(String word) {
        return eraseHelper(root, word, 0);
    }

    private boolean eraseHelper(TrieNode node, String word, int index) {
        if (index == word.length()) {
            if (node.wordCount == 0) return false; // so‘z yo‘q
            node.wordCount--;
            return true;
        }

        char ch = word.charAt(index);
        TrieNode child = node.children.get(ch);
        if (child == null) return false;

        boolean shouldDelete = eraseHelper(child, word, index + 1);
        if (shouldDelete) {
            child.prefixCount--;
            if (child.prefixCount == 0 && child.wordCount == 0) {
                node.children.remove(ch); // foydasiz bo‘lsa o‘chir
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("app"));
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
        trie.printTree();
        trie.insert("appbox");
        System.out.println(trie.search("app"));
        trie.printTree();
    }
}
