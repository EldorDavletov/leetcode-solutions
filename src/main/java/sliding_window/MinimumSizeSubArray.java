package sliding_window;

public class MinimumSizeSubArray {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int left = 0, right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum>=target){
                minLen = Math.min(minLen,right-left+1);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE? 0:minLen;
    }
}
