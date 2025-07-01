package hash_table;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmonious {
    public static void main(String[] args) {

    }


    public int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int maxLen = 0;
        for (int key : map.keySet()){
            if (map.containsKey(key+1)) {
                maxLen = Math.max(maxLen, map.get(key) + map.get(key + 1));
            }
        }
        return maxLen;
    }
}

