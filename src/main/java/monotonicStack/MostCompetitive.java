package monotonicStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MostCompetitive {
    public static void main(String[] args) {
        int[] nums = {2,4,3,3,5,4,9,6};
        System.out.println(Arrays.toString(mostCompetitive(nums, 4)));
    }

    public static int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[k];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && nums[i] < stack.peekLast() && stack.size() + (n - i -1) >= k){
                stack.pollLast();
            }
            if (stack.size() < k){
                stack.addLast(nums[i]);
            }
        }
        int i = 0;
        for (int val : stack) {
            result[i++] = val;
        }

        return result;
    }
}
