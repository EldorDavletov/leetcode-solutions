package sliding_window;

import java.util.Arrays;

public class MinimumDifference {
    public static void main(String[] args) {
        int[] nums = {9,1,4,7};
        System.out.println(minimumDifference(nums,2));
    }

    public static int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        if (n == 1 || k == 1) return 0;
        Arrays.sort(nums);
        int minDiff = nums[n-1];
        for (int left = 0, right = 0; right < n; right++) {
            if (right - left + 1 == k){
                minDiff = Math.min(minDiff, nums[right]-nums[left]);
                left++;
            }
        }
        
        return minDiff;
    }
}
