package sliding_window;

import java.util.Arrays;
import java.util.List;

public class MinimumPositiveSum {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5,8,-6);
        System.out.println(minimumSumSubarray(nums,1,3));
    }

    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0, sum = 0;

        // Subarray uzunligi == l bo'lganlar
        while (right < nums.size()) {
            sum += nums.get(right);
            int len = right - left + 1;
            if (len == l) {
                if (sum > 0) {
                    min = Math.min(min, sum);
                }
                sum -= nums.get(left++);
            }
            right++;
        }

        // Subarray uzunligi > l && <= r bo'lganlar
        left = 0;
        right = 0;
        sum = 0;
        while (right < nums.size()) {
            sum += nums.get(right);
            int len = right - left + 1;
            if (len > l && len <= r) {
                if (sum > 0) {
                    min = Math.min(min, sum);
                }
            }
            if (len > r) {
                sum -= nums.get(left++);
            }
            right++;
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static int minimumSumSubarray0(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minSum = Integer.MAX_VALUE;
        for (int len = l; len <= r; len++) {
            int windowSum = 0;
            for (int i = 0; i < len; i++) {
                windowSum += nums.get(i);
            }
            if (windowSum > 0) minSum = Math.min(minSum, windowSum);

            for (int i = len; i < n; i++) {
                windowSum += nums.get(i) - nums.get(i - len);
                if (windowSum > 0) minSum = Math.min(minSum, windowSum);
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }


}
