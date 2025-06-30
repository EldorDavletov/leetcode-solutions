package math;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(4,9));
        System.out.println(getPermutation(3,3));
        System.out.println(getPermutation(3,1));
        System.out.println(getPermutation(2,2));
    }

    public static String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        k--; // 0 based
        StringBuilder result = new StringBuilder();
        while (n > 0){
            n--;
            if (n == 0){
                result.append(nums.getFirst());
                break;
            }
            int fact =  factorial(n);
            int index = k/fact;
            result.append(nums.get(index));
            k = k % fact;

            nums.remove(index);

        }

        return result.toString();
    }

    public static String getPermutationOrg(int n, int k) {
        int count = factorial(n-1);
        int startIdx = (k - 1) / count + 1; // ✅ 1-based index
        int rem = (k - 1) % count;          // ✅ 0-based rem

        int[] nums = new int[n-1];
        int ind = 0;
        for (int i = 1; i <= n; i++) {
            if (i != startIdx) nums[ind++] = i;
        }

        for (int i = 0; i < rem; i++) {
            nextPermutation(nums);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(startIdx);
        for (int i = 0; i < n-1; i++) {
            sb.append(nums[i]);
        }

        return sb.toString();

    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
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
