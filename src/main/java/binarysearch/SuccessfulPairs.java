package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public record SuccessfulPairs() {
    public static void main(String[] args) {
        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};

         int[] spells2 = {3,1,2};
        int[] potions2 = {8,5,8};


//        System.out.println(binarySearch(potions2,16));

        System.out.println(Arrays.toString(successfulPairs2(spells, potions, 7)));
        System.out.println(Arrays.toString(successfulPairs2(spells2, potions2, 16)));

    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            long target = (long) Math.ceil((double) success /spells[i]);
            int index = binarySearch0(potions,target);
            result[i] = potions.length-index;
        }

        return result;
    }

    public static int[] successfulPairs2(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); // Potions massivini saralaymiz
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        // Multithreading uchun ExecutorService yaratamiz
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            final int index = i;
            Callable<Integer> task = () -> {
                long target = (success + spells[index] - 1) / spells[index];
                int count = binarySearch(potions, target,m);
                return count;
            };
            futures.add(executor.submit(task));
        }

        // Natijalarni yig'amiz
        for (int i = 0; i < n; i++) {
            try {
                result[i] = futures.get(i).get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // ExecutorService ni yopamiz
        executor.shutdown();

        return result;
    }

    public static int binarySearch0 (int[] nums, long target){
        int left = 0, right = nums.length-1;
        while (left<=right){
            int mid = (left + right)/2;
            if (nums[mid]>=target){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }
    private static int binarySearch(int[] potions, long target, int m) {
        int left = 0, right = m;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return m - left; // muvaffaqiyatli juftliklar soni
    }
}
