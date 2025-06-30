package trie;


public class WordDictionary {
    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word){
        TrieNode node = root;
        for (char c : word.toCharArray()){
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }
        node.isEndOfWord = true;
    }
     public boolean search(String word){
        return dfsSearch(word,0,root);
     }

     private boolean dfsSearch(String word,int index,TrieNode node){
        if (word.length() == index) return node.isEndOfWord;
        char c = word.charAt(index);
        if (c == '.'){
            for (char ch : node.children.keySet()){
                TrieNode child = node.children.get(ch);
                if (dfsSearch(word,index+1,child)) return true;
            }
            return false;
        }else {
            TrieNode next = node.children.get(c);
            if (next == null) return false;
            return dfsSearch(word,index+1,next);
        }
     }
}
