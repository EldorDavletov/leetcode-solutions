package hash_table;

public class FindWords {
    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        System.out.println(countCharacters(words,"atach"));
    }

    public static int countCharacters(String[] words, String chars) {
        int count = 0;
        int[] freq = new int[127];
        for (char c : chars.toCharArray()){
            freq[c]++;
        }
        for(String word : words){
            int[] wordFreq = new int[127];
            for (char c : word.toCharArray()){
                wordFreq[c]++;
            }
            boolean has = true;
            for (char c : word.toCharArray()){
                if (freq[c] < wordFreq[c]){
                    has = false;
                    break;
                }
            }
            if (has){
                count += word.length();
            }
        }
        return count;
    }
}
