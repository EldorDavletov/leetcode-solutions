package binarysearch;

import java.util.*;

public class FindKClosestElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(findClosestElements(arr,4,3));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> {
            if (Math.abs(a-x) == Math.abs(b-x)){
                return Integer.compare(a,b);
            }
            return Integer.compare(Math.abs(a-x),Math.abs(b-x));
        });

        for(int num : arr){
            queue.add(num);
        }

        for (int i = 0; i < k; i++) {
            result.add(queue.poll());
        }
        Collections.sort(result);

        return result;
    }


    public static List<Integer> findClosestElements0(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;

        while (left < right) {
            int mid = (left + right) / 2;

            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
