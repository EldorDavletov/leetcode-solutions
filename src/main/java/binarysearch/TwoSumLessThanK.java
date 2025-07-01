package binarysearch;

import java.util.Arrays;

public class TwoSumLessThanK {
    public static void main(String[] args) {
        int[] nums = {34,23,1,24,75,33,54,8};
        System.out.println(twoSumLessThanK(nums,60));
    }

    public static int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int max = -1;
        int n = nums.length - 1;

        int left = 0, right = n;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                max = Math.max(max, sum);
                left++;
            } else {
                right--;
            }

        }

        return max;
    }
}
