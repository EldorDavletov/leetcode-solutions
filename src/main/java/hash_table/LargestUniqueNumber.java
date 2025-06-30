package hash_table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LargestUniqueNumber {
    public static void main(String[] args) {
        int[] nums = {5,7,3,9,4,9,8,3,1};
        System.out.println(largestUniqueNumber(nums));
    }

    public static int largestUniqueNumber0(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> {
            if(freq.get(a) == freq.get(b)){
                return b.compareTo(a);
            }else {
                return freq.get(a).compareTo(freq.get(b));
            }
        });
        for (int key : freq.keySet()){
            queue.add(key);
        }

        if (freq.get(queue.peek()) == 1){
            return queue.poll();
        }else return -1;

    }
    public static int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int max = -1;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                max = Math.max(max, entry.getKey());
            }
        }

        return max;

    }


}
