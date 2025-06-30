package heap;

import java.io.PrintWriter;
import java.util.*;

public class MaxHeapExample {
    public static void main0(String[] args) {
        // Max-heap yaratish uchun PriorityQueue ni Comparator bilan sozlaymiz
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Elementlar qo'shamiz
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(15);

        // Eng katta elementni olish
        System.out.println("Max element: " + maxHeap.peek());  // Output: 20

        // Elementlarni birma-bir chiqarish
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }


        int[] nums = {1,10,3,3,3};
        System.out.println(maxKelements(nums,3));

    }

    public static long maxKelements(int[] nums, int k) {

        long maxScore = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = 1; i <= k; i++) {
            int max = maxHeap.poll();
            maxScore += max;
            maxHeap.add((int)Math.ceil((double) max /3));
        }

        return maxScore;
    }


    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>(
                (a, b) -> map.get(a).equals(map.get(b)) ? a.compareTo(b) : map.get(b) - map.get(a)
        );

        queue.addAll(map.keySet());

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(queue.poll());
        }

        return result;
    }

    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        // 1. So'z chastotalarini hisoblash
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // 2. So'zlarni ro‘yxatga olish
        List<String> wordList = new ArrayList<>(map.keySet());

        // 3. Custom sorting: chastota bo‘yicha kamayish tartibida, agar teng bo‘lsa, alfavit tartibida
        wordList.sort((a, b) -> {
            if (map.get(a).equals(map.get(b))) {
                return a.compareTo(b); // Leksikografik tartib
            }
            return map.get(b) - map.get(a); // Chastota bo‘yicha kamayish tartibida
        });

        // 4. Eng ko‘p uchragan k ta so‘zni olish
        return wordList.subList(0, k);
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][];
        PriorityQueue<int[]> queue = new PriorityQueue<>((point1,point2) ->{
            int d1 = point1[0] * point1[0] +point1[1]*point1[1];
            int d2 = point2[0] * point2[0] +point2[1]*point2[1];
           return Integer.compare(d2,d1);// max heap agarda Integer.compare(d1,d2); bo'lganida edi unda min heap bo'lardi
        });
        for(int[] point: points){
            queue.add(point);

            if (queue.size()>k){
                queue.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }

        return result;
    }

    public static void main11(String[] args) {
        System.out.println(Objects.equals(5,5));
        int[] nums = {10,3,8,9,4};
        System.out.println(Arrays.toString(findRelativeRanks(nums)));

        StringBuilder sb = new StringBuilder();
        sb.append("123");
        sb.insert(0,'9');

        System.out.println(sb);
    }

    public static String[] findRelativeRanks(int[] score) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i],i);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num: score){
            queue.offer(num);
        }
        String[] result = new String[score.length];
        for (int i = 0; i < result.length; i++) {
            result[map.get(queue.poll())] = getRankName(i);
        }
        return result;
    }

    public static String getRankName(int index){
        return switch (index) {
            case 0 -> "Gold Medal";
            case 1 -> "Silver Medal";
            case 2 -> "Bronze Medal";
            default -> String.valueOf(index + 1);
        };
    }

    public static String frequencySort(String s) {
        Map<Character,Integer> freqMap = new HashMap<>();
        for(char c : s.toCharArray()){
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((a,b) ->{
            if (Objects.equals(freqMap.get(a), freqMap.get(b))){
                return a.compareTo(b);
            }
            return Integer.compare(freqMap.get(b),freqMap.get(a));
        });

        queue.addAll(freqMap.keySet());

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()){
            char c = queue.poll();
            result.append(String.valueOf(c).repeat(freqMap.get(c))); // c ni chastota marta qo‘shish
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));

        String[] messages = {"Hello userTwooo","Hi userThree","Wonderful day Alice","Nice day userThree"};
        String[] senders = {"Alice","userTwo","userThree","Alice"};

        System.out.println(largestWordCount(messages,senders));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // Deque: biz faqat indekslarni saqlaymiz

        for (int i = 0; i < n; i++) {
            // 1. Eski elementni (oynadan chiqib ketgan element) o‘chirish
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 2. Deque oxiridan barcha kichik elementlarni o‘chiramiz
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 3. Yangi indeksni deque oxiriga qo‘shamiz
            deque.offerLast(i);

            // 4. Oyna to‘liq shakllangandan keyin maksimumni natijaga qo‘shamiz
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static int[] maxSlidingWindow0(int[] nums, int k) {
        if (nums.length == 1 || k == 1) return nums;
        List<Integer> window = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int max = nums[0];
        for (int num : nums) {
            window.add(num);
            max = Math.max(max, num);
            if (window.size() == k) {
                list.add(max);
                if (max == window.getFirst()){
                    window.removeFirst();
                    max = Collections.max(window);
                }else {
                    window.removeFirst();
                }

            }
        }

        return list.stream().mapToInt(a->a).toArray();
    }


    public static String largestWordCount(String[] messages, String[] senders) {
        Map<String,Integer> freqMap = new HashMap<>();
        int maxCount = 0;
        String senderName = "";
        for (int i = 0; i < messages.length; i++) {
            freqMap.put(senders[i],freqMap.getOrDefault(senders[i],0)+messages[i].split(" ").length);
        }
        for(String sender: freqMap.keySet()){
            if (freqMap.get(sender) > maxCount){
                maxCount = freqMap.get(sender);
                senderName = sender;
            } else if (freqMap.get(sender) == maxCount) {
                senderName = senderName.compareTo(sender) > 0 ? senderName : sender;
            }
        }

        return senderName;
    }

}
