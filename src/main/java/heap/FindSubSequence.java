package heap;

import java.util.*;

public class FindSubSequence {
    public static void main(String[] args) {

    }

    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = i;       // indeks
            arr[i][1] = nums[i]; // qiymat
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));

        List<int[]> topK = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            topK.add(arr[i]);
        }

        topK.sort(Comparator.comparingInt(a -> a[0]));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK.get(i)[1];
        }

        return result;
    }

    public int[] maxSubsequence2(int[] nums, int k) {
        // Min-heap: eng kichik element tepada turadi
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1])  // qiymat bo'yicha sort
        );

        // Heapga (indeks, qiymat) qo'shamiz
        for (int i = 0; i < nums.length; i++) {
            heap.offer(new int[]{i, nums[i]});
            if (heap.size() > k) {
                heap.poll();  // eng kichik elementni olib tashlaymiz
            }
        }

        // Endi heapda eng katta k ta element bor
        List<int[]> list = new ArrayList<>(heap);

        // Subsequence bo'lishi uchun index bo‘yicha sort
        list.sort(Comparator.comparingInt(a -> a[0]));

        // Natija array yasaymiz
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i)[1];
        }

        return result;
    }
}
