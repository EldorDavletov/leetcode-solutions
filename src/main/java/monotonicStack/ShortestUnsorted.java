package monotonicStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class ShortestUnsorted {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int[] nums2 = nums.clone();
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right && nums[left] == nums2[left]){
            left++;
        }
        if (left == right) return 0;
        while (right > 0 && nums[right] == nums2[right]){
            right--;
        }
        if (right >= left) return right-left+1;
        return nums.length;
    }

    public static int findUnsortedSubarray0(int[] nums) {
        int n = nums.length;
        int left = n, right = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        // Chapdan o‘ngga: noto‘g‘ri joylashgan minimumlarni aniqlash
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }

        stack.clear(); // Endi stackni yana ishlatamiz

        // O‘ngdan chapga: noto‘g‘ri joylashgan maximumlarni aniqlash
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }

        return (right > left) ? right - left + 1 : 0;
    }

}
