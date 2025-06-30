package sliding_window;

import java.util.*;

public class SubStringConcatenation {
    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};
        System.out.println(findSubstring(s,words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) return result;
        Map<String,Integer> wordFreq = new HashMap<>();
        for(String word : words){
            wordFreq.put(word,wordFreq.getOrDefault(word,0)+1);
        }
        int wordLen = words[0].length();
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> currentMap = new HashMap<>();
            while (right + wordLen <= s.length()){
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                if (wordFreq.containsKey(word)){
                    currentMap.put(word,currentMap.getOrDefault(word,0)+1);
                    count++;

                    while (currentMap.get(word) > wordFreq.get(word)){
                        String leftWord = s.substring(left,left + wordLen);
                        currentMap.put(leftWord,currentMap.get(leftWord)-1);
                        count--;
                        left += wordLen;
                    }
                    if (count == words.length){
                        result.add(left);
                    }
                }else {
                    currentMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return result;
    }


}
