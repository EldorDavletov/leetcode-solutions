package monotonicStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ShortestSubArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,10,0,7,8,9};
        System.out.println(findLengthOfShortestSubarray(arr));
    }

    public static int findLengthOfShortestSubarray(int[] arr) {
        int count = 0;
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(n-1);
        for (int i = n-2; i >= 0; i--) {
            if (arr[i] <= arr[stack.peek()]){
                stack.push(i);
            }else {
                break;
            }
        }
        if (stack.size() == n) return count;

        count = stack.peek();

        for (int i = 0; i < n; i++) {
            if (i>0 && arr[i] < arr[i-1]) break;
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                stack.pop();
            }
            if (!stack.isEmpty()){
                count = Math.min(count,stack.peek()-i-1);
            }else {
                count = Math.min(count,n-i-1);
            }
        }

        return count;

    }

    public static int findLengthOfShortestSubarray2(int[] arr) {
        int n = arr.length;
        int left = 0;

        // Step 1: Find leftmost sorted prefix
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }


        if (left == n - 1) return 0;

        // Step 2: Find rightmost sorted suffix
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // Step 3: Minimum deletion — ya o‘rtani olib tashlash yoki prefix/suffix dan birini
        int result = Math.min(n - left - 1, right); // to‘liq leftni yoki rightni olib tashlash

        // Step 4: Two pointer bilan birlashtirish imkoniyatini tekshirish
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1); // i+1 dan j-1 gacha bo‘lgan oraliqni olib tashlaymiz
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}
