package array;

public class LongestContinuousSubSequence {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7};
        System.out.println(findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums) {
        int maxLen = 1,len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]){
                len++;
                maxLen = Math.max(len,maxLen);
            }else {
                len = 1;
            }

        }
        return maxLen;
    }
}
