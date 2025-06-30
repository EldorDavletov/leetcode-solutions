package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithKDifferent {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        System.out.println(atMostK(nums,2));
        System.out.println(atMostK(nums,1));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums,k) - atMostK(nums,k-1);
    }

    public static int atMostK(int[] nums, int k){
        int count = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int left = 0, right = 0; right < nums.length; right++){
            freq.put(nums[right],freq.getOrDefault(nums[right],0)+1);
            while (freq.size() > k){
                freq.put(nums[left], freq.get(nums[left]) -1);
                if (freq.get(nums[left]) == 0){
                    freq.remove(nums[left]);
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }


}
