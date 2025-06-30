package sliding_window;

import java.util.*;

public class Sum3 {
    public static void main0(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicates
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,9};
        System.out.println(arithmeticTriplets(nums,2));
    }

    public static int arithmeticTriplets0(int[] nums, int diff) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            int count = 1;
            int j = i+1;
            while (count < 3 && j < nums.length){
                if (nums[j] - nums[index] == diff){
                    index = j;
                    j = index;
                    count++;
                }
                j++;
            }
            if (count == 3){
                result++;
            }
        }
        return result;
    }

    public static int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        int result = 0;

        for (int num : nums) {
            if (set.contains(num - diff) && set.contains(num - 2 * diff)) {
                result++;
            }
            set.add(num);
        }

        return result;
    }
}
