package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] nums2 = {1,1,2};
        System.out.println(permuteUnique(nums2));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result,used,new ArrayList<>(),nums);
        return new ArrayList<>(result);
    }

    private static void backtrack(List<List<Integer>> result, boolean[] used, List<Integer> list, int[] nums ){
        if (list.size()==nums.length){
            result.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;  // Takrorni oldini olish
            }

            list.add(nums[i]);
            used[i] = true;
            backtrack(result, used, list, nums);
            list.removeLast();
            used[i] = false;

        }
    }
}
