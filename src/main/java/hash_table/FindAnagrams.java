package hash_table;

import java.util.*;

public class FindAnagrams {
    public static void main(String[] args) {
        int[] nums1 = {12,28,46,32,50};
        int[] nums2 = {50,12,32,46,28};
        System.out.println(Arrays.toString(anagramMappings(nums1, nums2)));
    }

    public static int[] anagramMappings(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] result = new int[n];
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            Queue<Integer> queue = map.getOrDefault(nums2[i], new LinkedList<>());
            queue.add(i);
            map.put(nums2[i],queue);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]).poll();
        }
        return result;
    }
}
