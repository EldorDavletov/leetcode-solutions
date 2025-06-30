package two_pointer;

import java.util.Arrays;

public class NextGreater3 {
    public static void main(String[] args) {
        System.out.println(nextGreaterElement(12345));
    }

    public static int nextGreaterElement(int n) {
        if (n == Integer.MAX_VALUE) return -1;
        String number = String.valueOf(n);
        int len = number.length();
        int[] nums = new int[len];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = number.charAt(i) - '0';
        }
        int idx = -1;
        for (int i = len-2; i >=0 ; i--) {
            if (nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            return -1;
        }

        int j = -1;
        for (int i = len - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                j = i;
                break;
            }
        }

        swap(nums,idx,j);
        reverse(nums,idx + 1,len-1);

        long result = 0;
        for (int num : nums){
            result = (result * 10) + num;
        }

        if (result > Integer.MAX_VALUE) return -1;
        else return (int)result;

    }
    public static void  swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void reverse(int[] nums, int start, int end){
        while (start < end){
            swap(nums,start++,end--);
        }
    }
}
