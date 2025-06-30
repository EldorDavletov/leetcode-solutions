package binarysearch;

import java.util.Arrays;

public class TwoSum2 {
    public static void main(String[] args) {
        int[] nums = {2,3,4};
//        System.out.println(Arrays.binarySearch(nums,3,nums.length-1,4));
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            int index = Arrays.binarySearch(numbers,i+1,numbers.length,complement);
            if (index>0) return new int[]{i+1,index+1};
        }
        return null;
    }

    public int[] twoSum0(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) return new int[]{left + 1, right + 1};
            else if (sum < target) left++;
            else right--;
        }
        return null;
    }

}
