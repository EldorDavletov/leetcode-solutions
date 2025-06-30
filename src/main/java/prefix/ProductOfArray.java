package prefix;

import java.util.Arrays;

public class ProductOfArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        suffix[n-1] = 1;
        for (int i = n-2; i >= 0 ; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = prefix[i]*suffix[i];
        }

        return result;

    }
}
