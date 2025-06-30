package hash_table;

import java.util.*;

public class SentenceSimilarity {
    public static void main(String[] args) {
        String[] sentence1 = {"great","acting","skills"};
        String[] sentence2 = {"fine","drama","talent"};
        List<List<String>> list = Arrays.asList(
                Arrays.asList("great", "fine"),
                Arrays.asList("acting", "drama"),
                Arrays.asList("skills", "talent")
        );
        System.out.println(areSentencesSimilar(sentence1,sentence2,list));
    }

    public static boolean areSentencesSimilar0(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        Set<String> similarSet = new HashSet<>();
        for (List<String> pair : similarPairs) {
            similarSet.add(pair.get(0) + "#" + pair.get(1));
            similarSet.add(pair.get(1) + "#" + pair.get(0)); // symmetric
        }

        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) continue;
            if (!similarSet.contains(sentence1[i] + "#" + sentence2[i])) return false;
        }

        return true;
    }

    public static boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        Map<String, Set<String>> map = new HashMap<>();

        for (List<String> pair : similarPairs) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);

            map.computeIfAbsent(word1, k -> new HashSet<>()).add(word2);
            map.computeIfAbsent(word2, k -> new HashSet<>()).add(word1);
        }

        for (int i = 0; i < sentence1.length; i++) {
            String w1 = sentence1[i];
            String w2 = sentence2[i];
            if (w1.equals(w2)) continue;
            if (!map.containsKey(w1) || !map.get(w1).contains(w2)) return false;
        }

        return true;
    }


}
