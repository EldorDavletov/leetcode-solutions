package sliding_window;

public class MaxConsecutiveOnes2 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
        System.out.println(longestOnes(nums,3));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, flipCount = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (nums[right] == 0){
                flipCount++;
            }
            while (flipCount > 1){
                if (nums[left] == 0) {
                    flipCount--;
                }
                left++;
            }
            maxCount = Math.max(maxCount, right - left + 1);
        }
        return maxCount;
    }

    public static int longestOnes(int[] nums, int k) {
        int maxCount = 0, flipCount = 0;

        for (int left = 0, right = 0; right < nums.length; right++) {
            if (nums[right] == 0){
                flipCount++;
            }
            while (flipCount > k){
                if (nums[left] == 0) {
                    flipCount--;
                }
                left++;
            }
            maxCount = Math.max(maxCount, right - left + 1);
        }
        return maxCount;
    }
}
