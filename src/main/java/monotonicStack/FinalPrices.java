package monotonicStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FinalPrices {
    public static void main(String[] args) {
        int[] prices = {8,4,6,2,3};
        Object arr[][] = new Object[][] {new String[5], {} };
        System.out.println(Arrays.toString(finalPrices(prices)));
    }

    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = prices.clone();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]){
                int idx = stack.pop();
                result[idx] = prices[idx] - prices[i];
            }
            stack.push(i);
        }

        return result;
    }
    public static int[] finalPrices2(int[] prices) {
        int n = prices.length;
        int[] result = prices.clone();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (prices[j] <= prices[i]){
                    result[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return result;
    }


}
