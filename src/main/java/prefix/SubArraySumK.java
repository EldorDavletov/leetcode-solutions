package prefix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumK {
    public static void main(String[] args) {
        int [] nums = {1,2,1,2,1};
        System.out.println(subarraySum(nums,3));
    }

    public static int subarraySum0(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n ; j++) {
                if (prefix[j]-prefix[i] == k){
                    count++;
                }
            }
        }

        System.out.println(Arrays.toString(prefix));

        return count;
    }

    public static int subarraySum1(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        int[] prefix = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }


        for (int i = 1; i <= n; i++) {

            if (map.containsKey(prefix[i] - k)) {
                count += map.get(prefix[i] - k);
            }

            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }

        return count;
    }



    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
