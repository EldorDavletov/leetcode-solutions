package dp;

public class MaxRepeatingSubstring {
    public static void main(String[] args) {
        System.out.println(maxRepeating("ababc","ab"));
    }

    public static int maxRepeating(String sequence, String word) {
        int k = sequence.length()/word.length();
        while (!sequence.contains(word.repeat(k))){
            k--;
        }
        return k;
    }

    public static int dfs(String seq,String word, int k){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(word);
        }
        if (seq.contains(sb)){
            return dfs(seq,word,k+1);
        }else {
            return k-1;
        }
    }
}
