package trie;

public class MaxXor {
    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    public static void main(String[] args) {
        int[] nums = {3,10,5,25,2,8};
        MaxXor obj = new MaxXor();
        System.out.println(obj.findMaximumXOR(nums));
    }

    TrieNode root = new TrieNode();

    public void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    public int findMaxXOR(int num) {
        TrieNode node = root;
        int xor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            int toggledBit = 1 - bit; // opposite bit
            if (node.children[toggledBit] != null) {
                xor |= (1 << i); // set bit
                node = node.children[toggledBit];
            } else {
                node = node.children[bit];
            }
        }
        return xor;
    }

    public int findMaximumXOR(int[] nums) {
        for (int num : nums) {
            insert(num);
        }

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, findMaxXOR(num));
        }

        return max;
    }
}
