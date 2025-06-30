package ds;

import java.util.*;

public class HeapExamples {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};

//        System.out.println(findKthLargest(nums,4));
        System.out.println(topKFrequent(nums,2));

    }


    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            if (heap.size()>k){
                heap.poll();
            }
        }

        System.out.println(heap);

        return heap.peek();
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        Map<Integer,Integer> map = new TreeMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])){
//                map.replace(nums[i],map.get(nums[i]),map.get(nums[i])+1);
//            }else {
//                map.put(nums[i],1);
//            }
//        }
        for (int num : nums) {
            // Agar element map'da bo'lmasa, 0 dan boshlaymiz, bo'lsa, 1 ga oshiramiz
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        for(int num: map.keySet()){
            queue.add(num);
            if (queue.size()>k){
                queue.poll();
            }
        }

        int i=0;
        while (!queue.isEmpty()){
            result[i] = queue.poll();
            i++;
        }

        Arrays.stream(result).forEach(System.out::println);


        return result;
    }

    public static void main1(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(5);
        minHeap.add(6);
        minHeap.add(3);
        minHeap.add(3);
        minHeap.add(2);
        minHeap.add(2);

        System.out.println(minHeap);
        while (!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }
    }
}
