package hash_table;

import binarysearch.RandomPick;

import java.util.*;

public class RandomPickIndex {
    private Map<Integer, List<Integer>> map;

    public RandomPickIndex(int[] nums){
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i],k -> new ArrayList<>()).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int len = list.size();
        Random random = new Random();
        return list.get(random.nextInt(len));
    }
}
