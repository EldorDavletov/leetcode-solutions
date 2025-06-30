package binarysearch;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solutions2 {
    public static void main0(String[] args) throws InterruptedException {

        int[] nums={10,9,2,5,3,4,7,101,18};
        System.out.println(lengthOfLISOrginal(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums, Integer.MIN_VALUE, 0);
    }

    private static int lengthOfLIS(int[] nums, int prev, int curpos) {
        if (curpos == nums.length) {
            return 0;
        }

        int taken = 0;
        if (nums[curpos] > prev) {
            taken = 1 + lengthOfLIS(nums, nums[curpos], curpos + 1);
        }

        int nottaken = lengthOfLIS(nums, prev, curpos + 1);

        return Math.max(taken, nottaken);
    }



    public static int lengthOfLIS0(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        int maxLength = 1;

        // Har bir elementning boshlang'ich qiymati 1 bo'ladi,
        // chunki har bir elementning o'zi alohida ketma-ketlik bo'lishi mumkin.
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        System.out.println(Arrays.toString(dp));
        return maxLength;
    }


   public static int findLISStartingAt(int[] nums, int i) {
        // Agar i massiv chegarasidan chiqib ketgan bo'lsa, 0 qaytaramiz
        if (i == nums.length) return 0;

        int maxLength = 1; // Har bir element o'zini o'zidan minimum 1 uzunlikka ega

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                maxLength = Math.max(maxLength, 1 + findLISStartingAt(nums, j));
            }
        }

        return maxLength;
    }

   public static int findLIS(int[] nums) {
        int maxLIS = 0;

        // Har bir element uchun ketma-ketlikni ko'rib chiqamiz
        for (int i = 0; i < nums.length; i++) {
            maxLIS = Math.max(maxLIS, findLISStartingAt(nums, i));
        }

        return maxLIS;
    }



    public static int lengthOfLISOrginal(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        int length = 0;

        for (int num : nums) {
            int left = 0, right = length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            dp[left] = num;
            if (left == length) length++;
        }

        return length;
    }



    public static int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // n - mid bu qog'ozlar soni, citations[mid] bu citationlar soni
            if (citations[mid] == n - mid) {
                return n - mid;  // Perfect match topildi
            } else if (citations[mid] < n - mid) {
                left = mid + 1;  // Ko'proq citation kerak, o'ngga o'tamiz
            } else {
                right = mid - 1;  // Kamroq citation kerak, chapga o'tamiz
            }
        }

        return n - left;  // H-Index bu left pozitsiyasi bo'yicha hisoblanadi
    }

    public static void main(String[] args) {
        int[] nums = IntStream.range(1,10).toArray();
        System.out.println(Arrays.toString(nums));
        System.out.println(triangleNumber(nums));
    }


    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        for (int k = nums.length - 1; k >= 2; k--) { // k katta tomon
            int left = 0, right = k - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[k]) { // agar uchburchak tengsizligi qanoatlanadi
                    count += right - left;  // left dan right gacha bo'lgan barcha juftliklar
                    right--;  // right ni kichiklashtiramiz
                } else {
                    left++;  // left ni oshiramiz, qidirishni davom ettiramiz
                }
            }
        }

        return count;
    }
}
