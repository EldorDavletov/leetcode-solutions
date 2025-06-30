package string;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};

        System.out.println(getAllSubarrays(nums));

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> list = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    list.add(nums[k]);
                }
                res.add(new ArrayList<>(list));
            }
        }

        System.out.println(res);
    }

    public int kthFactor(int n, int k) {
        int kthFactor = 1;
        for(int i = 1; i <= n/2; i++){
            if (n % i == 0){
                kthFactor = i;
                k--;
                if (k == 0) return kthFactor;
            }
        }
        return k > 1 ? -1 : n;
    }

    public static List<List<Integer>> getAllSubarrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        for (int start = 0; start < n; start++) {
            List<Integer> subarray = new ArrayList<>();
            for (int end = start; end < n; end++) {
                subarray.add(arr[end]);
                result.add(new ArrayList<>(subarray));
            }
        }
        return result;
    }
}
