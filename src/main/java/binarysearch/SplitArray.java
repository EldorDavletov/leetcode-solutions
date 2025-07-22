package binarysearch;

import java.util.Arrays;

public class SplitArray {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        SplitArray obj = new SplitArray();

        System.out.println(obj.splitArray(nums,2));
    }

    public int splitArray(int[] nums, int k) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();

        while (left < right){
            int mid = left + (right-left)/2;
            if (canSplit(nums,k,mid)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canSplit(int[] nums, int k, int target){
        int count = 1;
        int sum = 0;
        for (int num : nums){
            if (sum + num <= target){
                sum += num;
            }else {
                sum = num;
                count++;
            }
            if (count > k) return false;
        }
        return true;
    }
}
