package heap;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestSubArray {
    public static void main(String[] args) {
        int[] nums = {84,-37,32,40,95};

        System.out.println(shortestSubarray(nums,167));
    }

    public static int shortestSubarray0(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        long sum = 0;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            queue.add(num);
            sum += num;
            while (!queue.isEmpty() && sum >= k) {
                min = Math.min(min, queue.size());
                sum -= queue.poll();
            }
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1]; // Prefix sum array
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> deque = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            // 1. Eng chapdagi elementni olib tashlash (agar u `k` ga yetarli bo‘lsa)
            while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }

            // 2. Deque oxiridan keraksiz elementlarni o‘chirish (optimal yechim uchun)
            while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }

            // 3. Hozirgi indeksni deque'ga qo‘shish
            deque.addLast(i);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
