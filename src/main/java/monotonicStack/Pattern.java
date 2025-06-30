package monotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pattern {
    public static void main(String[] args) {
        int[] nums = {3,1,4,2};
        System.out.println(find132pattern(nums));
    }

    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        if(n < 3) return false;
        Deque<Integer> stack = new ArrayDeque<>();
        int third = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third){
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()){
                third = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
