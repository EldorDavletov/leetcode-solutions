package sliding_window;

import java.util.*;

public class CountGoodSubArrays {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(countGood(nums,10));
    }

    public static long countGood(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        long count = 0;
        long pairs = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            int freq = freqMap.getOrDefault(val, 0);

            // Qo‘shilayotgan element bilan yangi pairlar
            pairs += freq;
            freqMap.put(val, freq + 1);

            // Agar k ta yoki undan ko‘p pairlar bo‘lsa, leftni o‘ngga suramiz
            while (pairs >= k) {
                count += nums.length - right;
                int leftVal = nums[left];
                int leftFreq = freqMap.get(leftVal);
                pairs -= leftFreq - 1;
                freqMap.put(leftVal, leftFreq - 1);
                left++;
            }
        }

        return count;
    }
}
