package hash_table;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }

        int maxLen = 0;
        for (int num : set){
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int len = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    len++;
                }

                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}
