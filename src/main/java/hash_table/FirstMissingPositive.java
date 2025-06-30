package hash_table;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public static void main(String[] args) {

    }

    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = nums[0];
        for (int num : nums){
            max = Math.max(max,num);
            set.add(num);
        }
        if (max < 0) return 1;

        for (int i = 1; i < max ; i++) {
            if (!set.contains(i)) return i;
        }

        return max + 1;
    }

    public static int firstMissingPositive2(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]){
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;

            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1){
                return i + 1;
            }
        }

        return n + 1;
    }
}
