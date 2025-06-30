package binarysearch;

import java.util.Arrays;

public class NumberOfSubSeq {
    public static void main(String[] args) {
        int[] nums = {2,3,5,6,7};
        System.out.println(numSubseq(nums,9));
    }

    public static int numSubseq(int[] nums, int target) {
        int MOD = 1_000_000_007;
        Arrays.sort(nums);
        int n = nums.length;

        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1;
        int result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + pow[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
