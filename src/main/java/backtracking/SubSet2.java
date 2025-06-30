package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet2 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Duplicate ni tekshirish uchun kerak
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(),nums,0);
        return result.stream().toList();
    }

    public static void backtrack(List<List<Integer>> result,List<Integer> current,int[] nums,int start){
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;

            current.add(nums[i]);
            backtrack(result,current,nums,i+1);
            current.removeLast();
        }
    }
}
