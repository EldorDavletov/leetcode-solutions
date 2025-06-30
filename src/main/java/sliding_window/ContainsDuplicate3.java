package sliding_window;

import java.util.TreeSet;

public class ContainsDuplicate3 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsNearbyAlmostDuplicate(nums,3,0));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length == 0 || indexDiff <= 0 || valueDiff < 0) return false;

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long) nums[i] + valueDiff);
            Long ceil = set.ceiling((long) nums[i] - valueDiff);

            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])) {
                return true;
            }

            set.add((long) nums[i]);

            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}
