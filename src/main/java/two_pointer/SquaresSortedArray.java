package two_pointer;

import java.util.Arrays;

public class SquaresSortedArray {
    public static void main(String[] args) {
//        int[] nums1 = {-4,-1,0,3,10};
        int[] nums2 = {-7,-3,2,3,11};
//        System.out.println(Arrays.toString(sortedSquares(nums1)));
        System.out.println(Arrays.toString(sortedSquares(nums2)));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1, min = nums[0] * nums[0];
        int index = right;
        while (left<right){
            int leftSquare = nums[left]*nums[left];
            int rightSquare = nums[right]*nums[right];
            if (rightSquare>leftSquare){
                right--;
                result[index--] = rightSquare;
                min = leftSquare;
            }else {
                left++;
                result[index--] = leftSquare;
                min = rightSquare;
            }
        }
        result[0] = min;
        return result;
    }
}
