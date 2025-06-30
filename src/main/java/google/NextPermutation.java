package google;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int i1 = -1, j1 = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                i1 = i - 1;
                break;
            }
        }
        if (i1 >= 0) {

            for (int i = nums.length - 1; i > i1; i--) {
                if (nums[i] > nums[i1]) {
                    j1 = i;
                    break;
                }
            }
            swap(nums, i1, j1);
            reverse(nums, i1 + 1, nums.length - 1);

        } else {
            reverse(nums, 0, nums.length - 1);
        }
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void reverse(int[] nums, int start, int end){
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
