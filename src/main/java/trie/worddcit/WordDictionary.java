package trie.worddcit;
class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
}
public class WordDictionary {
    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word){
        TrieNode node = root;
        for (char c : word.toCharArray()){
            int index = c - 'a';
            if (node.children[index] == null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word){
        return dfsSearch(word,0,root);
    }

    private boolean dfsSearch(String word, int index, TrieNode node){
        if (word.length() == index) return node.isEndOfWord;
        char c = word.charAt(index);
        if (c == '.'){
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null){
                    if(dfsSearch(word,index+1,node.children[i])){
                        return true;
                    }
                }
            }
            return false;
        }else {
            int idx = c - 'a';
            return dfsSearch(word,index+1,node.children[idx]);
        }
    }
}
