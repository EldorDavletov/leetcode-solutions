package monotonicStack;

import java.util.Stack;

public class SumOfSubArrayMin {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long totalSum = 0;
        int mod = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            int minVal = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minVal = Math.min(minVal, arr[j]);
                totalSum = (totalSum + minVal) % mod;
                System.out.println("min = "+minVal);
            }
        }

        return (int) totalSum;
    }

    public static int sumSubarrayMins0(int[] arr) {
        int MOD = (int)1e9 + 7;
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Count of strictly greater to the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Count of greater or equal to the right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        // Final sum
        long result = 0;
        for (int i = 0; i < n; i++) {
            result = (result + (long)arr[i] * left[i] * right[i]) % MOD;
        }

        return (int) result;
    }

}
