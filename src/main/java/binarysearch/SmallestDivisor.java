package binarysearch;

import java.util.Arrays;

public class SmallestDivisor {
    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        SmallestDivisor obj = new SmallestDivisor();
        System.out.println(obj.smallestDivisor(nums,6));
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();

        while (left <= right){
            int mid = left + (right-left)/2;
            if (isLowerOrEqual(nums,threshold,mid)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isLowerOrEqual(int[] nums,int threshold,int divisor){
        int sum = 0;
        for(int num : nums){
            sum += (num + divisor - 1)/divisor;
        }
        return sum <= threshold;
    }
}
